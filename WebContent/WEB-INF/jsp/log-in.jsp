<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in page...</title>
</head>
<body>
Please log in

<c:if test="${not empty authMessage}">
<div>${authMessage}</div>
</c:if>

<form action="log-in" method="post">
username: <input type="text" name="username"/> <br/>
password: <input type="password"name="password" /> <br/>
<input type="submit" value="Enter"/>
</form>


</body>
</html>