<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Form</title>
</head>
<body>

	<form:form action="addFilm.do" method="POST" modelAttribute="film">
		<form:label path="title">Title:</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>
		<form:label path="description">Description:</form:label>
		<form:input path="description" />
		<form:errors path="description" />
		<br>
		<form:label path="rating">Rating:</form:label>
		<form:select path="rating" name="languageId">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG-13</option>
			<option value="R">R</option>
			<option value="NC17">NC-17</option>
		</form:select>
		<br>
		<form:label path="length">Length:</form:label>
		<form:input path="length" value="30" />
		<form:errors path="length" />
		<br />
		<form:label path="releaseYear">Release Year:</form:label>
		<form:input path="releaseYear" value="2000"/>
		<form:errors path="releaseYear" />
		<br />
		<form:label path="rentalRate">Rental Rate:</form:label>
		<form:input path="rentalRate" value="0.99"/>
		<form:errors path="rentalRate" />
		<br />
		<form:label path="rentalDuration">Rental Duration:</form:label>
		<form:input path="rentalDuration" value="3"/>
		<form:errors path="rentalDuration" />
		<br />
		<form:label path="replacementCost">Replacement Cost:</form:label>
		<form:input path="replacementCost" value="5.00"/>
		<form:errors path="replacementCost" />
		<br />
		<form:label path="languageId"> Language:</form:label>
		<form:select path="languageId" name="languageId">
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Manderin</option>
			<option value="5">French</option>
			<option value="6">German</option>
		</form:select>

		<br>
		<input type="submit" value="submit">
	</form:form>
	<a href="home.do">Return to Search Page</a>



</body>
</html>