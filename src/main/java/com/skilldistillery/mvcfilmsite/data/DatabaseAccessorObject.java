package com.skilldistillery.mvcfilmsite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		Film myFilm = null;
		String query = "SELECT * FROM film WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, filmId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				myFilm = createFilm(rs);
			} else {
				System.out.println("Could not find a film with ID(" + filmId + ").");
			}
		} catch (SQLException e) {
			System.err.println("Something went wrong in findFilmByID method.");
			e.printStackTrace();
		}
		return myFilm;
	}

	// Overload used in searching for films.
	private Film createFilm(ResultSet rs) throws SQLException {
		Film myFilm = null;

		int id = rs.getInt("film.id");
		String title = rs.getString("film.title");
		String description = rs.getString("film.description");
		int releaseYear = rs.getInt("film.release_year");
		int languageId = rs.getInt("film.language_id");
		int rentalDuration = rs.getInt("film.rental_duration");
		double rentalRate = rs.getDouble("film.rental_rate");
		int length = rs.getInt("film.length");
		double replacementCost = rs.getDouble("film.replacement_cost");
		String rating = rs.getString("film.rating");
		String specialFeatures = rs.getString("film.special_features");
		List<Actor> cast = findActorsByFilmId(id);
		String language = findLanguagesByFilmId(id);
		String category = findCategoriesByFilmId(id);
		myFilm = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
				replacementCost, rating, specialFeatures, cast, language, category);

		return myFilm;
	}

	private String findLanguagesByFilmId(int filmId) {
		String myLanguage = "N/A";
		String query = "SELECT film.title, language.name "
				+ "FROM language JOIN film ON film.language_id = language.id " + "WHERE film.id = ?;";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, filmId);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				myLanguage = rs.getString("language.name");
			}

		} catch (SQLException e) {
			System.err.println("Something went wrong in findLanguagesByFilmId method.");
			e.printStackTrace();
		}

		return myLanguage;
	}

	@Override
	public Actor findActorById(int actorId) {

		Actor myActor = null;
		String query = "SELECT * FROM actor WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, actorId);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				myActor = createActor(rs);

			} else {
				System.out.println("Could not find an actor with ID(" + actorId + ").");
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Something went wrong in findActorByID method.");
			e.printStackTrace();
		}
		return myActor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> myList = new ArrayList<Actor>();
		String query = "SELECT actor.id, actor.first_name, actor.last_name " + "FROM film JOIN film_actor "
				+ "ON film.id = film_actor.film_id " + "JOIN actor " + "ON film_actor.actor_id = actor.id "
				+ "WHERE film.id = ?;";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, filmId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				myList.add(createActor(rs));
			}

		} catch (SQLException e) {
			System.err.println("Something went wrong in findActorByFilm method.");
			e.printStackTrace();
		}

		return myList;
	}

	@Override
	public String findCategoriesByFilmId(int filmId) {
		String myCategory = null;
		String query = "SELECT film.title, category.name "
				+ "FROM film JOIN film_category filmc ON film.id = filmc.film_id "
				+ "JOIN category ON filmc.category_id = category.id " + "WHERE film.id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, filmId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				myCategory = rs.getString("category.name");
			}

		} catch (SQLException e) {
			System.err.println("Something went wrong in findActorByFilm method.");
			e.printStackTrace();
		}

		return myCategory;
	}

	private Actor createActor(ResultSet rs) throws SQLException {
		Actor myActor = null;

		int id = rs.getInt("actor.id");
		String firstName = rs.getString("actor.first_name");
		String lastName = rs.getString("actor.last_name");
		myActor = new Actor(id, firstName, lastName);

		return myActor;
	}

	@Override
	public List<Film> findFilmByKeyWord(String key) {
		List<Film> myList = new ArrayList<Film>();
		String query = "SELECT * " + "FROM film " + "WHERE title LIKE ? OR description LIKE ?;";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setString(1, "%" + key + "%");
			statement.setString(2, "%" + key + "%");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				myList.add(createFilm(rs));
			}

		} catch (SQLException e) {
			System.err.println("Something went wrong in findFilmByKeyWord method");
			e.printStackTrace();
		}

		return myList;
	}

	@Override
	public Film insertFilm(Film inputFilm) {
		Film myFilm = null;

		if (inputFilm != null) {
			String query = "INSERT INTO film (title, description, language_id)" + " VALUES (?,?,?)";

			Connection conn = null;
			PreparedStatement statement = null;
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				conn.setAutoCommit(false);

				statement.setString(1, inputFilm.getTitle());
				statement.setString(2, inputFilm.getDescription());
				statement.setInt(3, inputFilm.getLanguageId());
				int numChanges = statement.executeUpdate();

				if (numChanges == 1) {
					ResultSet keys = statement.getGeneratedKeys();
					if (keys.next()) {
						inputFilm.setId(keys.getInt(1));
						myFilm = inputFilm;
					}
				}

			} catch (SQLException e) {
				System.err.println("Something went wrong in insertFilm method attempting an insert.");
				e.printStackTrace();
				try {
					conn.rollback();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					conn.commit();
					conn.close();
					statement.close();
				} catch (SQLException e) {
					System.err.println("Something went wrong closing database connections");
					e.printStackTrace();
				}
			}
		}

		return myFilm;
	}

	public boolean deleteFilm(Film deleteFilm) {
		boolean deleteSuccess = false;
		if (deleteFilm != null) {

			String query = "DELETE FROM film WHERE id = ?";

			Connection conn = null;
			PreparedStatement statement = null;

			try {

				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				statement = conn.prepareStatement(query);
				conn.setAutoCommit(false);

				statement.setInt(1, deleteFilm.getId());
				statement.executeUpdate();
				
				deleteSuccess = true;

			} catch (SQLException e) {
				System.err.println("Something went wrong in deleteFilm method attempting a delete.");
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					conn.commit();
					conn.close();
					statement.close();
				} catch (SQLException e) {
					System.err.println("Something went wrong closing database connections in deleteFilm");
					e.printStackTrace();
				}
			}
		}
		
		return deleteSuccess;
	}

	@Override
	public boolean updateFilm(Film modifiedFilm) {
		Film originalFilm = null;
		boolean updateSuccess = false;

		originalFilm = findFilmById(modifiedFilm.getId());
		StringBuilder query = buildSetClause(originalFilm, modifiedFilm);
		query.append(" WHERE id = " + originalFilm.getId());

		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = conn.prepareStatement(query.toString());
			conn.setAutoCommit(false);
//			System.out.println(statement);
			statement.executeUpdate();
			System.out.println("<==================DAO Error====================>");
			updateSuccess = true;

		} catch (SQLException e) {
			System.out.println("Something went wrong in updateFilm method attempting an update.");
			e.printStackTrace();
			try {
				conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateSuccess;
	}

	private StringBuilder buildSetClause(Film oFilm, Film mFilm) {
		StringBuilder set = new StringBuilder("UPDATE film SET ");
		boolean doNotAddComma = true;

		if ((mFilm.getTitle() != null && !mFilm.getTitle().equals("")) && !mFilm.getTitle().equals(oFilm.getTitle())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			}
			set.append("title = \"" + mFilm.getTitle() + "\"");
		}

		if ((mFilm.getDescription() != null && !mFilm.getDescription().equals(""))
				&& !mFilm.getDescription().equals(oFilm.getDescription())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("description = \"" + mFilm.getDescription() + "\"");
		}
		if ((mFilm.getReleaseYear() != oFilm.getReleaseYear())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("release_year = " + mFilm.getReleaseYear());
//			set.append("release_year = \"" + mFilm.getReleaseYear() + "\"");
		}
		if (mFilm.getLanguageId() != oFilm.getLanguageId()) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("language_id = " + mFilm.getLanguageId());
		}
		if (mFilm.getRentalDuration() != oFilm.getRentalDuration()) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("rental_duration = " + mFilm.getRentalDuration());
		}
		if (mFilm.getRentalRate() != (oFilm.getRentalRate())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("rental_rate = " + mFilm.getRentalRate());
		}
		if (mFilm.getLength() != (oFilm.getLength())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("length = " + mFilm.getLength());
		}
		if (mFilm.getReplacementCost() != oFilm.getReplacementCost()) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("replacement_cost = " + mFilm.getReplacementCost());
		}
//		if ((mFilm.getSpecialFeatures() != null && !mFilm.getSpecialFeatures().equals(""))&& !mFilm.getSpecialFeatures().equals(oFilm.getSpecialFeatures())) {
//			if (doNotAddComma) {
//				doNotAddComma = false;
//			} else {
//				set.append(", ");
//			}
//			set.append("special_features = \"" + mFilm.getSpecialFeatures() + "\"");
//		}
		if ((mFilm.getRating() != null && !mFilm.getRating().equals(""))
				&& !mFilm.getRating().equals(oFilm.getRating())) {
			if (doNotAddComma) {
				doNotAddComma = false;
			} else {
				set.append(", ");
			}
			set.append("rating = \"" + mFilm.getRating() + "\"");
		}
		return set;
	}

//	custom exceptions

}