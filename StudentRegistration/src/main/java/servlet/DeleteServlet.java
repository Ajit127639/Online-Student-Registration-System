package servlet;



import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class DeleteServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?");
            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("view"); // After deletion, show updated list
            } else {
                response.getWriter().println("Delete failed!");
            }

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}