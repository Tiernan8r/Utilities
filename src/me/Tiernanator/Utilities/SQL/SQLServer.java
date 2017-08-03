package me.Tiernanator.Utilities.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.SQL.MySQL.MySQL;

public class SQLServer {

	private static UtilitiesMain plugin;
	private static MySQL mySQL;
	private static Connection connection;

	public static void executePreparedStatement(String statement,
			Object[] values) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				// get the connection and prepare a statement
				connection = getConnection();
				PreparedStatement preparedStatement = null;
				try {
					preparedStatement = connection.prepareStatement(statement);
					preparedStatement.closeOnCompletion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < values.length; i++) {
					try {
						preparedStatement.setObject(i + 1, values[i]);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				// insert the data into the table
				try {
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					preparedStatement.closeOnCompletion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	public static void executeQuery(String query) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				connection = getConnection();

				Statement statement = null;
				try {
					statement = connection.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					statement.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					statement.closeOnCompletion();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	public static boolean getBool(String query, String columnName) {

		Object object = getObject(query, columnName);
		if (object instanceof Boolean) {
			return (boolean) object;
		}

		return false;

	}

	private static Connection getConnection() {

		boolean openConnection = false;
		try {
			openConnection = connection == null || connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (openConnection) {
			connection = getSQL().getConnection();
		}
		return connection;

	}

	public static double getDouble(String query, String columnName) {

		Object object = getObject(query, columnName);

		if (object instanceof Double) {
			return (double) object;
		}

		return 0.0;

	}

	public static float getFloat(String query, String columnName) {

		Object object = getObject(query, columnName);
		if (object instanceof Float) {
			return (float) object;
		}

		return 0f;

	}

	public static int getInt(String query, String columnName) {

		Object object = getObject(query, columnName);
		if (object instanceof Integer) {
			return (int) object;
		}

		return -1;

	}

	public static List<Object> getList(String query, String columnName) {

		List<Object> list = new ArrayList<Object>();
		ResultSet resultSet = getResultSet(query);

		try {
			if (!resultSet.isBeforeFirst()) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				list.add(resultSet.getObject(columnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public static Location getLocation(String query) {

		ResultSet resultSet = SQLServer.getResultSet(query);

		try {
			if (!resultSet.isBeforeFirst()) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int x = 0;
		int y = 0;
		int z = 0;
		String worldName = null;
		try {
			x = resultSet.getInt("X");
			y = resultSet.getInt("Y");
			z = resultSet.getInt("Z");
			worldName = resultSet.getString("World");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (worldName == null) {
			return null;
		}

		World world = plugin.getServer().getWorld(worldName);
		Location location = new Location(world, x, y, z);

		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return location;

	}

	public static long getLong(String query, String columnName) {

		Object object = getObject(query, columnName);
		if (object instanceof Long) {
			return (long) object;
		}

		return 0;

	}

	public static Object getObject(String query, String columnName) {

		ResultSet resultSet = getResultSet(query);

		// check if the result contained any data, if not return null
		try {
			if (!resultSet.isBeforeFirst()) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// select the result of the query
		try {
			resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// get the object from the result
		Object object = null;
		try {
			object = resultSet.getObject(columnName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return object;

	}

	public static ResultSet getResultSet(String query) {

		// get the SQL connection and prepare a SQL statement to execute the
		// query
		connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.closeOnCompletion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// get the result of the query, in this case a random message
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;

	}

	public static MySQL getSQL() {

		if (mySQL != null) {
			return mySQL;
		}
		return new MySQL(SQLServerData.HOSTNAME, SQLServerData.PORT,
				SQLServerData.DATABASE, SQLServerData.USERNAME,
				SQLServerData.PASSWORD);
	}

	public static String getString(String query, String columnName) {

		Object object = getObject(query, columnName);
		if (object instanceof String) {
			return (String) object;
		}

		return null;

	}

	public static void setPlugin(UtilitiesMain main) {
		plugin = main;
	}

}
