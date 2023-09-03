package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.catalina.connector.Response;
import org.apache.catalina.filters.RestCsrfPreventionFilter;

import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/registerProcess")
public class RegisterBackend extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("userName");
		String user_email = req.getParameter("userEmail");
		String user_pass = req.getParameter("userPass");
		String user_gender = req.getParameter("userGender");
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Piyush*123");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO register VALUE (?,?,?,?)");
			ps.setString(1, user_name);
			ps.setString(2, user_email);
			ps.setString(3, user_gender);
			ps.setString(4, user_pass);
			int count = ps.executeUpdate();
			
			if(count > 0) {
				resp.setContentType("text/html");
				out.println("<h3 style='color:green'>Account has been created successfully, please login</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
			}
			else {
				out.println("<h3 style='color:red'>Something went wrong please try again</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
				
			}
		} 
		catch (Exception e) {
			out.println("<h3 style='color:red'>The email id is already registered, please login to your account</h3>");
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
	}	
}
