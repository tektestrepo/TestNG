package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilities {

	// Creating private static obj of Connection class
	// it is used to create connection with database
	private static Connection conn;

	// Creating private static obj of Statement class
	// It is used to create a Statement to execute the query
	private static Statement stmt;

	// Creating private static obj of ResultSet class
	// It is used to create a resultset to store query result.
	private static ResultSet resultSet;

	// create db url
	// syntax for db url conection or url string
	// jdbc:typeofdatabase://host:port/databasename
	private static String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";

	// databse user username
	private static String dbUserName = "postgres";

	// databse user password
	private static String dbPassword = "root";

	public static void setupConnection() {

		try {
			conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

	public static ResultSet runQuery(String query) {

		try {

			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query);
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;

	}

	public void writeResultToCSV() {

	}

	public static String data() {

		String a = null;
		try {
			while (resultSet.next()) {

				a = resultSet.getString("email");
				System.out.print(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

}
