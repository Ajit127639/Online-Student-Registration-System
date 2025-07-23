package servlet;



import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ResetServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();

            // Delete all rows
            stmt.executeUpdate("DELETE FROM students");

            // Reset auto-increment ID to 1
            stmt.executeUpdate("ALTER TABLE students AUTO_INCREMENT = 1");

            response.sendRedirect("view"); // Go back to view page
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
