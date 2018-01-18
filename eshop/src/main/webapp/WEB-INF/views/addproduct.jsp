<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="context" value="${pageContext.request.contextPath}"></c:set> 

<!DOCTYPE html>
<html>

<head>
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Admin Add_Products</title>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
</style>

</head>



<div class="container">
 <div class="row" >
  <div align="center"  width="70%"  class="table table-hover table-condensed table-bordered"> 
<div class="col-sm-6" >
  <h1><span class="label label-success"><b>Add New Product</b></span></h1>
          
       <form:form method="post" action="${context}/saveProduct"  enctype="multipart/form-data">    
        <table class="table">    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName" required="true" /></td>  
         </tr>    
         <tr>    
          <td>Price :</td>    
          <td><form:input path="productPrice" required="true" /></td>  
         </tr> 
         <tr> 
         <form:select class="form-control" path="productCategory.categoryId">
         <c:forEach items="${categoryList}" var="productCategory">
         <form:option value="${productCategory.categoryId}">
         ${productCategory.categoryName}
         </form:option>
         </c:forEach>
         </form:select><br></tr>
         
         <tr>    
          <td><form:hidden path="productImage"/></td>     
         </tr> 
         <tr>    
          <td>Choose Image : </td>   
          <td><input type="file" name="file"/></td>  
         </tr>
         
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save"  class="btn btn-warning"/></td>    
         </tr>    
        </table>    
      </form:form>  
</div>

</div>
</div></div>