<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page for adding stuff and viewing stuff</title>
</head>
<body>

<c:if test="${not empty authMessage}">
<div>${authMessage}</div>
</c:if>

<button type="button" onclick="addCategory()">Add Category</button> <br/>
<button type="button"onclick="addProduct()">Add Product</button> <br/>
 

<c:if test="${not empty result}">
	<div>RESULT : ${result}</div>
</c:if>

<br/>

<form id="add-category-form" action="add-category" method="post" style="display:none">
Category name: <input type="text" name="category"/> <br/>
<input type="submit" value="Add Category"/>
</form>

<br/>

<form id= "add-product-form" action="add-product" method="post" style="display:none">
<table>
	<tr><td>Product name:</td><td><input type="text" name="name"/></td> </tr>
	<tr><td>Price:</td><td><input type="text"name="price"/> </td></tr>
	<tr><td>Category:</td>
	<td><select name="category">
	 	<c:forEach items="${categoryList}" var="category"> 
	  	<option value="${category.categoryName}" onclick="getProductByCategory()">${category.categoryName}</option>
	  </c:forEach>
	 	</select> 
	 </td></tr>
	 <tr><td>Quantity:</td><td><input type="text"name="quantity"/> </td></tr>
	 <tr><td>Product Image:</td><td><input type="text"name="productImage"/></td></tr>
	 <tr><td> </td><td><input type="submit" value="Add Product"/> </td></tr>	
</table>
</form>

<!-- 
<form id= "add-product-form" action="add-product" method="post" style="display:none">
Product name: <input type="text" name="name"/> <br/>
Price: <input type="text"name="price" /> <br/>
 Category: <select name="category">
 	<c:forEach items="${categoryList}" var="category"> 
  <option value="${category.categoryName}" onclick="getProductByCategory()">${category.categoryName}</option>
  </c:forEach>
 </select> <br/>

Quantity: <input type="text"name="quantity" /> <br/>
Product Image: <input type="text"name="productImage" /> <br/>
<input type="submit" value="Add Product"/>
</form>
 -->
<br/>

<a href="logout">Log out</a>

<script type="text/javascript">
 function addCategory(){
	 hideForms();
	 document.getElementById("add-category-form").style.display="block"; 
 }  
 
 function addProduct(){
	 hideForms();
	 document.getElementById("add-product-form").style.display="block";
 }
 
 function hideForms(){
	 document.getElementById("add-category-form").style.display="none";
	 document.getElementById("add-product-form").style.display="none";
 }
</script>

</body>
</html>