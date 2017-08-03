package me.Tiernanator.Utilities.Players;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.SQL.SQLServer;

public class PlayerLogger implements Listener {

	private static UtilitiesMain plugin;

	public static UtilitiesMain getPlugin() {
		return plugin;
	}

	public PlayerLogger(UtilitiesMain main) {
		plugin = main;
	}

	public static String getPlayerNameByUUID(String uuid) {

		String query = "SELECT Name FROM Players WHERE UUID = '" + uuid + "';";

		String playerName = SQLServer.getString(query, "Name");

		return playerName;

	}

	public static String getPlayerUUIDByName(String name) {

		String query = "SELECT UUID FROM Players WHERE Name = '" + name + "';";

		String playerUUID = SQLServer.getString(query, "UUID");

		return playerUUID;
	}

	private static boolean hasValue(Player player) {

		String playerUUID = player.getUniqueId().toString();
		String storedUUID = getPlayerUUIDByName(player.getName());

		if (storedUUID == null) {
			return false;
		}
		return playerUUID.equalsIgnoreCase(storedUUID);

	}

	/*
	 * This class logs a player into SQL, only if they are not registered
	 * already
	 */
	@EventHandler
	public void logPlayerJoin(PlayerJoinEvent event) {

		// get the player
		Player player = event.getPlayer();

		if (player.hasPlayedBefore() || hasValue(player)) {
			return;
		}
		String playerName = player.getName();
		String playerUUID = player.getUniqueId().toString();

		String statement = "INSERT INTO Players (Name, UUID) VALUES (?, ?);";
		Object[] values = new Object[]{playerName, playerUUID};
		SQLServer.executePreparedStatement(statement, values);

	}

}
