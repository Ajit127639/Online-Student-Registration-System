package servlet;



import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class UpdateServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, id);

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("view"); // Redirect to view all students
            } else {
                response.getWriter().println("Update failed!");
            }

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
