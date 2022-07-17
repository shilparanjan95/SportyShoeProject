<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<div align="center">
<form action="register" method="post">
<table border="2px ">
<tr><td colspan="2">Registration Page</td></tr>

<tr><td>username</td><td><input type="text" name="name" required></td> </tr>
<tr><td>email</td><td><input type="email" name="email" required></td></tr>
<tr><td>role</td><td><select name="type" required>
<option value="user">User</option>
<option value="admin">Admin</option>
 </select></td></tr>
<tr><td>password</td><td><input type="password" name="password" required></td></tr>
<tr><td colspan="2"><input type="submit" value="register"></td></tr>
<tr><td colspan="2">Existing User <a href="/login">Login</td></tr>
</table>
</form>
</div>
</body>
</html>