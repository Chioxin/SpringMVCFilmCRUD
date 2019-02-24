<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film CRUD Home</title>
</head>
<body>
	<h1>Welcome to the new and improved Film Database query!</h1>
	<c:if test="${not empty failedSearch}"> 
	<h3>Your Search for ${failedSearch } yielded no results</h3>
	</c:if>
	<p>
		Please choose from the following options:<br> Search for a film
		by<br>
	<form action="search.do" method="GET">
		<label for="search">Search by Film ID:</label> <input type="text"
			name="filmId"> <input type="submit" value="submit">
	</form>
	<br>
	<form action="search.do" method="GET">
		<label for="search">Search by Keyword:</label> <input type="text"
			name="keyWord"> <input type="submit" value="submit">
	</form>
	</p>

	<br>

	<form action="add.do" method="GET">
		<input type="submit" value="Add Film" />
	</form>
	
	<a href="testListDisplay.do">display.jsp</a>
	<a href="testAdd.do">Film.jsp</a>
</body>
</html>