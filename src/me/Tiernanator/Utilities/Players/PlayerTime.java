package me.Tiernanator.Utilities.Players;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.Utilities.Main;

public class PlayerTime {

	private static Main plugin;
	public static void setPlugin(Main main) {
		plugin = main;
	}

	private long playerTime;
	private long previousTime;
	private Player player;

	public PlayerTime(Player player) {
		this.player = player;
		this.previousTime = previousPlayerTime();
		this.playerTime = System.currentTimeMillis();
	}

	public Player getPlayer() {
		return this.player;
	}

	public long getPlayerTime() {
		return this.playerTime;
	}
	
	public long getPreviousPlayerTime() {
		return this.previousTime;
	}

	public void setPlayerTime(long playerTime) {
		addPlayerTime(getPlayerTime());
		this.previousTime = getPlayerTime();
		this.playerTime = playerTime;
	}

	private long previousPlayerTime() {

		String playerUUID = getPlayer().getUniqueId().toString();

		String query = "SELECT Time FROM PlayerTime WHERE UUID = ?;";

		Connection connection = Main.getSQL().getConnection();
		PreparedStatement preparedStatement = null;

		long playerTime = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, playerUUID);

			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				playerTime = 0;
				return playerTime;
			}
			resultSet.next();
			playerTime = resultSet.getLong("Time");
			preparedStatement.closeOnCompletion();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerTime;
	}

	public void addPlayerTime(long time) {

//		setPlayerTime(time);

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				String playerUUID = getPlayer().getUniqueId().toString();

				if (hasPlayerTime()) {

					String query = "UPDATE PlayerTime SET Time = ? WHERE UUID = ?;";
					Connection connection = Main.getSQL().getConnection();
					PreparedStatement preparedStatement = null;
					try {
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setLong(1, time);
						preparedStatement.setString(2, playerUUID);
						preparedStatement.executeUpdate();
						preparedStatement.closeOnCompletion();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} else {

					Connection connection = Main.getSQL().getConnection();
					PreparedStatement preparedStatement = null;
					try {
						preparedStatement = connection.prepareStatement(
								"INSERT INTO PlayerTime (UUID, Time) VALUES (?, ?);");
						preparedStatement.setString(1, playerUUID);
						preparedStatement.setLong(2, time);
						preparedStatement.executeUpdate();
						preparedStatement.closeOnCompletion();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}

		};
		runnable.runTaskAsynchronously(plugin);

	}

	public boolean hasPlayerTime() {

		String playerUUID = getPlayer().getUniqueId().toString();
		boolean hasValue = false;
		String query = "SELECT Time FROM PlayerTime WHERE UUID = ?;";

		Connection connection = Main.getSQL().getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, playerUUID);
			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
			hasValue = resultSet.isBeforeFirst();
			preparedStatement.closeOnCompletion();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasValue;

	}

}
