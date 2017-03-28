package me.Tiernanator.Utilities.Blocks;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Bed;
import org.bukkit.material.Door;

public class MultiBlocks {

	public static Block getCorrectBlock(Block block) {

		if (block.getState() instanceof Chest) {
			Chest chest = (Chest) block.getState();
			InventoryHolder inventoryHolder = chest.getInventory().getHolder();
			if (inventoryHolder instanceof DoubleChest) {
				DoubleChest doubleChest = (DoubleChest) inventoryHolder;
				block = doubleChest.getLocation().getBlock();
			} else if(inventoryHolder instanceof Chest) {
				block = ((Chest) inventoryHolder).getBlock();
			}
		}

		if (block.getState().getData() instanceof Door) {
			Door door = (Door) block.getState().getData();
			if (door.isTopHalf()) {
				block = block.getRelative(BlockFace.DOWN);
			}
		}

		if (block.getState().getData() instanceof Bed) {
			Bed bed = (Bed) block.getState().getData();
			BlockFace oppositeFace = bed.getFacing().getOppositeFace();
			if (bed.isHeadOfBed()) {
				block = block.getRelative(oppositeFace);
			}
		}

		return block;
	}
	
}
