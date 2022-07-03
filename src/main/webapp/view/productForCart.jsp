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


<table border="1px">
<tr>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Category</th>
<th>Select size</th>
<th>Select Quantity</th>
<th colspan="1">action</th></tr>
<%
for(Product  c: clit)
{
%>
<tr>
<form action="/addToCart/<%= c.getId() %>" method="post">
<td><%= c.getName() %></td>
<td><%= c.getPrice() %></td>
<td><%= c.getCategory().getCategoryName()%></td>
<td><select name="size"> <option value="S">S</option> 
<option value="M">M</option>
<option value="L">L</option>
</select></td>
<td><select name="quantity"> 
<% for(int i=1;i<11;i++) {%>
 <option value="<%=i%>"><%= i %></option> 
<% }%>
</select></td>
<td>
<% User u =(User) session.getAttribute("user"); %>
<input type="hidden" name="uid" value="<%= u.getUserid()   %>">
<input type="submit" value="Add To Cart">
</form></td>


</tr>
</tr>
<%
}%>
</table>
</div>
</body>
</html>