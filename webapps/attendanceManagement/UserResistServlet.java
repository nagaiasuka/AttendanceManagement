import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/UserResistServlet")
public class UserResistServlet extends HttpServlet {
   	//ログイン画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");


		System.out.println(name);
		String url = "jdbc:mysql://localhost:3306/attendanceManagement";
		String user = "root";
		String dbpass = "password";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		String sql = "INSERT into users (name,mail,password) values(?,?,?);";
		try(
			Connection connection = DriverManager.getConnection(url, user, dbpass);
			PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(1, name);
				statement.setString(2, mail);
				statement.setString(3, password);
		}catch (Exception e) {
			request.setAttribute("message","Exception:"+e.getMessage());
		}

			String view = "./WEB-INF/views/login.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
}