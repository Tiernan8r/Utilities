package me.Tiernanator.Utilities.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

//This class simply renames an item to the name provided
public class ItemUtility {

	public static ItemStack addLore(ItemStack item, String lore) {

		List<String> currentLore = getLore(item);
		currentLore.add(lore);
		return setLore(item, currentLore);

	}

	public static String getItemName(ItemStack item) {
		ItemMeta itemMeta = item.getItemMeta();

		if (!itemMeta.hasDisplayName()) {
			return null;
		}
		return itemMeta.getDisplayName();

	}

	public static List<String> getLore(ItemStack item) {

		if (!hasLore(item)) {
			return new ArrayList<String>();
		}

		// Get the lore from the itemMeta
		ItemMeta itemMeta = item.getItemMeta();
		List<String> lore;
		lore = itemMeta.getLore();
		return lore;

	}

	public static boolean hasLore(ItemStack item) {

		if (item == null) {
			return false;
		}

		// Check if the itemMeta has lore
		ItemMeta itemMeta = item.getItemMeta();
		return itemMeta.hasLore();

	}

	public static ItemStack renameItem(ItemStack item, String name) {
		// meta is metadata about the item
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		// once you change the metadata you always have to re-apply it to the
		// item
		item.setItemMeta(meta);
		return item;
	}

	// This one creates an item of given material and name
	public static ItemStack renameItem(Material item, String name) {
		// piggy backs off of previous function
		return renameItem(new ItemStack(item), name);
	}

	public static ItemStack setLore(ItemStack item, List<String> lore) {

		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		return item;

	}

}
