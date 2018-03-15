<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html>
<html>

<head>
  <title>Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<table align="center"  width="70%"  class="table table-hover table-condensed table-bordered">  
<br><br>
<tr><th>Products Images</th><th>Name of the Products</th><th>Action</th></tr>  
   <c:forEach var="product" items="${productList}">   
   <tr>  
   <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td> 
   <td>${product.productName}</td>  
        
  
   <td><a class="btn btn-info" href="${pageContext.request.contextPath}/showproduct/${product.productId}">Show</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>
  
     </div>
</body>
</html>