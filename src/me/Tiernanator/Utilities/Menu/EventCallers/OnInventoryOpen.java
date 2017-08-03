package me.Tiernanator.Utilities.Menu.EventCallers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.Menu.Menu;
import me.Tiernanator.Utilities.Menu.MenuEvents.MenuOpenEvent;
import me.Tiernanator.Utilities.MetaData.MetaData;

public class OnInventoryOpen implements Listener {

	private static UtilitiesMain plugin;

	public OnInventoryOpen(UtilitiesMain main) {
		plugin = main;
	}

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {

		if (event.isCancelled()) {
			return;
		}

		Player player = (Player) event.getPlayer();
		Menu menu = (Menu) MetaData.getMetadata(player, "Menu", plugin);
		if (menu == null) {
			return;
		}

		Inventory menuInventory = menu.getCurrentMenu();
		Inventory inventory = event.getInventory();

		if (menuInventory == null) {
			menuInventory = menu.generateMenu(player);
		}

		if (!menuInventory.equals(inventory)) {
			return;
		}

		MenuOpenEvent menuOpenEvent = new MenuOpenEvent(menu, player);
		plugin.getServer().getPluginManager().callEvent(menuOpenEvent);
		event.setCancelled(menuOpenEvent.isCancelled());
		
	}

}
