package me.Tiernanator.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Utilities.Main;
import me.Tiernanator.Utilities.MetaData.MetaData;

/**
 * The Menu class is an API that allows you to easily create a GUI within Minecraft
 * Each entry within the Menu is handled by {@link me.Tiernanator.Menu.MenuEntry}.
 *  
 * @author Tiernan
 * @since 19-11-2016
 * @version 1.0
 */
public class Menu {

	private static Main plugin;

	public static void setPlugin(Main main) {
		plugin = main;
	}

	private String menuName;
	private List<MenuEntry> menuEntries;
	private int menuSize;
	private int pageNumber;
	private int totalPages;
	private boolean scrollable;
	private Inventory currentMenu;

	/**
	 * Generate a new Menu 
	 * @param menuName The name of the menu as seen by the player
	 * @param menuEntries A list of {@linkplain me.Tiernanator.Menu.MenuEntry} values representing each entry in the menu
	 */
	public Menu(String menuName, List<MenuEntry> menuEntries) {
		
		//Set the name and entries to the provided values
		this.menuName = menuName;
		this.menuEntries = menuEntries;
		//The menu defaults to 54 entries per page
		if(menuEntries.size() < 54 && !(menuEntries.size() == 0)) {
			
			this.menuSize = (int) (Math.ceil(menuEntries.size() / 9.0) * 9);
			
		} else {
			this.menuSize = 54;
		}
		
		//Start in the first page
		this.pageNumber = 1;
		
		//Calculate how many pages there are in total. if one page can't hold all the provided entries, 
		//multiple pages are required
		int numberEntries = menuEntries.size();
		//This formula calculates the number of pages
		this.totalPages = (int) Math.ceil(numberEntries / this.menuSize) + 1;
		
		int numberOfEntries = menuEntries.size();
		//The menu only needs to be multipage of there are more entries than can be displayed on 1 page
		this.scrollable = numberOfEntries > this.menuSize;

	}

	/**
	 * Generate a new Menu 
	 * @param menuName The name visible to the players
	 * @param menuEntries A list of {@linkplain me.Tiernanator.Menu.MenuEntry} values representing each entry in the menu
	 * @param menuSize An integer value, that is a factor of 9, less than 54, representing the total nu,ber of menu entries
	 */
	public Menu(String menuName, List<MenuEntry> menuEntries, int menuSize) {

		this.menuName = menuName;
		this.menuEntries = menuEntries;

		//Make sure that the menusize is a factor of 9 and less than 54
		menuSize = (int) (Math.ceil(menuSize / 9.0) * 9);
		if (menuSize > 54) {
			menuSize = 54;
		}

		this.menuSize = menuSize;
		//Start on page 1
		this.pageNumber = 1;
		
		//Determine if the menu needs to be multiple pages long
		int numberOfEntries = menuEntries.size();
		this.scrollable = numberOfEntries > menuSize;
		
	}

	/**
	 * Generate a new Menu 
	 * @param menuName The name visible to the players
	 * @param menuEntries A list of {@linkplain me.Tiernanator.Menu.MenuEntry} values representing each entry in the menu
	 * @param menuSize An integer value, that is a factor of 9, less than 54, representing the total nu,ber of menu entries
	 * @param scrollable Override whether you want to have a multi-page menu
	 */
	public Menu(String menuName, List<MenuEntry> menuEntries, int menuSize, boolean scrollable) {

		this.menuName = menuName;
		this.menuEntries = menuEntries;

		menuSize = (int) (Math.ceil(menuSize / 9.0) * 9);
		if (menuSize > 54) {
			menuSize = 54;
		}

		this.menuSize = menuSize;
		this.pageNumber = 1;
		this.scrollable = scrollable;
	}

	/**
	 * Get the name of the menu, as seen by the players
	 * @return String of menu name
	 */
	public String getMenuName() {
		return this.menuName;
	}

	/**
	 * Set the menu name to a desired string
	 * 
	 * @param newName A string representing the menu's name
	 */
	public void setMenuName(String newName) {
		this.menuName = newName;
	}

	/**
	 * Get a list of each {@linkplain me.Tiernanator.Menu.MenuEntry} in the menu
	 * 
	 * @return List<{@link me.Tiernanator.Menu.MenuEntry}> representing each menu entry
	 */
	public List<MenuEntry> getMenuEntries() {
		return this.menuEntries;
	}

	public void setMenuEntries(List<MenuEntry> menuEntries) {
		this.menuEntries = menuEntries;
	}

	public int getMenuSize() {
		return this.menuSize;
	}

	public void setMenuSize(int newSize) {
		this.menuSize = newSize;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		
		if(pageNumber < 1) {
			pageNumber = 1;
		}
		
		int totalPages = getTotalPages();
		
		if(pageNumber > totalPages) {
			pageNumber = totalPages;
		}
		
		this.pageNumber = pageNumber;
	}

	public void incrementPageNumber() {
		setPageNumber(getPageNumber() + 1);
	}
	
	public void decrementPageNumber() {
		setPageNumber(getPageNumber() - 1);
	}
	
	public int getTotalPages() {
		return this.totalPages;
	}
	
	public void setTotalPages(int numberOfPages) {
		this.totalPages = numberOfPages;
	}
	
