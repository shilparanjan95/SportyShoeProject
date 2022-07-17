<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%! int userId = 0;%>
<% if(request.getAttribute("userId")!=null){userId =(Integer)request.getAttribute("userId");} %>
 
<%--  <%   if(session.getAttribute("user")!=null){userId =(Integer)((User)session.getAttribute("user")).getUserid();} %>
 --%> <div align="right">
<a href="/user.jsp">Home</a>
<a href="/cart/<%= userId%>">Cart</a>
<a href="/orders/<%= userId%>">My Orders</a>
<a href="/logout">Logout</a>
</div>
</body>
</html>