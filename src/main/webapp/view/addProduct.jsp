<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
     <%@ include file="links.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<%List<Category> cate = (List<Category> )request.getAttribute("category"); %>

<div align="center">
<form action="addProduct" method="post">
<table border="">
<tr><td colspan="2">Add Product</td></tr>

<tr><td>name</td><td><input type="text" name="name"> </td></tr>
<tr><td>price</td><td><input type="number" name="price"></td></tr> 
<tr><td>gender</td><td><select name="gender">
<option value="male">Male</option>
<option value="female">Female</option>
 </select><br>
<tr><td>Category</td><td><select name="category">
<%for(Category ct :cate) { %>
<option value="<%= ct.getId()%>"> <%= ct.getCategoryName() %></option>
<%} %>
 </select></td></tr>
<tr><td colspan="2"><input type="submit" value="AddProduct"></td></tr>
</table>
</form>
</div>
</body>
</html>