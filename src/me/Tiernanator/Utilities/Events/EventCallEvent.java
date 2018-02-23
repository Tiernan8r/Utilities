package me.Tiernanator.Utilities.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class EventCallEvent extends Event {

	//handlers is a object list of all the handlers of the event
    private static final HandlerList handlers = new HandlerList();
    //The event called
    private Event event;
    //The Player the event was called for
    private Player player;
    //Whether or not to try to cancel the event
    private boolean tryCancel;
    
    //constructor for the event that sets the variables
    public EventCallEvent(Event event, Player player) {
    	this.event = event;
    	this.player = player;
    	this.trySetCancel(false);
    }

    //get the called Event
    public Event getCalledEvent() {
    	return this.event;
    }
    
    //Get the player
    public Player getPlayer() {
    	return this.player;
    }
    
    public boolean tryCancel() {
    	return this.tryCancel;
    }
    
    public void trySetCancel(boolean tryCancel) {
		this.tryCancel = tryCancel;
	}
    
    //the next two are necessary for the server to use the event
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}