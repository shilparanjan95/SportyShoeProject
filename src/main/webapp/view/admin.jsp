<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<% User user = (User)request.getAttribute("user");  %>
<h3> Welcome Admin <%=user.getName() %></h3>
<h3><%=user.getEmail() %></h3>
<a href="/logout">Logout</a>
<a href="/changepassword">change password</a>

<a href="/products">Products</a>
<a href="/category">Categories</a>

<h4>No of Users <%= request.getAttribute("userCount") %></h4>
<a href="/userlist">List of users</a>
</body>
</html>