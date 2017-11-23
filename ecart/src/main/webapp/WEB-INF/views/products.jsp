<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<table border="2" width="70%" cellpadding="2">  
<tr><th></th><th>Name</th></tr>  
   <c:forEach var="product" items="${productList}">   
   <tr>  
  <%--  <td><img src="${pageContext.request.contextPath}/${user.userImage}" height="50" width="50"></td> --%>
   <td>${product.productName}</td>  
       
  
   <td><a href="${pageContext.request.contextPath}/showProduct/${product.productId}">Show</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>  
</body>
</html>