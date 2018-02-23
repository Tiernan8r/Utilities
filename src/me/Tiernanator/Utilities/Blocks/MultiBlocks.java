package me.Tiernanator.Utilities.Blocks;

import org.bukkit.block.*;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Bed;
import org.bukkit.material.Door;
import org.bukkit.material.MaterialData;

public class MultiBlocks {

	public static Block getCorrectBlock(Block block) {

		BlockState blockState = block.getState();

		if (blockState instanceof Chest) {
			Chest chest = (Chest) blockState;
			InventoryHolder inventoryHolder = chest.getInventory().getHolder();
			if (inventoryHolder instanceof DoubleChest) {
				DoubleChest doubleChest = (DoubleChest) inventoryHolder;
				block = doubleChest.getLocation().getBlock();
			} else if (inventoryHolder instanceof Chest) {
				block = ((Chest) inventoryHolder).getBlock();
			}
		}

		MaterialData materialData = blockState.getData();

		if (materialData instanceof Door) {
			Door door = (Door) materialData;
			if (door.isTopHalf()) {
				block = block.getRelative(BlockFace.DOWN);
			}
		}

		if (materialData instanceof Bed) {
			Bed bed = (Bed) materialData;
			BlockFace oppositeFace = bed.getFacing().getOppositeFace();
			if (bed.isHeadOfBed()) {
				block = block.getRelative(oppositeFace);
			}
		}

		return block;
	}

}
