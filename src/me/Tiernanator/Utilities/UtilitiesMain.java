package me.Tiernanator.Utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Menu.Menu;
import me.Tiernanator.Menu.MenuEntry;
import me.Tiernanator.Menu.OnMenuEntryClick;
import me.Tiernanator.Menu.EventCallers.OnInventoryClick;
import me.Tiernanator.Menu.EventCallers.OnInventoryClose;
import me.Tiernanator.Menu.EventCallers.OnInventoryOpen;
import me.Tiernanator.SQL.SQLServer;
import me.Tiernanator.SQL.SQLServerData;
import me.Tiernanator.SQL.MySQL.MySQL;
import me.Tiernanator.Utilities.Locations.Region.Region;
import me.Tiernanator.Utilities.Locations.Region.Shapes;
import me.Tiernanator.Utilities.Players.PlayerLogger;
import me.Tiernanator.Utilities.Players.PlayerTime;

public class UtilitiesMain extends JavaPlugin {

	@Override
	public void onDisable() {

		try {
			SQLServer.getSQL().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onEnable() {

		setPlugin();
		registerEvents();
		initialiseSQL();

		List<String> customWorldNames = getConfig()
				.getStringList("CustomWorlds");
		if (customWorldNames != null) {
			for (String worldName : customWorldNames) {
				try {
				WorldCreator worldCreator = new WorldCreator(worldName);
				worldCreator.createWorld();
				} catch(Exception e) {
					getLogger().log(Level.WARNING, "Could not load world: " + worldName);
				}
			}
		}
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerLogger(this), this);

		pm.registerEvents(new OnInventoryClick(this), this);
		pm.registerEvents(new OnInventoryOpen(this), this);
		pm.registerEvents(new OnInventoryClose(this), this);

		// pm.registerEvents(new OnInventoryClickCancelled(this), this);
		// pm.registerEvents(new OnInventoryOpenCancelled(this), this);

		pm.registerEvents(new OnMenuEntryClick(this), this);
	}

	private void setPlugin() {
		SQLServer.setPlugin(this);
		Region.setPlugin(this);
		MenuEntry.setPlugin(this);
		Menu.setPlugin(this);
		MySQL.setPlugin(this);
		PlayerTime.setPlugin(this);
		Shapes.setPlugin(this);
	}

	private void initialiseSQL() {

		String query = "USE " + SQLServerData.DATABASE.getInfo() + ";";
		SQLServer.executeQuery(query);

		query = "CREATE TABLE IF NOT EXISTS Players ( "
				+ "Name varchar(255) NOT NULL, " + "UUID varchar(36) NOT NULL"
				+ ");";
		SQLServer.executeQuery(query);

		query = "CREATE TABLE IF NOT EXISTS PlayerTime ( "
				+ "UUID varchar(36) NOT NULL," + "Time BIGINT NOT NULL" + ");";
		SQLServer.executeQuery(query);

	}

}
