<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.User"%>
         <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
         <%@ include file="userLinks.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user Home</title>
</head>
<body>
<div align="center">
<%List<Category> cate = (List<Category> )request.getAttribute("category");
session.setAttribute("category", cate);
%>

<% User user = (User)request.getAttribute("user");  %>
<%session.setAttribute("user", user) ;%>
<h3> Welcome User <%=user.getName() %></h3>
<h3><%=user.getEmail() %></h3>

<h3>Select Category to browse</h3>
<ol>
<% for(Category c : cate) { %>
<li><a href="/product/<%=c.getId() %>"><%=c.getCategoryName() %></a></li>
<%} %>
</ol>

</div>
</body>
</html>