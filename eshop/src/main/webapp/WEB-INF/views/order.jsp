<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
    
    <jsp:include page="header.jsp"></jsp:include>
    
<!DOCTYPE html>




<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>Order</title>



<section id="do_action">
 
 <div class="container">
<table align="center"  width="70%"  class="table table-hover table-condensed table-bordered"> 
 
 <div class="row">
 <div class="col-sm-12">
 <div class="total_area">
 <ul>
 
 <div class="col-md-6" style="border:0px solid gray">
 <li><h3><label>Total<span>&#x20B9; ${grandTotal}</span></label></h3></li><br>
 <form:form action="addToOrderDetails" method="post">
 <li>Address<form:textarea rows="5" required="true" placeholder="Address" path="orderDetailsAddress" class="form-control"></form:textarea></li>
 <li>Area PIN Code<form:input path="orderDetailsPin" class="form-control" placeholder="PIN Code"  required="true" pattern="\d{6,6}"></form:input></li>
 <form:hidden path="orderDetailsTotal"/><br>
 <input type="submit" class="btn btn-success" value="Proceed">
 
 </form:form>
 
 </div>
 </ul>
</div>
</div>
</div>

</table>

 </div>

</section>
</head>
</body>
</html>