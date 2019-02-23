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

	<div id="displayFilm">
	<h2>Film: ${film.title}(${film.releaseYear}) (rated:${film.rating})</h2>
	<p>Length (${film.length}) Language: ${film.language}</p>
	<p>Rental Rate: $${film.rentalRate} for ${film.rentalDuration} days</p>
	<p></p>
	<p>
	<h3>Description</h3>
	<blockquote>${film.description }</blockquote>
	<h3>Actors</h3>
	<ul>
		<c:forEach var="actor" items="${film.cast}">
			<li>${actor.firstName} ${actor.lastName}</li>
		</c:forEach>
	</ul>
	</p>
	</div>
	
	<div id="filmEditForm">
	
	</div>


	<form action="inventory.do" method="POST">
		<h2>This is a post form template. uses .do.</h2>
		<label for="search">Search:</label> <input type="text" name="search">
		<br> <label for="comments">Comments:</label> <input type="text"
			name="comments"> <br> <input type="submit"
			value="submit">
	</form>
</body>
</html>