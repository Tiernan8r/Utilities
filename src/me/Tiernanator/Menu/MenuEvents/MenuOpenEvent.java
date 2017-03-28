package me.Tiernanator.Menu.MenuEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.Tiernanator.Menu.Menu;

//This is the custom custom menu open event that is called by OnInventoryOpenCancelled, it just contains functions that
//return all the values needed

public final class MenuOpenEvent extends Event implements Cancellable {
	
	//handlers is a variable "handled"(...) by the server
    private static final HandlerList handlers = new HandlerList();
    //the Custom Menu object which contained the click action
    private Menu menu;
    //the player who clicked
    private Player player;
    //Whether the event can continue or not is handled by isCancelled
    private boolean isCancelled;

    //constructor for the event that sets the variables
    public MenuOpenEvent(Menu menu, Player player) {
        this.menu = menu;
        this.player = player;
        
    }

    //return the location clicked
    public Menu getMenu() {
        return this.menu;
    }
    //get the player who done it
    public Player getPlayer() {
        return player;
    }
    //the next two are necessary for the server to use the event
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
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