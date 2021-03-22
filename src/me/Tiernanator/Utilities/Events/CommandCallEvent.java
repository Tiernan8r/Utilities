package me.Tiernanator.Utilities.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class CommandCallEvent extends Event implements Cancellable {
	
	//handlers is a variable "handled"(...) by the server
    private static final HandlerList handlers = new HandlerList();
    //The event called
    private String commandName;
    //The Player the event was called for
    private Player player;
    //Whether or not to try to cancel the event
    private boolean cancelled;
    
    //constructor for the event that sets the variables
    public CommandCallEvent(String commandName, Player player) {
    	this.commandName = commandName;
    	this.player = player;
    }

    //get the called Event
    public String getCalledCommandName() {
    	return this.commandName;
    }
    
    //Get the player
    public Player getPlayer() {
    	return this.player;
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
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}