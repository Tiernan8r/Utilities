package me.Tiernanator.Utilities.Events.CustomEvents;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageEntityEvent extends Event implements Cancellable {

	// handlers is a variable "handled"(...) by the server
	private static final HandlerList handlers = new HandlerList();
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	// the entity that was attacked
	private Entity entity;
	// the player who attacked
	private Player player;
	// the original entity damage by entity event, containing extra parameters.
	private EntityDamageByEntityEvent originalEvent;

	// Whether the event can continue or not is handled by isCancelled
	private boolean isCancelled;

	// constructor for the event that sets the variables
	public PlayerDamageEntityEvent(Player player, Entity entity, EntityDamageByEntityEvent originalEvent) {

		this.player = player;
		this.entity = entity;
		this.originalEvent = originalEvent;
		
	}
	// the next two are necessary for the server to use the event
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	// get the player who done it
	public Player getPlayer() {
		return player;
	}

	public Entity getEntity() {
		return this.entity;
	}
	
	public EntityDamageByEntityEvent getOriginalEvent() {
		return this.originalEvent;
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