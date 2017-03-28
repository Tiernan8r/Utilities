package me.Tiernanator.Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Menu.Menu;
import me.Tiernanator.Menu.MenuEntry;
import me.Tiernanator.Menu.OnMenuEntryClick;
import me.Tiernanator.Menu.EventCallers.OnInventoryClick;
import me.Tiernanator.Menu.EventCallers.OnInventoryClose;
import me.Tiernanator.Menu.EventCallers.OnInventoryOpen;
import me.Tiernanator.Menu.EventCancelledHandlers.OnInventoryClickCancelled;
import me.Tiernanator.Menu.EventCancelledHandlers.OnInventoryOpenCancelled;
import me.Tiernanator.SQL.SQLServer;
import me.Tiernanator.SQL.MySQL.MySQL;
import me.Tiernanator.Utilities.Locations.Region.Region;
import me.Tiernanator.Utilities.Locations.Region.Shapes;
import me.Tiernanator.Utilities.Players.PlayerLogger;
import me.Tiernanator.Utilities.Players.PlayerTime;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		setPlugin();
		registerEvents();
		initialiseSQL();
		
	}

	@Override
	public void onDisable() {
		
		try {
			getSQL().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void setPlugin() {
		Region.setPlugin(this);
		MenuEntry.setPlugin(this);
		Menu.setPlugin(this);
		MySQL.setPlugin(this);
		PlayerTime.setPlugin(this);
		Shapes.setPlugin(this);
	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerLogger(this), this);
		
		pm.registerEvents(new OnInventoryClick(this), this);
		pm.registerEvents(new OnInventoryOpen(this), this);
		pm.registerEvents(new OnInventoryClose(this), this);
		
		pm.registerEvents(new OnInventoryClickCancelled(this), this);
		pm.registerEvents(new OnInventoryOpenCancelled(this), this);
		
		pm.registerEvents(new OnMenuEntryClick(this), this);
	}

	private static MySQL mySQL;

	private void initialiseSQL() {
		
		mySQL = new MySQL(SQLServer.HOSTNAME, SQLServer.PORT, SQLServer.DATABASE,
				SQLServer.USERNAME, SQLServer.PASSWORD);
		
		Connection connection = null;
		try {
			connection = mySQL.openConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query = "USE " + SQLServer.DATABASE.getInfo() + ";";
		
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		query = "CREATE TABLE IF NOT EXISTS Players ( "
				+ "Name varchar(255) NOT NULL, "
				+ "UUID varchar(36) NOT NULL"
				+ ");";
		
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		query = "CREATE TABLE IF NOT EXISTS PlayerTime ( "
				+ "UUID varchar(36) NOT NULL,"
				+ "Time BIGINT NOT NULL"
				+ ");";
		
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement.closeOnCompletion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static MySQL getSQL() {
		return mySQL;
	}

}
