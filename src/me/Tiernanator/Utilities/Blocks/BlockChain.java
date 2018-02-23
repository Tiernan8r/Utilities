/**
 *
 */
package me.Tiernanator.Utilities.Blocks;

import me.Tiernanator.Utilities.Materials.BuildingMaterial;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tiernan
 */
public final class BlockChain {

	public static List<Block> getBlockChain(Block origin, BlockDirection[] allowedDirections, List<Block> allBlocks) {
		return getBlockChain(origin, allowedDirections, allBlocks, 100);
	}

	@SuppressWarnings("deprecation")
	public static List<Block> getBlockChain(Block origin, BlockDirection[] allowedDirections, List<Block> allBlocks, int blockLimit) {
		BuildingMaterial chainMaterial = new BuildingMaterial(origin.getType(), origin.getData());
		return getBlockChain(origin, chainMaterial, allowedDirections, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 256, Integer.MAX_VALUE, allBlocks, blockLimit);
	}

	public static List<Block> getBlockChain(Location origin, BlockDirection[] allowedDirections, List<Block> allBlocks) {
		return getBlockChain(origin.getBlock(), allowedDirections, allBlocks);
	}

	public static List<Block> getBlockChain(Block origin, BuildingMaterial chainMaterial, BlockDirection[] allowedDirections, List<Block> allBlocks, int blockLimit) {
		return getBlockChain(origin, chainMaterial, allowedDirections, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 256, Integer.MAX_VALUE, allBlocks, blockLimit);
	}

	public static List<Block> getBlockChain(Block origin, BuildingMaterial chainMaterial, BlockDirection[] allowedDirections, List<Block> allBlocks) {
		return getBlockChain(origin, chainMaterial, allowedDirections, allBlocks, 100);
	}

	public static List<Block> getBlockChain(Location origin, BuildingMaterial chainMaterial, BlockDirection[] allowedDirections, List<Block> allBlocks) {
		return getBlockChain(origin.getBlock(), chainMaterial, allowedDirections, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 256, Integer.MAX_VALUE, allBlocks, 100);
	}

	public static List<Block> getBlockChain(Block origin, BuildingMaterial chainMaterial, BlockDirection[] allowedDirections, int lowestX, int lowestY, int lowestZ, int highestX, int highestY, int highestZ, List<Block> allBlocks, int blockLimit) {

		if (allBlocks == null) {
			allBlocks = new LinkedList<Block>();
		}

		if (origin == null || chainMaterial == null || allowedDirections == null) {
			return allBlocks;
		}

		if (!allBlocks.contains(origin)) {
			allBlocks.add(origin);
		}

		if (allBlocks.size() > blockLimit) {
			return allBlocks;
		}

		for (BlockDirection direction : allowedDirections) {

			if (direction == BlockDirection.SELF) {
				continue;
			}

			Block block = BlockDirection.getRelativeBlock(origin, direction);
			BuildingMaterial blockMaterial = BuildingMaterial.getBuildingMaterial(block);

			if (blockMaterial == null) {
				blockMaterial = new BuildingMaterial(block);
			}

			if (blockMaterial.equals(chainMaterial)) {

				Location blockLocation = block.getLocation();

				int blockX = blockLocation.getBlockX();
				int blockY = blockLocation.getBlockY();
				int blockZ = blockLocation.getBlockZ();

				if (blockX > highestX || blockX < lowestX || blockY > highestY || blockY < lowestY || blockZ > highestZ || blockZ < lowestZ) {
					continue;
				}

				if (!allBlocks.contains(block)) {
					allBlocks.add(block);
					allBlocks = getBlockChain(block, chainMaterial, allowedDirections, lowestX, lowestY, lowestZ, highestX, highestY, highestZ, allBlocks, blockLimit);
				}
			}
		}

		return allBlocks;
	}

	public static List<Block> getBlockChain(Location origin, BuildingMaterial chainMaterial, BlockDirection[] allowedDirections, int lowestX, int lowestY, int lowestZ, int highestX, int highestY, int highestZ, List<Block> allBlocks) {
		return getBlockChain(origin.getBlock(), chainMaterial, allowedDirections, lowestX, lowestY, lowestZ, highestX, highestY, highestZ, allBlocks, 100);
	}

	@SuppressWarnings("deprecation")
	public static List<Block> getBlockChain(Block origin, BlockDirection[] allowedDirections, int lowestX, int lowestY, int lowestZ, int highestX, int highestY, int highestZ, List<Block> allBlocks) {
		BuildingMaterial chainMaterial = new BuildingMaterial(origin.getType(), origin.getData());
		return getBlockChain(origin, chainMaterial, allowedDirections, lowestX, lowestY, lowestZ, highestX, highestY, highestZ, allBlocks, 100);
	}

	public static List<Block> getBlockChain(Location origin, BlockDirection[] allowedDirections, int lowestX, int lowestY, int lowestZ, int highestX, int highestY, int highestZ, List<Block> allBlocks) {
		return getBlockChain(origin.getBlock(), allowedDirections, lowestX, lowestY, lowestZ, highestX, highestY, highestZ, allBlocks);
	}

}
