<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Users</h1>  
       <form:form method="POST" action="/ecart/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="userId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="userName"  /></td>  
         </tr>    
         <tr>    
          <td>Address  :</td>    
          <td><form:input path="userAddress" /></td>  
         </tr>   
          
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    