package me.Tiernanator.Utilities.Players;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPlayer {

	public static OfflinePlayer getOfflinePlayer(String name) {

		PlayerLogger playerLogger = new PlayerLogger();
		String playerUUID = playerLogger.getPlayerUUIDByName(name);

		if (playerUUID == null) {
			return null;
		}
		OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
		if (offlinePlayers.length == 0) {
			return null;
		}
		for (int i = 0; i < offlinePlayers.length; i++) {
			String iUUID = offlinePlayers[i].getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				OfflinePlayer player = offlinePlayers[i];

				return player;
			}
		}
		return null;
	}

	public static OfflinePlayer getOfflinePlayer(String name,
			CommandSender sender, ChatColor warning, ChatColor highlight) {

		PlayerLogger playerLogger = new PlayerLogger();
		String playerUUID = playerLogger.getPlayerUUIDByName(name);

		if (playerUUID == null) {
			sender.sendMessage(highlight + name + warning
					+ " has never played on the server before.");
			return null;
		}
		OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
		if (offlinePlayers.length == 0) {
			sender.sendMessage(highlight + name + warning
					+ " has never played on the server before.");
			return null;
		}
		for (OfflinePlayer i : offlinePlayers) {
			String iUUID = i.getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				OfflinePlayer player = i.getPlayer();

				if (player == null) {
					sender.sendMessage(highlight + name + warning
							+ " has never played on the server before.");
				}

				return player;
			}
		}
		return null;
	}

	public static OfflinePlayer getOfflinePlayerByUUID(String playerUUID) {

		if (playerUUID == null) {
			return null;
		}
		OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
		if (offlinePlayers.length == 0) {
			return null;
		}
		for (int i = 0; i < offlinePlayers.length; i++) {
			String iUUID = offlinePlayers[i].getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				OfflinePlayer player = offlinePlayers[i];

				return player;
			}
		}
		return null;
	}

	public static Player getPlayer(String name) {

		PlayerLogger playerLogger = new PlayerLogger();
		String playerUUID = playerLogger.getPlayerUUIDByName(name);

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

	public static Player getPlayer(String name, CommandSender sender,
			ChatColor warning, ChatColor highlight) {

		PlayerLogger playerLogger = new PlayerLogger();
		String playerUUID = playerLogger.getPlayerUUIDByName(name);

		if (playerUUID == null) {
			sender.sendMessage(highlight + name + warning
					+ " has never played on the server before.");
			return null;
		}
		Collection<? extends Player> onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		if (onlinePlayers.isEmpty()) {
			sender.sendMessage(
					highlight + name + warning + " is not currently online.");
			return null;
		}
		for (Player i : onlinePlayers) {
			String iUUID = i.getUniqueId().toString();

			if (playerUUID.equals(iUUID)) {
				Player player = i.getPlayer();
				if (player == null) {
					sender.sendMessage(highlight + name + warning
							+ " is not currently online?");
				}

				return player;
			}
		}
		sender.sendMessage(highlight + name + warning
				+ " has never played on the server before.");
		return null;
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
