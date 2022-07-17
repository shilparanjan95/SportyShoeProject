<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePassword</title>
</head>
<body>
<div align="center">
<form action="pwdUpdate" method="post">
<table border="2px">
<tr>
<td>Username</td><td><input type="text" name="name"> </td><tr>
<tr><td>Password</td><td><input type="password" name="password"></td></tr>
<tr><td>ConFirm Password</td><td><input type="password" name="password1"></td>
</tr><tr>
<td colspan="2">
<input type="submit" value="Submit">
</td>
</tr>
</table>
</div>
</form>
</body>
</html>