	public boolean getScrollable() {
		return this.scrollable;
	}
	
	public void setScrollable(boolean isScrollable) { 
		this.scrollable = isScrollable;
	}

	public Inventory getCurrentMenu() {
		return this.currentMenu;
	}

	public void setCurrentMenu(Inventory menuInventory) {
		this.currentMenu = menuInventory;
	}

	public void makeMenu(Player player) {
		Inventory menu = generateMenu(player);
		player.closeInventory();
		player.openInventory(menu);
		
	}
	
	public void makeMenu(Player player, int pageNumber) {
		setPageNumber(pageNumber);
		makeMenu(player);
	}
	
	public Inventory generateMenu(Player player) {
		
		String menuName = getMenuName();
		List<MenuEntry> menuEntries = getMenuEntries();

		int numberEntries = menuEntries.size();

		int inventorySize = getMenuSize();
		Inventory inventory = Bukkit.createInventory(null, inventorySize,
				menuName);

		int pageNumber = getPageNumber();

		int menuSize = getMenuSize();
		int startIndex = 0;
		boolean scrollable = getScrollable();

		List<MenuEntry> extraEntries = new ArrayList<MenuEntry>();

		if (scrollable) {
			
			menuSize -= 9;
			int totalPages = (int) Math.ceil(numberEntries / menuSize) + 1;

			ItemStack redstoneTorch = new ItemStack(Material.REDSTONE_TORCH_ON);
			String torchName = ChatColor.AQUA + "Page " + pageNumber
							+ "/" + totalPages;
			MenuEntry torchEntry = new MenuEntry(torchName, redstoneTorch, MenuAction.NOTHING, null, 4);
			
			ItemStack stoneButton = new ItemStack(Material.STONE_BUTTON);
			String stoneName = ChatColor.GREEN + "Next Page";
			MenuEntry stoneButtonEntry = new MenuEntry(stoneName, stoneButton, MenuAction.NEXT_PAGE, this, 5);
			
			ItemStack woodButton = new ItemStack(Material.WOOD_BUTTON);
			String woodName = ChatColor.RED + "Previous Page";
			MenuEntry woodButtonEntry = new MenuEntry(woodName, woodButton, MenuAction.PREVIOUS_PAGE, this, 3);
			
			ItemStack barrier = new ItemStack(Material.BARRIER);
			String barrierName = ChatColor.RED + "Close";
			MenuEntry barrierEntry = new MenuEntry(barrierName, barrier, MenuAction.CLOSE, null, 0);

			extraEntries.add(woodButtonEntry);
			extraEntries.add(torchEntry);
			extraEntries.add(stoneButtonEntry);
			extraEntries.add(barrierEntry);
			
			startIndex = 9;
			
		}
		
		int entryNumber = (pageNumber - 1) * menuSize;
		
		int entriesPerPage = menuSize;
		int totalPages = (int) Math.ceil(numberEntries / menuSize) + 1;
		setTotalPages(totalPages);
		
		if (pageNumber > totalPages) {
			pageNumber = totalPages;
		}
		if(pageNumber < 0) {
			pageNumber = 1;
		}

		int numberOfExtraEntries = extraEntries.size();
		
		Logger logger = plugin.getLogger();
		logger.log(Level.INFO, "Generating a menu of size: " + getMenuSize() + " for " + player.getName() + ", given " + menuEntries.size() + " entries.");
		logger.log(Level.INFO, "With " + entriesPerPage + " entries per page");
		logger.log(Level.INFO, "Is scrollable: " + scrollable);
		
		logger.log(Level.INFO, "Start entry is: " + entryNumber);
		logger.log(Level.INFO, "End entry is: " + (entryNumber + entriesPerPage));
		logger.log(Level.INFO, "There are " + numberOfExtraEntries + " pre-defined entries");
		
		for (int i = entryNumber; i < entryNumber + entriesPerPage; i++) {

			try {
				menuEntries.get(i);
			} catch (Exception e) {
				continue;
			}
			MenuEntry menuEntry = menuEntries.get(i);

			ItemStack item = menuEntry.getEntryItem();
			
			int entryIndex = menuEntry.getEntryIndex();
			if(entryIndex < 0) {
				entryIndex = i + startIndex - entryNumber;
			}
			logger.log(Level.INFO, "Placing item " + item.getType().name() + ":" + item.getDurability() + " @ slot " + Integer.toString(entryIndex) + " action: " + menuEntry.getClickAction().name());

			inventory.setItem(entryIndex, item);
		}
		for(MenuEntry m : extraEntries) {
			logger.log(Level.INFO, "Pre-defined entry " + m.getEntryItem().getType().name() + ":" + m.getEntryItem().getDurability() + " called " + m.getEntryName() + " is assigned @ " + m.getEntryIndex());
			inventory.setItem(m.getEntryIndex(), m.getEntryItem());
		}
		
		MetaData.setMetadata(player, "Menu", this, plugin);
		setCurrentMenu(inventory);
		setPageNumber(pageNumber);
		
		return inventory;
		
	}
	
	public Inventory generateMenu(Player player, int pageNumber) {
		setPageNumber(pageNumber);
		return generateMenu(player);
	}
	
}
