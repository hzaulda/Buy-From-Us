<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contents of Cart goes here</title>
<style>
table {
	border-collapse: collapse;
}

table,th,td {
	border: 1px solid black;
	width: 600px;
	text-align: center;
}
</style>
</head>
<body>
	<a href="get-all-products">Back to Catalog Page</a> <br/>
	<br/>
	<table>
		<tr>
			<td>PRODUCT NAME</td>
			<td>UNIT PRICE</td>
			<td>QUANTITY</td>
		</tr>
		<c:forEach items="${cartItems}" var="cartItem">
			<tr>
				<td>${cartItem.product.productName}</td>
				<td>${cartItem.unitPrice}</td>
				<td>${cartItem.quantity}</td>
			</tr>
		</c:forEach>
	</table>

<a href="logout">Log out</a>

</body>
</html>