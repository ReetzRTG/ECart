<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 
<!DOCTYPE html >
<html>
<head>

 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
 <div class="container">
 <div class="row">
<div class="col-md-6" style="border:0px solid gray">
 
<h3> ${successMessage}</h3>  
  
<h1><b>Product List</b></h1>  
<table align="center"  width="70%"  class="table table-hover table-condensed table-bordered table-responsive">  
<tr><th>Id</th><th>Name</th><th>Description</th><th>Price</th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr> 
   <td>${product.productId}</td>   
   <td>${product.productName}</td>  
   <td>${product.productDescription}</td>  
   
   <td>${product.price}</td> 
   
   <td>${product.productImage }</td> 
  
  <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td>
   <td><a href="${pageContext.request.contextPath}/discontinueproduct/${product.productId}"><button type="button" class="btn btn-danger">Discontinue</button></a></td>
  <td><a href="${pageContext.request.contextPath}/updateproduct/${product.productId}"><button type="button" class="btn btn-success">Edit</button></a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   
    
    </div>
    </div>
    </div>
    </body>
    </html>