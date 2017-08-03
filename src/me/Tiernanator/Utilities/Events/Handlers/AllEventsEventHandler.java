package me.Tiernanator.Utilities.Events.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

import me.Tiernanator.Utilities.Events.EventCallEvent;
import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamageEntityEvent;
import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamagePlayerEvent;

@SuppressWarnings("deprecation")
public class AllEventsEventHandler implements Listener {

	@EventHandler
	public void eventCall(PlayerArmorStandManipulateEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerBedEnterEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerBedLeaveEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerBucketEmptyEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerBucketFillEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerChangedMainHandEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerChangedWorldEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerChannelEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerChatEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerChatTabCompleteEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerCommandPreprocessEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerDropItemEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerEditBookEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerEggThrowEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerExpChangeEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerFishEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerGameModeChangeEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerInteractAtEntityEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerItemBreakEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerItemConsumeEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
	
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerItemHeldEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerJoinEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerKickEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerLevelChangeEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerLocaleChangeEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerLoginEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerMoveEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerPickupArrowEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerPickupItemEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerPortalEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerQuitEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerRegisterChannelEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerResourcePackStatusEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
//	@EventHandler
//	public void eventCall(PlayerRespawnEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerShearEntityEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerStatisticIncrementEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerSwapHandItemsEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerTeleportEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerToggleFlightEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerToggleSneakEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerToggleSprintEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerUnleashEntityEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
//	@EventHandler
//	public void eventCall(PlayerUnregisterChannelEvent event) {
//
//		Player player = event.getPlayer();
//		
//		CustomEventCallEvent eventCallEvent = new CustomEventCallEvent(event, player);
//		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
//		
//	}
	
	@EventHandler
	public void eventCall(PlayerVelocityEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(BlockBreakEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(BlockDamageEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(BlockIgniteEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(BlockMultiPlaceEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(BlockPlaceEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(SignChangeEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerDamageEntityEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void eventCall(PlayerDamagePlayerEvent event) {

		Player player = event.getPlayer();
		
		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);
		
		if(eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}
		
	}
	
}
