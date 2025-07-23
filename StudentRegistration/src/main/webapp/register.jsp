<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Student Registration</title></head>
<body>
    <h2>Student Registration Form</h2>
    <form action="register" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        <input type="submit" value="Register">
    </form>
    <br>
    <a href="view">View Students</a>
</body>
</html>