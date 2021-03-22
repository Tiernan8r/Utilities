package me.Tiernanator.Utilities.Events.Handlers;

import me.Tiernanator.Utilities.Events.CommandCallEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class AllCommandsEventHandler implements Listener {

	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent event) {

		Player player = event.getPlayer();

		String wholeString = event.getMessage();
		String commandName;
		if(wholeString.contains(" ")) {
			commandName = wholeString.substring(0, wholeString.indexOf(" "));
		} else {
			commandName = wholeString;
		}
		
		CommandCallEvent commandCallEvent = new CommandCallEvent(commandName, player);
		Bukkit.getServer().getPluginManager().callEvent(commandCallEvent);

		event.setCancelled(commandCallEvent.isCancelled());

	}
	
}
