package servlet;


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class EditServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("name", rs.getString("name"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("course", rs.getString("course"));
            }

            RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}