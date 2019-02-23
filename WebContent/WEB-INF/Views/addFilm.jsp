<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>Add Film form:</title>
	</head>
	<body>
		<form:form action="add.do" method="POST" >
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<form:errors path="title" />
			<br />
			<form:label path="description">Description</form:label>
			<form:input path="description" />
			<form:errors path="description" />
			<br />
			<form:label path="releaseYear">Release Year:</form:label>
			<form:input path="releaseYear" />
			<form:errors path="releaseYear" />
			<br />
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" />
			<br />
			<form:label path="age">Age:</form:label>
			<form:input path="age" />
			<form:errors path="age" />
			<input type="submit" value="Register" />
		</form:form>
	</body>
</html>