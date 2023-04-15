import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
   	//従業員一覧を表示させる		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/attendanceManagement";
		String user = "root";
		String dbpass = "password";
		
		//ログイン情報確認
		HttpSession session = request.getSession();
		String loginFlg = (String)session.getAttribute("loginFlg");
		Integer loginId = (Integer)session.getAttribute("loginId");

		if(loginFlg == null || loginFlg==""){
			String redirectUrl = "/attendanceManagement/login";
			response.sendRedirect(redirectUrl);
		}else{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			//データの取得
			String sql = "SELECT * FROM calendar";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()){
				
					List<Integer> idList = new ArrayList<>();
					HashMap<Integer,Integer> daringMap = new HashMap<Integer,Integer>();
					HashMap<Integer,Integer> weekMap = new HashMap<Integer,Integer>();
	
					while(results.next()){
						int calendar_id = results.getInt("calendar_id");
						Integer dating = results.getInt("dating");
						Integer week = results.getInt("week");
						   
						//データの投入
						idList.add(calendar_id);
						daringMap.put(calendar_id, dating);
						weekMap.put(calendar_id, week);
					}
					
					//jspにデータを渡す
					request.setAttribute("idList",idList);
					request.setAttribute("daringMap",daringMap);
					request.setAttribute("weekMap",weekMap);
					request.setAttribute("loginId",loginId);
			}catch (Exception e) {
				request.setAttribute("message","Exception:"+e.getMessage());
			}
	
			String work_record_select_sql = "SELECT * FROM `work_ record` WHERE user_id = ?";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(work_record_select_sql)){
					statement.setInt(1, loginId);

					ResultSet results = statement.executeQuery();

					List<Integer> calendarIdList = new ArrayList<>();
					HashMap<Integer,Long> startTimeMap = new HashMap<Integer,Long>();
					HashMap<Integer,Long> endTimeMap = new HashMap<Integer,Long>();
	
					while(results.next()){
						int time_calendar_id = results.getInt("calendar_id");
						Long start_time = results.getLong("start_time");
						Long end_time = results.getLong("end_time");

							//データの投入
						calendarIdList.add(time_calendar_id);
						startTimeMap.put(time_calendar_id, start_time);
						endTimeMap.put(time_calendar_id, end_time);
					}
					
					//jspにデータを渡す
					request.setAttribute("startTimeMap",startTimeMap);
					request.setAttribute("endTimeMap",endTimeMap);
					
				
				
			}catch (Exception e) {
				System.out.println(e);
				request.setAttribute("message","Exception:"+e.getMessage());
			}
	
		//カレンダー画面の表示
		String view = "./WEB-INF/views/calendar.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
}