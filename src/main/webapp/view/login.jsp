<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<div align="center">
<form action="loginUser" >
<%
if(request.getAttribute("msg")!=null)
{
	
%>
<%= request.getAttribute("msg")%>
<% 
}
%><br><br>
<table border="1px">
<tr><td colspan="2">Login Page</td></tr>
<tr><td>username</td><td><input type="text" name="name"> </td></tr>
<tr><td>password</td><td><input type="password" name="password"></td></tr>
<tr><td colspan="2"><input type="submit" value="login"></td></tr>
<tr><td colspan="2">New User <a href="/">Register here</a></td></tr>
</table>
</div>
</form>
</body>
</html>