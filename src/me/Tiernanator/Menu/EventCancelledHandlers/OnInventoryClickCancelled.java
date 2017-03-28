package me.Tiernanator.Menu.EventCancelledHandlers;

import org.bukkit.event.Listener;

import me.Tiernanator.Utilities.Main;


public class OnInventoryClickCancelled implements Listener {

	@SuppressWarnings("unused")
	private static Main plugin;
	
	public OnInventoryClickCancelled(Main main) {
		plugin = main;
	}

//	private boolean isCancelled = false;
	
//	@EventHandler
//	public void onInventoryClick(InventoryClickEvent event) {
//		event.setCancelled(isCancelled);
//	}
	
//	@EventHandler
//	public void onInventoryClick(MenuClickEvent event) {
//		isCancelled = event.isCancelled();
//	}

}
