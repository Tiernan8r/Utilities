package me.Tiernanator.Utilities.Menu.MenuEvents;

import me.Tiernanator.Utilities.Menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

//This is the custom custom menu open event that is called by OnInventoryOpenCancelled, it just contains functions that
//return all the values needed

public final class MenuOpenEvent extends Event implements Cancellable {

	// handlers is a variable "handled"(...) by the server
	private static final HandlerList handlers = new HandlerList();
	public static HandlerList getHandlerList() {
		return handlers;
	}
	// the Custom Menu object which contained the click action
	private Menu menu;
	// the player who clicked
	private Player player;

	// Whether the event can continue or not is handled by isCancelled
	private boolean isCancelled;

	// constructor for the event that sets the variables
	public MenuOpenEvent(Menu menu, Player player) {
		this.menu = menu;
		this.player = player;

	}
	// the next two are necessary for the server to use the event
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	// return the location clicked
	public Menu getMenu() {
		return this.menu;
	}

	// get the player who done it
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		isCancelled = cancel;

	}
}