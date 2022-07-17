<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>    
        <%@ include file="adminlinks.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users list</title>
</head>
<body>
<div align="center">
<%List<User>  userlIst = (List<User>)request.getAttribute("users");%>
<table border="2px">
<tr><td colspan="3">Users List</td></tr>
<tr>
<th>UserId</th>
<th>Name</th>
<th>Email</th>
</tr>
<% for( User u :userlIst)
{%>
<tr>
<td><%= u.getUserid() %></td>
<td><%= u.getName() %></td>
<td><%= u.getEmail() %></td>

</tr>
<%} %>
</table>
</div>
</body>
</html>