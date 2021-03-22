package me.Tiernanator.Utilities.SQL;

import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Utilities.Players.PlayerLogger;

public enum SQLServerData {

	HOSTNAME(), PORT(), USERNAME(), PASSWORD(), DATABASE();

	private String info;

	SQLServerData() {

		JavaPlugin plugin = PlayerLogger.getPlugin();

		this.info = plugin.getConfig().getString("SQL." + this.name());
	}

	public String getInfo() {
		return this.info;
	}

}
