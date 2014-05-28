<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalog Page</title>
<style>
	table
	{border-collapse:collapse;}
	table, th, td
	{border: 1px solid black;width: 600px; text-align:center;}	
</style>
</head>
<body>

<c:if test="${not empty authMessage}">
	<div>${authMessage}</div>
</c:if>
 
 <br/>
 
 Click the category to view its associated products:
<form id="category-form" action="get-products-by-cat" method="get" >
 <select name="categoryName">
 <option></option>
 <c:forEach items="${categoryList}" var="category"> 
  <option value="${category.categoryName}" onclick="getProductByCategory()">${category.categoryName}</option>
  </c:forEach>
</select> 
</form>

<br/>
<a href="view-cart">View Cart</a>

<br/>
<c:if test="${not empty addToCartResult}">
	<div>RESULT : ${addToCartResult}</div>
</c:if>
<br/>
<table style="border:1px solid">
<tr>
	<td>NAME</td>
	<td>PRICE</td>
	<td>INVENTORY</td>
	<td>CATEGORY</td>
	<td>QUANTITY</td>
</tr>


 <c:forEach items="${productList}" var="product"> 
	<tr>
		<td>${product.productName}</td>
		<td>${product.unitPrice}</td>
		<td>${product.inventory}</td>
		<td>${product.category.categoryName}</td>
		<td>
			<form action="add-to-cart" method="post">
				<input type="hidden" name="productName" value="${product.productName}" />
				<input name="quantity" type="text" size="2"/>
				<input type="submit" value="Add to Cart"/>	
			</form>
		</td>
	</tr>
</c:forEach>

</table>

<script type="text/javascript">
 function getProductByCategory(){
	 document.getElementById('category-form').submit();
 }
</script>

<a href="logout">Log out</a>

</body>
</html>