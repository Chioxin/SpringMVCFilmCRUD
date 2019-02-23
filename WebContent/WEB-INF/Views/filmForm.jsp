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
	
		<form action="addFilm.do" method="POST">
		 	Title:<br>
			<input type="text" name="title"><br>
		 	Description:<br>
			<input type="text" name="title"><br>
		 	Release Year:<br>
			<input type="text" name="title"><br>
		 	Title:<br>
			<input type="text" name="title"><br>
		 	Title:<br>
			<input type="text" name="title"><br>
		 	Title:<br>
			<input type="text" name="title"><br>
		 	Title:<br>
			<input type="text" name="title"><br>
			
			
			<input type="submit">
		</form>
		
		<%-- <form:form action="add.do" method="POST" modelAttribute="film" >
			<form:label path="Title">Title:</form:label>
			<form:input path="Title" />
			<form:errors path="Title" />
			<br />
			<form:label path="Description">Description</form:label>
			<form:input path="Description" />
			<form:errors path="Description" />
			<br />
			<form:label path="ReleaseYear">Release Year:</form:label>
			<form:input path="ReleaseYear" />
			<form:errors path="ReleaseYear" />
			<br />
			<form:label path="Language">Language:</form:label>
			<form:input path="Language" />
			<form:errors path="Language" />
			<br />
			<form:label path="RentalRate">Rental Rate:</form:label>
			<form:input path="RentalRate" />
			<form:errors path="RentalRate" />
			<br />
			<form:label path="Length">Length:</form:label>
			<form:input path="Length" />
			<form:errors path="Length" />
			<br />
			<form:label path="ReplacementCost">Replacement Cost:</form:label>
			<form:input path="ReplacementCost" />
			<form:errors path="ReplacementCost" />
			<br />
			<form:label path="Rating">Rating:</form:label>
			<form:input path="Rating" />
			<form:errors path="Rating" />
			<br />
			<form:label path="SpecialFeatures">Special Features:</form:label>
			<form:input path="SpecialFeatures" />
			<form:errors path="SpecialFeatures" />
		
			
		</form:form> --%>
	</body>
</html>