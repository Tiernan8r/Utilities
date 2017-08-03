package me.Tiernanator.Utilities.SQL;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.Players.PlayerLogger;

public enum SQLServerData {

	HOSTNAME(), PORT(), USERNAME(), PASSWORD(), DATABASE();

	private String info;
	private SQLServerData() {

		UtilitiesMain plugin = PlayerLogger.getPlugin();

		String info = plugin.getConfig().getString("SQL." + this.name());

		this.info = info;
	}

	public String getInfo() {
		return this.info;
	}

}
