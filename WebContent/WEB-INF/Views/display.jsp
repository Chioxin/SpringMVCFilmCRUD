<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Film</title>
</head>
<body>


	<form action="inventory.do" method="POST">
		<h2>This is a post form template. uses .do.</h2>
		<label for="search">Search:</label> <input type="text" name="search">
		<br> <label for="comments">Comments:</label> <input type="text"
			name="comments"> <br> <input type="submit"
			value="submit">
	</form>
</body>
</html>