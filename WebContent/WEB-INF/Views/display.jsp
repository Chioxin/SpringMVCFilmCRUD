<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Film</title>
</head>
<body>

	<div id="displayFilm">
		<h2>Film: ${film.title}(${film.releaseYear})
			(rated:${film.rating})</h2>
		<p>Length (${film.length}) Language: ${film.language}</p>
		<p>Rental Rate: $${film.rentalRate} for ${film.rentalDuration}
			days</p>
		<p></p>
		<p>
		<h3>Description</h3>
		<blockquote>${film.description }</blockquote>
		<h3>Special Features</h3>
		
		<div c:if test ="${not empty film.cast}">
			<h3>Actors</h3>
			<ul>
				<c:forEach var="actor" items="${film.cast}">
					<li>${actor.firstName}${actor.lastName}</li>
				</c:forEach>
			</ul>
		</div>
		</p>
	</div>

	<div id="filmEditForm">
		<form:form action="update.do" method="POST" modelAttribute="film">
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<br />
			<form:label path="description">Description:</form:label>
			<form:input path="description" />
			<br />
			<form:label path="rating">Rating:</form:label>
			<form:input path="rating" />
			<br />
			<form:label path="length">Length:</form:label>
			<form:input path="length" />
			<br />
			<form:label path="releaseYear">Release Year:</form:label>
			<form:input path="releaseYear" />
			<br />
			<form:label path="rentalRate">Rental Rate:</form:label>
			<form:input path="rentalRate" />
			<br />
			<form:label path="rentalDuration">Rental Duration:</form:label>
			<form:input path="rentalDuration" />
			<br />
			<form:label path="replacementCost">Replacement Cost:</form:label>
			<form:input path="replacementCost" />
			<br />
			<form:label path="specialFeatures">Special Features:</form:label>
			<form:input path="specialFeatures" />
			<br />
			<form:label path="Language">Language: </form:label>
			<select name="Language">
				<option value="English">English</option>
				<option value="Italian">Italian</option>
				<option value="Japanese">Japanese</option>
				<option value="Manderin">Manderin</option>
				<option value="German">German</option>
			</select>
			<br>
			<input type="submit" value="Update" />
		</form:form>
		<form:form action="delete.do" method="POST" modelAttribute="film">
			<input type="submit" value="Delete" />
		</form:form>

	</div>
</body>
</html>