<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.sporty.shoes.SportyShoe.model.*" %>
     <%@ include file="userLinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
 <%List<Category> cate = (List<Category> )request.getAttribute("category");
session.setAttribute("category", cate);
%>
<div align="left">
<h3>Select Category to browse</h3>
<ol>
<% for(Category c : cate) { %>
<li><a href="/product/<%=c.getId() %>"><%=c.getCategoryName() %></a></li>
<%} %>
</ol>
</div> 
<%! int count =0; String m=""; %>
<% if(request.getAttribute("message")!=null && request.getAttribute("count")!=null) {

	 m =request.getAttribute("message").toString();
	 count = (Integer)request.getAttribute("count");
}%>
<% 
%>
<%-- <% if(count!=0 && !m.equals(""))  {  %>
<%= count +" "+m %>
<%} %> --%>
<%List<Product> products = (List<Product> )request.getAttribute("product"); %>
<div align="center">


<table border="1px">
<%if(products!=null ){ %>
<tr>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Category</th>
<th>Select size</th>
<th>Select Quantity</th>
<th colspan="1">action</th></tr>
<%}  %>
<%-- 
<tr>No product availabe in this category</tr>
<%} %> --%>
<%
for(Product  c: products)
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
<input type="hidden" name="cid" value="<%= request.getAttribute("categoryId")   %>">
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