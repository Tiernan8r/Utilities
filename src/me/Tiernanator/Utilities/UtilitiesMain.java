package me.Tiernanator.Utilities;

import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Utilities.Events.Handlers.AllCommandsEventHandler;
import me.Tiernanator.Utilities.Events.Handlers.AllCustomPlayerEventsEventHandler;
import me.Tiernanator.Utilities.Events.Handlers.AllEventsEventHandler;
import me.Tiernanator.Utilities.Locations.Region.Region;
import me.Tiernanator.Utilities.Locations.Region.Shapes;
import me.Tiernanator.Utilities.Materials.BuildingMaterial;
import me.Tiernanator.Utilities.Menu.Menu;
import me.Tiernanator.Utilities.Menu.MenuEntry;
import me.Tiernanator.Utilities.Menu.OnMenuEntryClick;
import me.Tiernanator.Utilities.Menu.EventCallers.OnInventoryClick;
import me.Tiernanator.Utilities.Menu.EventCallers.OnInventoryClose;
import me.Tiernanator.Utilities.Menu.EventCallers.OnInventoryOpen;
import me.Tiernanator.Utilities.Players.PlayerLogger;
import me.Tiernanator.Utilities.Players.PlayerTime;
import me.Tiernanator.Utilities.SQL.SQLServer;
import me.Tiernanator.Utilities.SQL.SQLServerData;
import me.Tiernanator.Utilities.SQL.MySQL.MySQL;

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
		
		for(Player onlinePlayer : getServer().getOnlinePlayers()) {
			PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(onlinePlayer, "");
			getServer().getPluginManager().callEvent(playerJoinEvent);
		}

	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerLogger(this), this);

		pm.registerEvents(new OnInventoryClick(this), this);
		pm.registerEvents(new OnInventoryOpen(this), this);
		pm.registerEvents(new OnInventoryClose(this), this);

		pm.registerEvents(new AllEventsEventHandler(), this);
		pm.registerEvents(new AllCommandsEventHandler(), this);
		pm.registerEvents(new AllCustomPlayerEventsEventHandler(), this);
		
		// pm.registerEvents(new OnInventoryClickCancelled(this), this);
		// pm.registerEvents(new OnInventoryOpenCancelled(this), this);

		pm.registerEvents(new OnMenuEntryClick(this), this);
	}

	private void setPlugin() {
		SQLServer.setPlugin(this);
		BuildingMaterial.setPlugin(this);
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
