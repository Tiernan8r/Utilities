package me.Tiernanator.Menu.EventCancelledHandlers;

import org.bukkit.event.Listener;

import me.Tiernanator.Utilities.UtilitiesMain;

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
