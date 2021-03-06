<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Display</title>
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
			
			<a href="home.do">Return to Search Page</a>

		</div>
	</c:if>


	<c:if test="${not empty film}">
		<div id="displayFilm">
			<c:if test="${not empty filmNotDeleted }">
				<h2>Delete of film ${film.title } failed!</h2>
			</c:if>
			<c:if test="${not empty updateFailure }">
				<h2>Update of film ${film.title } failed!</h2>
			</c:if>
			
			
			<h2>Film: ${film.title}<c:if test="${film.releaseYear != 0 }">(${film.releaseYear})</c:if>
				(rated:${film.rating})</h2>
			<h3>Description</h3>
			<blockquote>${film.description }</blockquote>
			<p>
				<c:if test="${not empty film.category }">
					<strong>Category:</strong> ${film.category}
				<br>
				</c:if>
				<c:if test="${not empty film.language }">
					<strong>Language:</strong> ${film.language}
				<br>
				</c:if>
				<c:if test="${not empty film.specialFeatures }">
					<strong>Special Features:</strong> ${film.specialFeatures }
				<br>
				</c:if>
				<c:if test="${not empty film.length and film.length != 0}">
					<strong>Length:</strong> ${film.length} minutes
				<br>
				</c:if>
				<c:if
					test="${(not empty film.rentalRate and film.rentalRate != 0.0) and (not empty film.rentalDuration and film.rentalDuration != 0)}">
					<strong>Rental Rate:</strong> $${film.rentalRate} for ${film.rentalDuration} days</c:if>
			</p>

			<c:if test="${not empty film.cast}">
				<div>
					<h3>Actors</h3>
					<ul>
						<c:forEach var="actor" items="${film.cast}">
							<li>${actor.firstName} ${actor.lastName}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</div>

		<div id="filmEditForm">

			<form:form action="update.do" method="POST" modelAttribute="updatedFilm">
				<form:input type="hidden" path="id" />
				<form:label path="title">Title:</form:label>
				<form:input path="title" />
				<form:errors path="title" />
				<br />
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
				<form:errors path="description" />
				<br />
				<form:label path="rating">Rating:</form:label>
				<form:select path="rating" name="languageId">
					<option value="G">G</option>
					<option value="PG">PG</option>
					<option value="PG13">PG-13</option>
					<option value="R">R</option>
					<option value="NC17">NC-17</option>
				</form:select>
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
				<form:select path="languageId" name="languageId">
					<option value="1">English</option>
					<option value="2">Italian</option>
					<option value="3">Japanese</option>
					<option value="4">Manderin</option>
					<option value="5">French</option>
					<option value="6">German</option>
				</form:select>
				<br>
				<input type="hidden" name="id" value="${updatedFilm.id }" />
				<input type="submit" value="Update Changes" />
			</form:form>
			<form:form action="delete.do" method="POST" modelAttribute="film">

				<input name="filmId" type="hidden" value=${updatedFilm.id } />
				<input type="submit" value="Would you like to delete this film?" />
			</form:form>
			
			<a href="home.do">Return to Search Page</a>

		</div>
	</c:if>
</body>
</html>