package me.Tiernanator.Utilities.Events.CustomEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class PlayerDamagePlayerEvent extends PlayerDamageEntityEvent implements Cancellable {

	// handlers is a variable "handled"(...) by the server
	private static final HandlerList handlers = new HandlerList();
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	// the player who was attacked
	private Player attackedPlayer;

	// Whether the event can continue or not is handled by isCancelled
	private boolean isCancelled;

	// constructor for the event that sets the variables
	public PlayerDamagePlayerEvent(Player player, Player attackedPlayer, EntityDamageByEntityEvent originalEvent) {

		super(player, attackedPlayer, originalEvent);
		
		this.attackedPlayer = attackedPlayer;
		
	}
	
	// the next two are necessary for the server to use the event
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public Player getAttackedPlayer() {
		return this.attackedPlayer;
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