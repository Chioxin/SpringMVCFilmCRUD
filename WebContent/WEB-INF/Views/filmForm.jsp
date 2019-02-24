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
			<input type="text" name="Title"><br>
		 	Description:<br>
			<input type="text" name="Description"><br>
		 	Rating:<br>
			<!-- <input type="text" name="Rating"><br>
		 	Length:<br> -->
			<!-- <input type="text" name="Length"><br>
		 	Release Year:<br>
			<input type="text" name="ReleaseYear"><br>
		 	Rental Rate:<br>
			<input type="text" name="RentalRate"><br>
		 	Rental Duration:<br>
			<input type="text" name="RentalDuration"><br>
		 	Replacement Cost:<br>
			<input type="text" name="ReplacementCost"><br>
		 	Special Features:<br>
			< input type="text" name="SpecialFeatures"><br>-->
			Language<br>
			<select name="LanguageId">
				<option value="1">English</option>
				<option value="2">Italian</option>
				<option value="3">Japanese</option>
				<option value="4">Manderin</option>
				<option value="5">German</option>
			</select>
			
			
			<input type="submit" value="submit">
		</form>
		
		<%-- <form:form action="add.do" method="POST" modelAttribute="film" >
			
			<br />
			<form:label path="Language">Language:</form:label>
			<form:input path="Language" />
			<form:errors path="Language" />
			<br />
			<form:label path="SpecialFeatures">Special Features:</form:label>
			<form:input path="SpecialFeatures" />
			<form:errors path="SpecialFeatures" />
		
			
		</form:form> --%>
	</body>
</html>