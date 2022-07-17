<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sporty.shoes.SportyShoe.model.*" %>
    <%@ include file="userLinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing</title>
</head>
<body>
<div align="center">

<form action="/checkout" method="post">
<table border="2px ">
<tr><td colspan="2">Billing Details</td></tr>

<%-- <tr><td>Username</td><td><input type="text" name="<%= request.getAttribute("username") %>" readonly="readonly"></td> </tr>
 --%><tr><td>House No</td><td><input type="text" name="houseNo" required ></td></tr>
<tr><td>street No</td><td><input type="number" name="street" required></td></tr>
<tr><td>Pin Code</td><td><input type="number" name="pincode" required></td></tr>
<tr><td>State</td><td><input type="text" name="state" required></td></tr>
<!-- <tr><td>Conatct</td><td><input type="number" name="number"></td></tr>
 -->

<tr><td><input type="hidden" name="order" value="<%=request.getAttribute("order") %>"></td></tr>
<tr><td colspan="2"><input type="submit" value="Pay now"></td></tr>
</table>
</form>
</div>
</body>
</html>