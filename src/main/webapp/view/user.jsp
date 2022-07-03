<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.User"%>
         <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<%List<Category> cate = (List<Category> )request.getAttribute("category"); %>

<% User user = (User)request.getAttribute("user");  %>
<%session.setAttribute("user", user) ;%>
<h3> Welcome User <%=user.getName() %></h3>
<h3><%=user.getEmail() %></h3>
<a href="/logout">Logout</a>
<!-- <a href="/changepassword">change password</a> -->

<a href="/cart">Cart</a>
<a href="/order">Order</a>
<h3>Select Category to browse</h3>
<ol>
<% for(Category c : cate) { %>
<li><a href="/product/<%=c.getId() %>"><%=c.getCategoryName() %></a></li>
<%} %>
</ol>
</body>
</html>