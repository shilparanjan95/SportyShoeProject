<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
     <%@ include file="adminlinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
<%List<Category> cate = (List<Category> )request.getAttribute("category"); %>
 <% Product p = (Product)request.getAttribute("product") ;%>
<div align="center">
<form action="/editProduct" method="post">
<table border="">
<tr><td colspan="2">Update  Product</td></tr>
<input type="hidden" name="id" value="<%= p.getId()%>">
<tr><td>name</td><td><input type="text" name="name" value="<%= p.getName()%>"> </td></tr>
<tr><td>price</td><td><input type="number" name="price" value="<%= p.getPrice() %>"></td></tr> 
<tr><td>gender</td><td><select name="gender" value="<%= p.getGender()%>">
<option value="male">Male</option>
<option value="female">Female</option>
 </select><br>
 <tr><td>Category</td><td><select name="category" value="<%= p.getCategory().getId()%>">
<%for(Category ct :cate) { %>
<option value="<%= ct.getId()%>"> <%= ct.getCategoryName() %></option>
<%} %> 
 </select></td></tr>
<tr><td colspan="2"><input type="submit" value="UpdateProduct"></td></tr>
</table>
</form>
</div>
</body>
</html>