package me.Tiernanator.Utilities.SQL;

import me.Tiernanator.Utilities.Players.PlayerLogger;
import me.Tiernanator.Utilities.UtilitiesMain;

public enum SQLServerData {

	HOSTNAME(), PORT(), USERNAME(), PASSWORD(), DATABASE();

	private String info;

	SQLServerData() {

		UtilitiesMain plugin = PlayerLogger.getPlugin();

		this.info = plugin.getConfig().getString("SQL." + this.name());
		;
	}

	public String getInfo() {
		return this.info;
	}

}
