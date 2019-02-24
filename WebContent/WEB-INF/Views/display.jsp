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
	<c:if test="${not empty filmList}">
		<div id="displayListofFilms">
			<h3>List of Films matching your Query</h3>
			<ul>
				<c:forEach var="aFilm" items="${filmList}">
					<li><a href="search.do?filmId=<c:out value="${aFilm.id}"/>">${aFilm.title}</a></li>
				</c:forEach>
			</ul>

		</div>
	</c:if>


	<c:if test="${not empty film}">
		<div id="displayFilm">
		<c:if test="${not empty filmNotDeleted }">
				<h2>Delete of film ${film.title }failed!</h2>
			</c:if>
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

			<c:if test="${not empty film.cast}">
				<div>
					<h3>Actors</h3>
					<ul>
						<c:forEach var="actor" items="${film.cast}">
							<li>${actor.firstName}${actor.lastName}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			</p>
		</div>

		<div id="filmEditForm">
			
			<form:form action="update.do" method="POST" modelAttribute="film">
				<form:label path="title">Title:</form:label>
				<form:input path="title" />
				<form:errors path="title" />
				<br />
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
				<form:errors path="description" />
				<br />
				<form:label path="rating">Rating:</form:label>
				<form:input path="rating" />
				<form:errors path="rating" />
				<br />
				<form:label path="length">Length:</form:label>
				<form:input path="length" />
				<form:errors path="length" />
				<br />
				<form:label path="releaseYear">Release Year:</form:label>
				<form:input path="releaseYear" />
				<form:errors path="releaseYear" />
				<br />
				<form:label path="rentalRate">Rental Rate:</form:label>
				<form:input path="rentalRate" />
				<form:errors path="rentalRate" />
				<br />
				<form:label path="rentalDuration">Rental Duration:</form:label>
				<form:input path="rentalDuration" />
				<form:errors path="rentalDuration" />
				<br />
				<form:label path="replacementCost">Replacement Cost:</form:label>
				<form:input path="replacementCost" />
				<form:errors path="replacementCost" />
				<br />
				<%-- <form:label path="specialFeatures">Special Features:</form:label>
				<form:input path="specialFeatures" />
				<form:errors path="specialFeatures" />
				<br /> --%>
				<form:label path="languageId">Language: </form:label>
				<form:input path="languageId"/>
				<form:select path="languageId" name="languageId">
					<option value="1">English</option>
					<option value="2">Italian</option>
					<option value="3">Japanese</option>
					<option value="4">Manderin</option>
					<option value="5">French</option>
					<option value="6">German</option>
				</form:select>
				<br>
				<input type="hidden" name="id" value="${film.id }"/>
				<input type="submit" value="Update" />
			</form:form>
			<form:form action="delete.do" method="POST" modelAttribute="film">
			
				<input name="filmId" type="hidden" value=${film.id } />
				<input type="submit" value="Would you like to delete this film?" />
			</form:form>

		</div>
	</c:if>
</body>
</html>