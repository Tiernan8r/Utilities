package me.Tiernanator.Utilities.Players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class GetPlayer {

	public static OfflinePlayer getOfflinePlayer(String name) {

		String playerUUID = PlayerLogger.getPlayerUUIDByName(name);

		return getOfflinePlayerByUUID(playerUUID);
	}

	public static OfflinePlayer getOfflinePlayer(String name,
			CommandSender sender, ChatColor warning, ChatColor highlight) {

		OfflinePlayer player = getOfflinePlayer(name);

		if (player == null) {
			sender.sendMessage(highlight + name + warning
					+ " has never played on the server before.");
		}

		return player;

	}

	public static OfflinePlayer getOfflinePlayerByUUID(String playerUUID) {

		if (playerUUID == null) {
			return null;
		}
		OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
		if (offlinePlayers.length == 0) {
			return null;
		}
		for (OfflinePlayer offlinePlayer : offlinePlayers) {
			String iUUID = offlinePlayer.getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				return offlinePlayer;
			}
		}
		return null;
	}

	public static Player getPlayer(String name) {

		String playerUUID = PlayerLogger.getPlayerUUIDByName(name);
		return getPlayerByUUID(playerUUID);

	}

	public static Player getPlayer(String name, CommandSender sender,
			ChatColor warning, ChatColor highlight) {

		OfflinePlayer offlinePlayer = getOfflinePlayer(name);

		if (offlinePlayer == null) {
			sender.sendMessage(highlight + name + warning
					+ " has never played on the server before.");
			return null;
		}
		if (!offlinePlayer.isOnline()) {
			sender.sendMessage(
					highlight + name + warning + " is not currently online.");
			return null;
		}

		return offlinePlayer.getPlayer();

	}

	public static Player getPlayerByUUID(String playerUUID) {

		if (playerUUID == null) {
			return null;
		}
		Collection<? extends Player> onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		if (onlinePlayers.isEmpty()) {
			return null;
		}
		for (Player player : onlinePlayers) {
			String iUUID = player.getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				return player;
			}
		}
		return null;
	}

}
