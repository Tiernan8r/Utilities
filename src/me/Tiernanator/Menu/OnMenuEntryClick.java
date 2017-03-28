package me.Tiernanator.Menu;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import me.Tiernanator.Menu.MenuEvents.MenuClickEvent;
import me.Tiernanator.Utilities.Main;

public class OnMenuEntryClick implements Listener {

	public OnMenuEntryClick(Main main) {
	}
	
	@EventHandler
	public void onInventoryClick(MenuClickEvent event) {

		if(event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		MenuEntry menuEntry = event.getMenuEntry();
		
		MenuAction menuAction = menuEntry.getClickAction();
		
		switch(menuAction) {
			case CLOSE :
				event.setCancelled(true);
				player.closeInventory();
				return;
			case NOTHING :
				event.setCancelled(true);
				return;
			case OPEN :
				break;
			case TELEPORT :
				break;
			case NEXT_PAGE:
				break;
			case PREVIOUS_PAGE:
				break;
			case MESSAGE:
				break;
			case IGNORE:
				return;
			default :
				event.setCancelled(true);
				return;
			
		}
		
		Object menuActionVariable = menuEntry.getActionVariable();

		if(menuActionVariable == null) {
			event.setCancelled(true);
			return;
		}
		if(menuActionVariable instanceof String && menuAction == MenuAction.MESSAGE) {
			player.sendMessage((String) menuActionVariable);
			event.setCancelled(true);
			return;
		} else if(menuActionVariable instanceof Location && menuAction == MenuAction.TELEPORT) {
			
			Location teleportLocation = (Location) menuActionVariable;
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(teleportLocation);
			return;
			
		} else if(menuActionVariable instanceof Player && menuAction == MenuAction.TELEPORT) {
			
			Player targetPlayer = (Player) menuActionVariable;
			
			Location teleportLocation = targetPlayer.getLocation();
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(teleportLocation);
			return;
			
		} else if(menuActionVariable instanceof Menu) {
			
			Menu actionMenu = (Menu) menuActionVariable;
			
			if(menuAction == MenuAction.OPEN) {
				
				event.setCancelled(true);
				player.closeInventory();
				actionMenu.makeMenu(player);
				return;
				
			} else if(menuAction == MenuAction.NEXT_PAGE) {
				
				actionMenu.incrementPageNumber();
				event.setCancelled(true);
				player.closeInventory();
				actionMenu.makeMenu(player);
				return;
				
			} else if(menuAction == MenuAction.PREVIOUS_PAGE) {
				
				actionMenu.decrementPageNumber();
				event.setCancelled(true);
				player.closeInventory();
				actionMenu.makeMenu(player);
				return;
				
			}
			
		} else if(menuActionVariable instanceof Inventory && menuAction == MenuAction.OPEN) {
			
			Inventory inventory = (Inventory) menuActionVariable;
			player.closeInventory();
			event.setCancelled(true);
			player.openInventory(inventory);
			return;
		}
		
		event.setCancelled(true);

	}

}
