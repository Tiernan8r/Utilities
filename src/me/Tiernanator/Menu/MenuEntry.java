package me.Tiernanator.Menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Utilities.Main;
import me.Tiernanator.Utilities.Items.Item;

public class MenuEntry {
	
	private static List<MenuEntry> allMenuEntries = new ArrayList<MenuEntry>();
	
	public static List<MenuEntry> getAllMenuEntries() {
		return allMenuEntries;
	}
	
	public static MenuEntry getMenuEntry(ItemStack item) {
		
		if(item == null) {
			return null;
		}
		Material material = item.getType();
		if(material == Material.AIR) {
			return null;
		}
		
		for(MenuEntry menuEntry : getAllMenuEntries()) {
			
			ItemStack itemEntry = menuEntry.getEntryItem();
			String itemName = "";
			try {
				itemName = Item.getItemName(item);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			String entryName = Item.getItemName(itemEntry);
			try {
				if(itemEntry.equals(item) && itemName.equalsIgnoreCase(entryName)) {
					return menuEntry;
				}
			} catch (Exception e) {
				return null;
			}
			
		}
		
		return null;
	}
	
	public static void setMenuEntries(List<MenuEntry> menuEntries) {
		allMenuEntries = menuEntries;
	}
	
	public static void addMenuEntry(MenuEntry menuEntry) {
		
		List<MenuEntry> menuEntries = new ArrayList<MenuEntry>();
		menuEntries = getAllMenuEntries();
		if(menuEntries.contains(menuEntry)) {
			return;
		}
		menuEntries.add(menuEntry);
		setMenuEntries(menuEntries);
	}
	
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public static void setPlugin(Main main) {
		plugin = main;
	}
	
	private Object actionVariable;
	private MenuAction clickAction;
	private ItemStack item;
	private String entryName;
	private int entryIndex;
	
	public MenuEntry(String entryName, ItemStack entryItem, MenuAction clickAction, Object clickVariable) {
		
		this.entryName = entryName;
		this.item = entryItem;
		this.clickAction = clickAction;
		this.actionVariable = clickVariable;
		this.entryIndex = -1;
		
		if(entryName != null) {
			Item.renameItem(getEntryItem(), getEntryName());
		}

		addMenuEntry(this);
		
	}
	
	public MenuEntry(String entryName, ItemStack entryItem, MenuAction clickAction, Object clickVariable, int entryIndex) {
		
		this.entryName = entryName;
		this.item = entryItem;
		this.clickAction = clickAction;
		this.actionVariable = clickVariable;
		this.entryIndex = entryIndex;
		
		Item.renameItem(getEntryItem(), getEntryName());
		
		addMenuEntry(this);
		
	}

	public String getEntryName() {
		return this.entryName;
	}
	
	public void setEntryName(String entryName) {
		this.entryName = entryName;
		Item.renameItem(getEntryItem(), entryName);
	}
	
	public ItemStack getEntryItem() {
		return this.item;
	}
	
	public MenuAction getClickAction() {
		return this.clickAction;
	}
	
	public Object getActionVariable() {
		return this.actionVariable;
	}
	
	public int getEntryIndex() {
		return this.entryIndex;
	}
}
