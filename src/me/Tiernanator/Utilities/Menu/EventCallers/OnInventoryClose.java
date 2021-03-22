package me.Tiernanator.Utilities.Menu.EventCallers;

import me.Tiernanator.Utilities.Menu.Menu;
import me.Tiernanator.Utilities.Menu.MenuEvents.MenuCloseEvent;
import me.Tiernanator.Utilities.MetaData.MetaData;
import me.Tiernanator.Utilities.UtilitiesMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class OnInventoryClose implements Listener {

	private static UtilitiesMain plugin;

	public OnInventoryClose(UtilitiesMain main) {
		plugin = main;
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {

		Player player = (Player) event.getPlayer();
		Menu menu = (Menu) MetaData.getMetadata(player, "Menu", plugin);
		if (menu == null) {
			return;
		}

		Inventory menuInventory = menu.getCurrentMenu();
		Inventory inventory = event.getInventory();

		if (!menuInventory.equals(inventory)) {
			return;
		}

		MenuCloseEvent menuCloseEvent = new MenuCloseEvent(menu, player);
		plugin.getServer().getPluginManager().callEvent(menuCloseEvent);
	}

}
