package me.Tiernanator.Utilities.Events.Handlers;

import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamageEntityEvent;
import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamagePlayerEvent;
import me.Tiernanator.Utilities.Events.EventCallEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;

@SuppressWarnings("deprecation")
public class AllEventsEventHandler implements Listener {

	@EventHandler
	public void eventCall(PlayerArmorStandManipulateEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());
	}

	@EventHandler
	public void eventCall(PlayerBedEnterEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());
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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerBucketFillEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());
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

		event.setCancelled(eventCallEvent.tryCancel());
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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerDropItemEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerEditBookEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerGameModeChangeEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerInteractAtEntityEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerItemHeldEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerPickupArrowEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		if (eventCallEvent.tryCancel()) {
			event.setCancelled(true);
		}

	}

	@EventHandler
	public void eventCall(PlayerPickupItemEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerPortalEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerStatisticIncrementEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerSwapHandItemsEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerTeleportEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerToggleFlightEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerToggleSneakEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerToggleSprintEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerUnleashEntityEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

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

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(BlockBreakEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(BlockDamageEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(BlockIgniteEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(BlockMultiPlaceEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(BlockPlaceEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(SignChangeEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerDamageEntityEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

	@EventHandler
	public void eventCall(PlayerDamagePlayerEvent event) {

		Player player = event.getPlayer();

		EventCallEvent eventCallEvent = new EventCallEvent(event, player);
		Bukkit.getServer().getPluginManager().callEvent(eventCallEvent);

		event.setCancelled(eventCallEvent.tryCancel());

	}

}
