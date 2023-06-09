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

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
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
		String calendar_id =request.getParameter("calendar_id");
		String dating = request.getParameter("dating");
		if(loginFlg == null || loginFlg==""){
			String redirectUrl = "/attendanceManagement/login";
			response.sendRedirect(redirectUrl);
		}else{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			String work_record_select_sql = "SELECT * FROM `work_ record` WHERE user_id = ? AND calendar_id =?";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(work_record_select_sql)){
					statement.setInt(1, loginId);
					statement.setInt(2, Integer.parseInt(calendar_id));

					ResultSet results = statement.executeQuery();

					Long start_time=null;
					Long end_time=null;
					while(results.next()){
						start_time = results.getLong("start_time");
						end_time = results.getLong("end_time");
					}
					//jspにデータを渡す
					request.setAttribute("startTime",start_time);
					request.setAttribute("endTime",end_time);
			}catch (Exception e) {
				System.out.println(e);
				request.setAttribute("message","Exception:"+e.getMessage());
			}
			request.setAttribute("dating",dating);
			request.setAttribute("calendar_id",calendar_id);

		
		//カレンダー画面の表示
		String view = "./WEB-INF/views/show.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
}