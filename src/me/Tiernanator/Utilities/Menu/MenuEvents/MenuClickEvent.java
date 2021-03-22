package me.Tiernanator.Utilities.Menu.MenuEvents;

import me.Tiernanator.Utilities.Menu.Menu;
import me.Tiernanator.Utilities.Menu.MenuEntry;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

//This is the custom custom menu click event that is called by OnPlayerMenuClick, it just contains functions that
//return all the values needed

public final class MenuClickEvent extends Event implements Cancellable {

	// handlers is a variable "handled"(...) by the server
	private static final HandlerList handlers = new HandlerList();
	public static HandlerList getHandlerList() {
		return handlers;
	}
	// the Custom Menu object which encompasses the open inventory
	private Menu menu;
	// the player who clicked
	private Player player;
	// the MenuEntry clicked contains item data, etc...
	private MenuEntry menuEntry;

	// Whether the event can continue or not is handled by isCancelled
	private boolean isCancelled;

	// constructor for the event that sets the variables
	public MenuClickEvent(Menu menu, Player player, MenuEntry menuEntry) {
		this.menu = menu;
		this.player = player;
		this.menuEntry = menuEntry;

	}
	// the next two are necessary for the server to use the event
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	// return the Menu within which was clicked
	public Menu getMenu() {
		return this.menu;
	}
	// return the type of click
	public MenuEntry getMenuEntry() {
		return this.menuEntry;
	}

	// get the player who done it
	public Player getPlayer() {
		return player;
	}

	// Just for cancelling the event
	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		isCancelled = cancel;

	}
}