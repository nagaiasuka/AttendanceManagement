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

@WebServlet("/WorkingTimeDeleteServlet")
public class WorkingTimeDeleteServlet extends HttpServlet {
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
			
			//データの受取
			String calendar_id = request.getParameter("calendar_id");
			String dating = request.getParameter("dating");
			
			// 現在のデータがあるか取得
			String deletesql = "delete FROM `work_ record` WHERE user_id =? AND calendar_id =?;";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(deletesql)){
					statement.setInt(1, loginId);
					statement.setString(2, calendar_id);
					statement.executeUpdate();
					connection.close();

			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				request.setAttribute("message","Exception:"+e.getMessage());
			}
			response.sendRedirect("/attendanceManagement/show?calendar_id="+ calendar_id +"&dating="+dating);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
}