package me.Tiernanator.Utilities.Players;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.Utilities.Main;

public class PlayerLogger implements Listener {

	private static Main plugin;

	public PlayerLogger(Main main) {
		plugin = main;
	}

	public PlayerLogger() {
	}

	public static Main getPlugin() {
		return plugin;
	}

	/*
	 * This class logs a player into SQL, only if they are not registered
	 * already
	 */
	@EventHandler
	public void logPlayerJoin(PlayerJoinEvent event) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				// get the player
				Player player = (Player) event.getPlayer();

				if (player.hasPlayedBefore() || hasValue(player)) {
					return;
				}

				Connection connection = Main.getSQL().getConnection();
				PreparedStatement preparedStatement = null;
				try {
					preparedStatement = connection.prepareStatement(
							"INSERT INTO Players (Name, UUID) VALUES (?, ?);");
					preparedStatement.setString(1, player.getName());
					preparedStatement.setString(2,
							player.getUniqueId().toString());
					preparedStatement.executeUpdate();
					preparedStatement.closeOnCompletion();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		};
		runnable.runTaskAsynchronously(plugin);
	}

	public String getPlayerUUIDByName(String name) {

		String query = "SELECT UUID FROM Players WHERE Name = ?;";

		Connection connection = Main.getSQL().getConnection();
		PreparedStatement preparedStatement = null;
		String playerUUID = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				return null;
			}
			resultSet.next();
			playerUUID = resultSet.getString("UUID");
			preparedStatement.closeOnCompletion();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerUUID;
	}

	public String getPlayerNameByUUID(String uuid) {

		String query = "SELECT Name FROM Players WHERE UUID = ?;";

		Connection connection = Main.getSQL().getConnection();
		PreparedStatement preparedStatement = null;
		String playerName = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uuid);
			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				return null;
			}
			resultSet.next();
			playerName = resultSet.getString("Name");
			preparedStatement.closeOnCompletion();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerName;

	}

	private boolean hasValue(Player player) {

		String query = "SELECT Name FROM Players WHERE UUID = ?;";

		String playerUUID = player.getUniqueId().toString();
		Connection connection = Main.getSQL().getConnection();
		PreparedStatement preparedStatement = null;
		String resultName = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, playerUUID);
			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				return false;
			}
			resultSet.next();

			resultName = resultSet.getString("Name");
			preparedStatement.closeOnCompletion();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String playerName = player.getName();

		return playerName.equalsIgnoreCase(resultName);

	}

}
