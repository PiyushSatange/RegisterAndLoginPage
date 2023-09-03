package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logInProcess")
public class LoginBackend extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_email = req.getParameter("userEmail");
		String user_pass = req.getParameter("userPass");
		System.out.println(user_email);
		System.out.println(user_pass);
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Piyush*123");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM register WHERE email=? AND pass=?");
			ps.setString(1, user_email);
			ps.setString(2, user_pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				resp.setContentType("text/html");
				out.println("<h3 style='color:green'>Login successfull</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				HttpSession hs = req.getSession();
				hs.setAttribute("SessionName",rs.getString("name"));
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				out.println("<h3 style='color:red'>Email id and password didn't match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			out.println(e);
		}
	}
}
