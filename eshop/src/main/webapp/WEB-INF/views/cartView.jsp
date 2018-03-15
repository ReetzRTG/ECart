<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
    <title>Cart_view</title>
    
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
    
    <jsp:include page="header.jsp"></jsp:include> 
    
     <c:if test="${cartItems.isEmpty()}">
    <div class="container">
    <div class="alert alert-success alert-dismissable">
    <a href="#" class="close" data-dimiss="alert" aria-label="close">&times;</a>
    <strong>No items present .</strong>
    </div>
    </div>
    
    </c:if> 
    
    <div class="container">
<table class="table table-hover table-condensed ">  
    
    <div class="table-responsive cart_info">
    
    <thead>
    <tr class="cart_menu">
    <td class="image">Item</td>
    <td class="description">Description</td>
    <td class="price">Price</td>
    <td class="quantity">Quantity</td>
    <td class="total">Total</td>
    <td></td>
    
    </tr>
    </thead>
    <tbody>
    <c:set var="grandTotal" scope="session" value="0"/>
    <c:forEach items="${cartItems}" var="cartItem">
    <c:set var="grandTotal" scope="session" value="${ grandTotal + cartItem.cartItemSubTotal}"/>
    <tr>
    <td class="cart_product">
    <a href="">
    <img src="${cartItem.product.productImage}" height="110" width="110"
    alt="${cartItem.product.productImage}"></a>
    </td>
    <td class="cart_description">
    <h4><a href="">${cartItem.product.productName}</a></h4>
    <p>${cartItem.product.productId}</p>
    </td>
    <td class="cart_price">
    <p>&#X20B9; ${cartItem.product.productPrice}</p>
    </td>
    <td class="cart_price">
    <p>${cartItem.cartItemQuantity}</p></td>
    <td class="cartTotal">
    <p class="cart_total_price">&#X20B9; ${cartItem.cartItemSubTotal}</p>
    </td>
    <td class="cart_delete">
    <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/deleteCartItem/${cartItem.cartItemId}"><i class="far fa-trash-alt" style="color:red"></i></a>    
    </td>
    <td>
    </td>
    </tr>
     </c:forEach>
     <tr>
    <th><b>Grand Total : ${grandTotal}</b></th>
    <c:if test="${ not cartItems.isEmpty()}">
      <th><a class="btn btn-default check_out" href="${pageContext.request.contextPath}/order">Place Order</a></th>
      </c:if>
     <th><a class="btn btn-default continue_shopping" href="${pageContext.request.contextPath}/home">Continue shopping</a></th>
    
     <b>Cart</b><img src="${pageContext.request.contextPath}\resources\img\ecom-cart.gif" style="width:128px;height:128px;">
     <br>
    </tbody>
    
    </table>
    
    </div>
    </div>