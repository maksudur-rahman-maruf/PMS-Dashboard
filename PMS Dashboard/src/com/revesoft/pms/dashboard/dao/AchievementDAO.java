package com.revesoft.pms.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revesoft.pms.dashboard.model.Achievement;

public class AchievementDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/pms_dashboard?allowPublicKeyRetrieval=true&useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	private static final String SELECT_ACHIEVEMENT_BY_YEAR = "select * from achievement where year =?";

	public AchievementDAO() {

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public List<Achievement> selectAllAchievements(int year) {

		List<Achievement> achievements = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACHIEVEMENT_BY_YEAR);) {
			preparedStatement.setInt(1, year);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				long userId = rs.getLong("user_id");
				year = rs.getInt("year");
				String month = rs.getString("month");
				double achievement = rs.getDouble("achievement");
				achievements.add(new Achievement(id, userId, year, month, achievement));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return achievements;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
