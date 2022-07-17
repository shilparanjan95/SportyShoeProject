<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.sporty.shoes.SportyShoe.model.*,java.util.*" %>
    <%@ include file ="userLinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Details</title>
</head>
<body>
<% if(request.getAttribute("order")!=null) {
 Order o = (Order)request.getAttribute("order"); %>
<% List<Product> plist = (List<Product>)o.getProduct(); %>
<table border="1px">
<tr>
<td colspan="5">Shopping Cart Details</td>
</tr>
<tr>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Size</th>
<th>Product Quantity</th>
<th>Action</th>

</tr>
<%for (Product p: plist){ %>
<tr>
<td><%=p.getName() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getSize()  %></td>
<td><%= p.getQuantity() %></td>
<form action="/deleteProduct/<%= p.getId()%>/<%= o.getOrderId()%>/<%=o.getUser().getUserid() %>" method="post" >
<td><input type="submit" value="Remove From Cart"></td>
</form>
</tr>
<%} %>
<h4></h4>

<form action="/billing" method="post" >

<input type ="hidden" name="order" value="<%= o.getOrderId()%>">
<input type ="hidden" name="username" value="<%= o.getUser().getName()%>">

<tr><td>Total Price</td><td ><input type="text" value="<%= o.getTotalPrice()
%>" readonly="true"><td colspan="3"><input type="submit" value="Buy the Product"></td></tr>
<%} %>
</form>
<%if(request.getAttribute("order")==null){ %>

<tr>Your Cart is Empty</tr>
<%} %>
</table>
</body>
</html>