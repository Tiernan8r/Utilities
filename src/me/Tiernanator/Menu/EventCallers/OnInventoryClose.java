package me.Tiernanator.Menu.EventCallers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import me.Tiernanator.Menu.Menu;
import me.Tiernanator.Menu.MenuEvents.MenuCloseEvent;
import me.Tiernanator.Utilities.Main;
import me.Tiernanator.Utilities.MetaData.MetaData;


public class OnInventoryClose implements Listener {

	private static Main plugin;
	
	public OnInventoryClose(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {

		Player player = (Player) event.getPlayer();
		Menu menu = (Menu) MetaData.getMetadata(player, "Menu", plugin);
		if(menu == null) {
			return;
		}
		
		Inventory menuInventory = menu.getCurrentMenu();
		Inventory inventory = event.getInventory();

		if(!menuInventory.equals(inventory)) {
			return;
		}
		
		MenuCloseEvent menuCloseEvent = new MenuCloseEvent(menu, player);
		Bukkit.getServer().getPluginManager().callEvent(menuCloseEvent);
	}

}
