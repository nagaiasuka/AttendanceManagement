import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.TextUI;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
   	//ログイン画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		//バリデーション
		List<String> caveatList = new ArrayList<>();
		
		if(mail == null || mail == ""){
			caveatList.add("メールが入力されていません。");
		}

		if(password == null || password==""){
			caveatList.add("パスワードが入力されていません。");
		}
	
		String view=null;
		//警告があるか
		boolean caveatFlg = false; 
		if(caveatList.size()!=0){
			caveatFlg = true;
		}
	
		String url = "jdbc:mysql://localhost:3306/attendanceManagement";
		String user = "root";
		String dbpass = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM users WHERE mail = ?";
		try(
			Connection connection = DriverManager.getConnection(url, user, dbpass);
			PreparedStatement statement = connection.prepareStatement(sql)){
				
				statement.setString(1, mail);
				ResultSet results = statement.executeQuery();

				while(results.next()){
					int id = results.getInt("id");
					String getMail = results.getString("mail");
					String getPass = results.getString("password");
					System.out.println(getPass);
				}
				statement.executeUpdate();


				connection.close();

		}catch (Exception e) {
			request.setAttribute("message","Exception:"+e.getMessage());
		}

		if(caveatFlg){
			request.setAttribute("caveatList",caveatList);
			view = "./WEB-INF/views/error.jsp";
		}else{
			view = "./WEB-INF/views/list.jsp";
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
}