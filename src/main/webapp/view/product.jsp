<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%List<Product> clit = (List<Product> )request.getAttribute("product"); %>
<div align="center">
<form action="/product">
<input type="submit" value=" add Product">
</form>

<table border="1px">
<tr><th>Product ID</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Category</th>
<th colspan="2">action</th></tr>
<%
for(Product  c: clit)
{
%>
<tr><td><%= c.getId() %></td>
<td><%= c.getName() %></td>
<td><%= c.getPrice() %></td>
<td><%= c.getCategory().getCategoryName()%></td>

<td><form action="/DeleteProduct/<%= c.getId() %>" method="post">
<input type="submit" value="Delete">
</form></td>
<td><form action="/edit/prouct" method="post">
<input type="hidden" name="p" value="<%= c.getId() %>">
<input type="submit" value="Edit">
</form></td>

</tr>
</tr>
<%
}%>
</table>
</div>
</body>
</html>