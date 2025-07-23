package servlet;


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (name, email, course) VALUES (?, ?, ?)");
            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("email"));
            ps.setString(3, request.getParameter("course"));
            ps.executeUpdate();
            con.close();
            response.sendRedirect("view");
        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}