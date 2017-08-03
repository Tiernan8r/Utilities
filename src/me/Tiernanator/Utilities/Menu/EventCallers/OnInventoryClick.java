package me.Tiernanator.Utilities.Menu.EventCallers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Utilities.UtilitiesMain;
import me.Tiernanator.Utilities.Menu.Menu;
import me.Tiernanator.Utilities.Menu.MenuEntry;
import me.Tiernanator.Utilities.Menu.MenuEvents.MenuClickEvent;
import me.Tiernanator.Utilities.MetaData.MetaData;

public class OnInventoryClick implements Listener {

	private static UtilitiesMain plugin;

	public OnInventoryClick(UtilitiesMain main) {
		plugin = main;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.isCancelled()) {
			return;
		}

		Player player = (Player) event.getWhoClicked();
		Menu menu = (Menu) MetaData.getMetadata(player, "Menu", plugin);
		if (menu == null) {
			return;
		}

		Inventory menuInventory = menu.getCurrentMenu();
		if (menuInventory == null) {
			menuInventory = menu.generateMenu(player);
		}
		Inventory inventory = event.getInventory();

		if (!menuInventory.equals(inventory)) {
			return;
		}

		ItemStack item = event.getCurrentItem();

		if (item == null) {
			return;
		}

		MenuEntry menuEntry = MenuEntry.getMenuEntry(item);

		if (menuEntry == null) {
			return;
		}

		MenuClickEvent menuClickEvent = new MenuClickEvent(menu, player,
				menuEntry);
		try {
			plugin.getServer().getPluginManager().callEvent(menuClickEvent);
		} catch (Exception e) {
		}
		// plugin.getServer().getPluginManager().callEvent(menuClickEvent);
		event.setCancelled(menuClickEvent.isCancelled());
	}

}
