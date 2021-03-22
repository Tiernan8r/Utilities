package me.Tiernanator.Utilities.Menu;

import me.Tiernanator.Utilities.Items.ItemUtility;
import me.Tiernanator.Utilities.UtilitiesMain;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuEntry {

	private static List<MenuEntry> allMenuEntries = new ArrayList<MenuEntry>();

	@SuppressWarnings("unused")
	private static UtilitiesMain plugin;

	private Object actionVariable;

	public static List<MenuEntry> getAllMenuEntries() {
		return allMenuEntries;
	}

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

		if (entryName != null) {
			ItemUtility.renameItem(getEntryItem(), getEntryName());
		}

		addMenuEntry(this);

	}

	public MenuEntry(String entryName, ItemStack entryItem, MenuAction clickAction, Object clickVariable, int entryIndex) {

		this.entryName = entryName;
		this.item = entryItem;
		this.clickAction = clickAction;
		this.actionVariable = clickVariable;
		this.entryIndex = entryIndex;

		ItemUtility.renameItem(getEntryItem(), getEntryName());

		addMenuEntry(this);

	}

	public static void addMenuEntry(MenuEntry menuEntry) {

		List<MenuEntry> menuEntries = new LinkedList<>();
		menuEntries = getAllMenuEntries();
		if (menuEntries.contains(menuEntry)) {
			return;
		}
		menuEntries.add(menuEntry);
		setMenuEntries(menuEntries);
	}

	public static void setMenuEntries(List<MenuEntry> menuEntries) {
		allMenuEntries = menuEntries;
	}

	public static void setPlugin(UtilitiesMain main) {
		plugin = main;
	}

	public static MenuEntry getMenuEntry(ItemStack item) {

		if (item == null) {
			return null;
		}
		Material material = item.getType();
		if (material == Material.AIR) {
			return null;
		}

		for (MenuEntry menuEntry : getAllMenuEntries()) {

			ItemStack itemEntry = menuEntry.getEntryItem();
			String itemName = "";
			try {
				itemName = ItemUtility.getItemName(item);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			String entryName = ItemUtility.getItemName(itemEntry);
			try {
				if (itemEntry.equals(item)
						&& itemName.equalsIgnoreCase(entryName)) {
					return menuEntry;
				}
			} catch (Exception e) {
				return null;
			}

		}

		return null;
	}

	public Object getActionVariable() {
		return this.actionVariable;
	}

	public MenuAction getClickAction() {
		return this.clickAction;
	}

	public int getEntryIndex() {
		return this.entryIndex;
	}

	public ItemStack getEntryItem() {
		return this.item;
	}

	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
		ItemUtility.renameItem(getEntryItem(), entryName);
	}
}
