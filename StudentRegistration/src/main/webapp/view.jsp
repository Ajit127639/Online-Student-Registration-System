<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    ResultSet rs = (ResultSet) request.getAttribute("data");
%>
<h2>Student List</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th></tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("email") %></td>
        <td><%= rs.getString("course") %></td>
        <td>
            <a href="edit?id=<%= rs.getInt("id") %>">Edit</a> |
            <a href="delete?id=<%= rs.getInt("id") %>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="register.jsp">Add New Student</a>&nbsp &nbsp &nbsp
<a href="reset" onclick="return confirm('Are you sure you want to reset the database?');">
    <button>Reset Database</button>
</a>
</body>
</html>