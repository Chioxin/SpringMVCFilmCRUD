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
			<input type="text" name="Description"><br>
		 	Rating:<br>
			<input type="text" name="Rating"><br>
		 	Length:<br>
			<input type="text" name="Length"><br>
		 	Release Year:<br>
			<input type="text" name="ReleaseYear"><br>
		 	Rental Rate:<br>
			<input type="text" name="RentalRate"><br>
		 	Replacement Cost:<br>
			<input type="text" name="ReplacementCost"><br>
		 	Special Features:<br>
			<input type="text" name="SpecialFeatures"><br>
			<select name="Language">
				<option value="English">English</option>
				<option value="Italian">Italian</option>
				<option value="Japanese">Japanese</option>
				<option value="Manderin">Manderin</option>
				<option value="German">German</option>
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