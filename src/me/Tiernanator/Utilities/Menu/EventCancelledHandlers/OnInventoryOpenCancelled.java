package me.Tiernanator.Utilities.Menu.EventCancelledHandlers;

import me.Tiernanator.Utilities.UtilitiesMain;
import org.bukkit.event.Listener;

public class OnInventoryOpenCancelled implements Listener {

	@SuppressWarnings("unused")
	private static UtilitiesMain plugin;

	public OnInventoryOpenCancelled(UtilitiesMain main) {
		plugin = main;
	}

	// private boolean isCancelled = false;
	//
	// @EventHandler
	// public void onInventoryClick(MenuOpenEvent event) {
	// isCancelled = event.isCancelled();
	// }
	//
	// @EventHandler
	// public void onInventoryClick(InventoryOpenEvent event) {
	// event.setCancelled(isCancelled);
	// }

}
