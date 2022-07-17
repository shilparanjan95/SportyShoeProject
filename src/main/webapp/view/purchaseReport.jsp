<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="adminlinks.jsp" %>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Report</title>
</head>
<body>
<div align="center">

<table border="1px">
<tr>
<th>User Email</th>
<th>User Name</th>
<th>Product Name</th>
<th>Product Category</th>
<th>Price</th>
<th>Order Date</th>
</tr>
<%List<Purchase> plist =(List<Purchase>) request.getAttribute("purchase");
for(Purchase p: plist) {
	for(Product pp: p.getOrder().getProduct()) {

%>
<tr>
<td><%= p.getOrder().getUser().getEmail() %></td>
<td><%= p.getOrder().getUser().getName() %></td>
<td><%= pp.getName() %></td>
<td><%= pp.getCategory().getCategoryName() %></td>
<td><%= pp.getPrice() %></td>
<td><%= p.getPurchaseDate() %>
</tr>
<%}} %>
</table>
</div>
</body>
</html>