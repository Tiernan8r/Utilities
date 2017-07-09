package me.Tiernanator.Utilities.Players;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.SQL.SQLServer;
import me.Tiernanator.Utilities.UtilitiesMain;

public class PlayerTime {

	private static UtilitiesMain plugin;
	public static void setPlugin(UtilitiesMain main) {
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

	public void addPlayerTime(long time) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				String playerUUID = getPlayer().getUniqueId().toString();

				if (hasPlayerTime()) {

					String query = "UPDATE PlayerTime SET Time = ? WHERE UUID = ?;";
					Object[] values = new Object[]{time, playerUUID};
					SQLServer.executePreparedStatement(query, values);

				} else {

					String statement = "INSERT INTO PlayerTime (UUID, Time) VALUES (?, ?);";
					Object[] values = new Object[]{playerUUID, time};
					SQLServer.executePreparedStatement(statement, values);

				}
			}

		};
		runnable.runTaskAsynchronously(plugin);

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

	public boolean hasPlayerTime() {

		String playerUUID = getPlayer().getUniqueId().toString();
		boolean hasValue = false;
		String query = "SELECT Time FROM PlayerTime WHERE UUID = '" + playerUUID
				+ "';";

		ResultSet resultSet = SQLServer.getResultSet(query);
		try {
			hasValue = resultSet.isBeforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasValue;

	}

	private long previousPlayerTime() {

		String playerUUID = getPlayer().getUniqueId().toString();

		String query = "SELECT Time FROM PlayerTime WHERE UUID = '" + playerUUID
				+ "';";
		long playerTime = SQLServer.getLong(query, "Time");

		return playerTime;
	}

	public void setPlayerTime(long playerTime) {
		addPlayerTime(getPlayerTime());
		this.previousTime = getPlayerTime();
		this.playerTime = playerTime;
	}

}
