<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
<div class="container">
 <div class="row">
 <div class="col-sm-6 item-photo">
<img style="max-width:100%; margin-top:30 px;" src="${pageContext.request.contextPath}/${product.productImage}">
</div>
<div class="col-md-6" style="border:0px solid gray">

              <h2><label>${product.productName}</label></h2>
              <h3>${product.productDescription }</h3>
              <h3>${product.stock}</h3>
              <h3>${product.price }</h3>
              <h4>${product.productCategories.categoriesName}</h4> <br> 




   <br><br>
     <a href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="btn btn-info btn-lg">
     <span class="glyphicon glyphicon-shopping-cart"></span>addToCart</a>
     <h5><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer;">Wish List</span></h5>
     </div>
     </div>
     </div>
     
     <div class="col-xs-9">
     <ul class="menu-items">
     <br><li>100% Original Product...</li>
     </ul>
     </div>
     
</body>
</html>
