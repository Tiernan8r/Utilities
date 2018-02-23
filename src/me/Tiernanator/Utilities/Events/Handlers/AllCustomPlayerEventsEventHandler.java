package me.Tiernanator.Utilities.Events.Handlers;

import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamageEntityEvent;
import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamagePlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AllCustomPlayerEventsEventHandler implements Listener {

	@EventHandler
	public void onPlayerAttackPlayer(EntityDamageByEntityEvent event) {
		
		if (!(event.getEntity() instanceof Player)) {
			return;
		}

		Entity attackedEntity = event.getEntity();
		Player attacker = (Player) event.getDamager();
		Player attackedPlayer = null;
		
		if(attackedEntity instanceof Player) {
			attackedPlayer = (Player) attackedEntity;
		}
		
		PlayerDamageEntityEvent playerDamageEntityEvent = new PlayerDamageEntityEvent(attacker, attackedEntity, event);
		PlayerDamagePlayerEvent playerDamagePlayerEvent = new PlayerDamagePlayerEvent(attacker, attackedPlayer, event);
		
		if(attackedPlayer != null) {
			Bukkit.getServer().getPluginManager().callEvent(playerDamagePlayerEvent);
		}
		Bukkit.getServer().getPluginManager().callEvent(playerDamageEntityEvent);

		event.setCancelled(playerDamageEntityEvent.isCancelled() || playerDamagePlayerEvent.isCancelled());

	}
	
}
