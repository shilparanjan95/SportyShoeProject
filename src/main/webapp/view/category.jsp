<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
        <%@ include file="adminlinks.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%List<Category> clit = (List<Category> )request.getAttribute("category"); %>
<div align="center">
<form action="/ct">
<input type="Submit" value=" add Category">
</form>

<table border="1px">
<tr><th>ID</th>
<th>Name</th>
<th colspan="2">action</th></tr>
<%
for(Category  c: clit)
{
%>
<tr><td><%= c.getId() %></td>
<td><%= c.getCategoryName() %></td>
<td><form action="/category/<%= c.getId() %>" method="post">
<input type="submit" value="Delete">
</form></td>
<td><form action="/edit/category" method="post">
<input type="hidden" name="ct" value="<%= c.getId() %>">
<input type="submit" value="Edit">
</form></td>

</tr>
<%
}%>
</table>
</div>
</body>
</html>