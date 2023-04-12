import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.TextUI;
import javax.xml.crypto.Data;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/WorkingTimeResistServlet")
public class WorkingTimeResistServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			
			//データの受取
			String calendar_id = request.getParameter("calendar_id");
			String dating = request.getParameter("dating");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			//バリデーション
			List<String> caveatList = new ArrayList<>();
			if(calendar_id == null || dating ==null){
				caveatList.add("日程の取得ができませんでした。最初からやり直してください。");
			}
			boolean caveatFlg = false; 
			if(caveatList.size()!=0){
				caveatFlg = true;
			}
			// 現在のデータがあるか取得
			String selectsql = "SELECT * FROM `work_ record` WHERE user_id = ? and calendar_id =?;";
			String insertSql = "INSERT INTO `work_ record` (user_id,calendar_id,start_time,end_time) values (?,?,?,?);";
			String updateSql = "update `work_ record` set start_time = ? , end_time = ? WHERE user_id = ? AND calendar_id  = ?;";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(selectsql)){
					statement.setInt(1, loginId);
					statement.setString(2, calendar_id);

					ResultSet results = statement.executeQuery();
				
					
					Long getStartTime = null;
					Long getEndTime = null;
					while(results.next()){
						
						getStartTime = results.getLong("start_time");
						getEndTime = results.getLong("end_time");
					}
				
					if(getStartTime == null || getEndTime == null){
						//新規登録
						System.out.println("sinnki");
						String formatStartTime = null;
						if(!startTime.isEmpty() || startTime != null ){
							formatStartTime = startTime.replace(":", "");
						}
						String formatEndTime = null;
						if(!endTime.isEmpty()){
							formatEndTime = endTime.replace(":", "");
						}
						PreparedStatement insertStatement = connection.prepareStatement(insertSql);
							insertStatement.setInt(1, loginId);
							insertStatement.setInt(2, Integer.valueOf(calendar_id));
							insertStatement.setLong(3, Integer.valueOf(formatStartTime));
							insertStatement.setLong(4, Integer.valueOf(formatEndTime));
							insertStatement.executeUpdate();
							connection.close();
						
					}else{
						//更新処理
						String formatStartTime = null;
						if(!startTime.isEmpty()){
							formatStartTime = startTime.replace(":", "");
						}else{
							formatStartTime = String.valueOf(getStartTime);
						}
						String formatEndTime = null;
						if(!endTime.isEmpty()){
							formatEndTime = endTime.replace(":", "");
						}else{
							formatEndTime = String.valueOf(getEndTime);
						}
						PreparedStatement updateStatement = connection.prepareStatement(updateSql);
							updateStatement.setLong(1, Integer.valueOf(formatStartTime));
							updateStatement.setLong(2, Integer.valueOf(formatEndTime));
							updateStatement.setInt(3, loginId);
							updateStatement.setInt(4, Integer.valueOf(calendar_id));
							updateStatement.executeUpdate();
							connection.close();

					}
					connection.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
				request.setAttribute("message","Exception:"+e.getMessage());
			}
			if(caveatFlg){
				request.setAttribute("caveatList",caveatList);
				String view = "./WEB-INF/views/error.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}else{
				response.sendRedirect("/attendanceManagement/show?calendar_id="+ calendar_id +"&dating="+dating);		
			}
		}
	}
}