package me.Tiernanator.Menu.EventCancelledHandlers;

import org.bukkit.event.Listener;

import me.Tiernanator.Utilities.Main;


public class OnInventoryOpenCancelled implements Listener {

	@SuppressWarnings("unused")
	private static Main plugin;
	
	public OnInventoryOpenCancelled(Main main) {
		plugin = main;
	}
	
//	private boolean isCancelled = false;
//
//	@EventHandler
//	public void onInventoryClick(MenuOpenEvent event) {
//		isCancelled = event.isCancelled();
//	}
//	
//	@EventHandler
//	public void onInventoryClick(InventoryOpenEvent event) {
//		event.setCancelled(isCancelled);
//	}

}
