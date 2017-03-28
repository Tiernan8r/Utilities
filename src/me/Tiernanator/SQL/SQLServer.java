package me.Tiernanator.SQL;

import me.Tiernanator.Utilities.Main;
import me.Tiernanator.Utilities.Players.PlayerLogger;

public enum SQLServer {

	HOSTNAME(),
	PORT(),
	USERNAME(),
	PASSWORD(),
	DATABASE();
	
	private String info;
	private SQLServer() {
		
		Main plugin = PlayerLogger.getPlugin();
		
		String info = plugin.getConfig().getString("SQL." + this.name());
		
		this.info = info;
	}
	
	public String getInfo() {
		return this.info;
	}
	
}
