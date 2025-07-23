package servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ViewServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            request.setAttribute("data", rs);
            RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}