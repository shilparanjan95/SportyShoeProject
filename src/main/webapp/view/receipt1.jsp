<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.sporty.shoes.SportyShoe.model.*,java.util.*" %>
    <%@ include file ="userLinks.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align ="center">
<table border="1px">
<tr><td colspan="3">Order Details</td></tr>
 <tr><th>Product Name</th>
 <th>Product Quantity</th>
<th>Product Price</th>
 </tr>
<%List<Purchase> pp =(List<Purchase>) request.getAttribute("plist"); 
for(Purchase puchase :pp){
List<Product> plist = puchase.getOrder().getProduct();
 %>


 
 
 <% for(Product p :plist) { %>
 <tr>
 <td><%=p.getName() %> </td>
 <td><%= p.getQuantity() %></td>
 <td><%=p.getPrice() %></td>
 </tr>
 <%} %>
 <%} %>
 </table>
 </div>
</body>
</html>