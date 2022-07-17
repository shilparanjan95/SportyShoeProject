<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.User"%>
    <%@ include file="adminlinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<div align="center">
<% User user = (User)request.getAttribute("user");  %>
<h3> Welcome Admin <%=user.getName() %></h3>
<h3><%=user.getEmail() %></h3>


<h4>No of Users <%= request.getAttribute("userCount") %></h4>
<a href="/userlist">Registered Users</a>
</div>
</body>
</html>