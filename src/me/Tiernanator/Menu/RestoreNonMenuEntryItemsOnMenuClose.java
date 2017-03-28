package me.Tiernanator.Menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Menu.MenuEvents.MenuCloseEvent;
import me.Tiernanator.Utilities.Main;

public class RestoreNonMenuEntryItemsOnMenuClose implements Listener {

	public RestoreNonMenuEntryItemsOnMenuClose(Main main) {
	}
	
	@EventHandler
	public void onMenuClose(MenuCloseEvent event) {

		if(event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		Menu menu = event.getMenu();
		
		Inventory menuInventory = menu.getCurrentMenu();
		for(ItemStack item : menuInventory.getContents()) {
			
			if(item == null || item.getType() == Material.AIR) {
				continue;
			}
			
			MenuEntry menuEntry = MenuEntry.getMenuEntry(item);
			if(menuEntry == null) {
				player.getInventory().addItem(item);
			}
			
		}
		
	}

}
