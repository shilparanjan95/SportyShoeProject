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
<%Purchase pp =(Purchase) request.getAttribute("p"); 

List<Product> plist = pp.getOrder().getProduct();
 %>


 
 <table border="1px">
 <tr><td colspan="3">Order Details</td></tr>
 <tr><th>Product Name</th>
 <th>Product Quantity</th>
<th>Product Price</th>
 </tr>
 <% for(Product p :plist) { %>
 <tr>
 <td><%=p.getName() %> </td>
 <td><%= p.getQuantity() %></td>
 <td><%=p.getPrice() %></td>
 </tr>
 <%} %>
 </table>
</body>
</html>