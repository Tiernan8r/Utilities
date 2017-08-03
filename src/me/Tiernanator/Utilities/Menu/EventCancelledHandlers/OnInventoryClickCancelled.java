package me.Tiernanator.Utilities.Menu.EventCancelledHandlers;

import org.bukkit.event.Listener;

import me.Tiernanator.Utilities.UtilitiesMain;

public class OnInventoryClickCancelled implements Listener {

	@SuppressWarnings("unused")
	private static UtilitiesMain plugin;

	public OnInventoryClickCancelled(UtilitiesMain main) {
		plugin = main;
	}

	// private boolean isCancelled = false;

	// @EventHandler
	// public void onInventoryClick(InventoryClickEvent event) {
	// event.setCancelled(isCancelled);
	// }

	// @EventHandler
	// public void onInventoryClick(MenuClickEvent event) {
	// isCancelled = event.isCancelled();
	// }

}
