<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
    int id = (Integer) request.getAttribute("id");
    String name = (String) request.getAttribute("name");
    String email = (String) request.getAttribute("email");
    String course = (String) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head><title>Edit Student</title></head>
<body>
    <h2>Edit Student</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        Name: <input type="text" name="name" value="<%= name %>" required><br><br>
        Email: <input type="email" name="email" value="<%= email %>" required><br><br>
        Course: <input type="text" name="course" value="<%= course %>" required><br><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>