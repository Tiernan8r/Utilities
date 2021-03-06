package me.Tiernanator.Utilities.SQL.MySQL;

import me.Tiernanator.Utilities.SQL.Database;
import me.Tiernanator.Utilities.SQL.SQLServerData;
import me.Tiernanator.Utilities.UtilitiesMain;

import java.sql.*;

/**
 * Connects to and uses a MySQL database I've adapted the class for my own
 * purposes and added connection refreshing functions;
 *
 * @author -_Husky_-
 * @author tips48
 * @author Tiernan
 */
public class MySQL extends Database {

	@SuppressWarnings("unused")
	private static UtilitiesMain plugin;
	private final String user;
	private final String database;
	private final String password;
	private final String port;
	private final String hostname;
	/**
	 * Creates a new MySQL instance
	 *
	 * @param hostname Enum of name of the host
	 * @param port     Enum of port number
	 * @param username Enum of username
	 * @param password Enum of password
	 */
	public MySQL(SQLServerData hostname, SQLServerData port, SQLServerData username, SQLServerData password) {
		this(hostname.getInfo(), port.getInfo(), null, username.getInfo(), password.getInfo());
	}

	/**
	 * Creates a new MySQL instance for a specific database
	 *
	 * @param hostname Enum of name of the host
	 * @param port     Enum of port number
	 * @param database Database name
	 * @param username Enum of username
	 * @param password Enum of password
	 */
	public MySQL(SQLServerData hostname, SQLServerData port, SQLServerData database, SQLServerData username, SQLServerData password) {
		this(hostname.getInfo(), port.getInfo(), database.getInfo(), username.getInfo(), password.getInfo());
	}

	/**
	 * Creates a new MySQL instance for a specific database
	 *
	 * @param hostname Enum of name of the host
	 * @param port     Enum of port number
	 * @param database Database name
	 * @param username Enum of username
	 * @param password Enum of password
	 */
	public MySQL(SQLServerData hostname, SQLServerData port, String database, SQLServerData username, SQLServerData password) {
		this(hostname.getInfo(), port.getInfo(), database, username.getInfo(), password.getInfo());
	}

	/**
	 * Creates a new MySQL instance
	 *
	 * @param hostname Name of the host
	 * @param port     Port number
	 * @param username Username
	 * @param password Password
	 */
	public MySQL(String hostname, String port, String username, String password) {
		this(hostname, port, null, username, password);
	}

	/**
	 * Creates a new MySQL instance for a specific database
	 *
	 * @param hostname Name of the host
	 * @param port     Port number
	 * @param database Database name
	 * @param username Username
	 * @param password Password
	 */
	public MySQL(String hostname, String port, String database, String username, String password) {
		this.hostname = hostname;
		this.port = port;
		this.database = database;
		this.user = username;
		this.password = password;
	}

	public static void setPlugin(UtilitiesMain main) {
		plugin = main;
	}

	public Connection getConnection() {

		try {
			openConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	@Override
	public Connection openConnection() throws SQLException, ClassNotFoundException {

		synchronized (this) {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + this.hostname + ":" + this.port;
			if (this.database != null) {
				url += "/" + this.database;
			}
			connection = DriverManager.getConnection(url, this.user, this.password);
		}
		refreshConnection();

		return connection;
	}

	public void refreshConnection() {

		PreparedStatement preparedStatement = null;
		ResultSet valid = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT 1 FROM Dual");
			valid = preparedStatement.executeQuery();
			if (valid.next()) {
				return;
			}
		} catch (SQLException e) {
			System.out.println("Connection is idle or terminated. Reconnecting...");
			//		} finally {
			// this.closeQuietly(valid);
		}

		long start = 0;
		long end = 0;

		try {

			start = System.currentTimeMillis();

			System.out.println("Attempting to establish a connection to the MySQL server!");

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database, this.user, this.password);

			end = System.currentTimeMillis();

			System.out.println("Connection to MySQL server established! (" + this.hostname + ":" + this.port + ")");
			System.out.println("Connection took " + ((end - start)) + "ms!");

		} catch (SQLException e) {

			System.out.println("Could not connect to MySQL server! because: " + e.getMessage());

		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver not found!");

		}
	}
}
