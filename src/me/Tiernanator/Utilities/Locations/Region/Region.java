package me.Tiernanator.Utilities.Locations.Region;

//import com.jcraft.jsch.MAC;
import me.Tiernanator.Utilities.File.DataSaver;
import me.Tiernanator.Utilities.Locations.Region.Cuboids.Cuboid;
import me.Tiernanator.Utilities.Materials.BuildingMaterial;
import me.Tiernanator.Utilities.Serialization.SerializableBlock;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Region implements Serializable {

	private static final long serialVersionUID = -8823579760399021602L;

	private static JavaPlugin plugin;

	protected int maxCycleSize = plugin.getConfig()
			.getInt("Region.MaxCycleSize");
	protected int delayBetweenCycles = plugin.getConfig()
			.getInt("Region.DelayBetweenCycles");

	public static void setPlugin(JavaPlugin pl) {
		plugin = pl;
	}

	protected List<Block> allBlocks;
	protected List<SerializableBlock> allSerializableBlocks;
	protected List<Block> allSolidBlocks;
	protected List<SerializableBlock> allSolidSerializableBlocks;

	/**
	 * Construct a Region from a Cuboid.
	 *
	 * @param cuboid
	 *            the cuboid
	 */
	public Region(Cuboid cuboid) {

		this(cuboid.allBlocks());

	}

	/**
	 * Construct a Region from a block array.
	 *
	 * @param blocks
	 *            the array
	 */
	public Region(List<Block> blocks) {

		this.allBlocks = blocks;

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				reserializeBlocks();
				calculateAllSolidBlocks();

			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	/**
	 * Construct a Region given two Location objects which represent any two
	 * corners of the Region.
	 *
	 * @param location1
	 *            one of the corners
	 * @param location2
	 *            the other corner
	 */
	public Region(Location location1, Location location2) {

		if (!location1.getWorld().equals(location2.getWorld())) {
			throw new IllegalArgumentException(
					"locations must be on the same world");
		}

		Cuboid cuboid = new Cuboid(location1, location2);

		this.allBlocks = cuboid.allBlocks();
		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				reserializeBlocks();
				calculateAllSolidBlocks();

			}
		};
		runnable.runTaskAsynchronously(plugin);
	}

	@SuppressWarnings("unchecked")
	public static Region load(JavaPlugin plugin, String folderName, String fileName) {

		DataSaver dataSaver = new DataSaver(plugin, folderName);
		List<SerializableBlock> serializedBlocks = (List<SerializableBlock>) dataSaver.read(fileName);
		return new Region(SerializableBlock.convertFromSerializableBlock(serializedBlocks));

	}

	public void reserializeBlocks() {

		this.allSerializableBlocks = SerializableBlock.convertToSerializablBlock(allBlocks());

	}

	/**
	 * Get all the Blocks in the Region.
	 *
	 * @return array of Block objects.
	 */
	public List<SerializableBlock> allSerializableBlocks() {

		if (this.allSerializableBlocks == null) {
			reserializeBlocks();
		}

		return this.allSerializableBlocks;

	}

	public List<Block> allBlocks() {
		return this.allBlocks;
	}

	/**
	 * Get all the Blocks in the Region by material
	 *
	 * @param material
	 *            the type of BuildingMaterial the blocks must have
	 * @return array of Block objects.
	 */
	public List<SerializableBlock> allSerializableBlocksByType(BuildingMaterial material) {

		return SerializableBlock.convertToSerializablBlock(allBlocksByType(material));
	}

	public List<Block> allBlocksByType(BuildingMaterial material) {
		List<Block> allBlocks = new LinkedList<>();

		for (Block b : allBlocks()) {

			BuildingMaterial blockMaterial = new BuildingMaterial(b);

			if (blockMaterial.equals(material)) {
				allBlocks.add(b);
			}
		}
		return allBlocks;
	}

	/**
	 * Get all the Blocks in the Region by material
	 *
	 * @param material
	 *            the type of material the blocks must have
	 * @return array of Block objects.
	 */
	public List<SerializableBlock> allSerializableBlocksByType(Material material) {

		return SerializableBlock.convertToSerializablBlock(allBlocksByType(material));

	}

	public List<Block> allBlocksByType(Material material) {
		List<Block> allBlocks = new LinkedList<>();

		for (Block b : allBlocks()) {
			if (b.getType().equals(material)) {
				allBlocks.add(b);
			}
		}
		return allBlocks;
	}

	private void calculateAllSolidBlocks() {

		// BukkitRunnable runnable = new BukkitRunnable() {
		//
		// @Override
		// public void run() {

		List<Block> solidBlocks = new LinkedList<>();
		for (Block block : allBlocks()) {

			if (block.getType().isSolid()) {
				solidBlocks.add(block);
			}

		}
		allSolidBlocks = solidBlocks;
		allSolidSerializableBlocks = SerializableBlock.convertToSerializablBlock(allSolidBlocks);

		// }
		// };
		// runnable.runTaskAsynchronously(plugin);

	}

	public List<Block> allSolidBlocks() {

		if (allSolidBlocks == null) {
			calculateAllSolidBlocks();
		}

		return allSolidBlocks;

	}

	public List<SerializableBlock> allSolidSerializableBlocks() {

		if (allSolidSerializableBlocks == null) {
			calculateAllSolidBlocks();
		}

		return allSolidSerializableBlocks;

	}

	/**
	 * Get the average light level of all empty (air) blocks in the Region.
	 * Returns 0 if there are no empty blocks.
	 *
	 * @return the average light level of this Region
	 */
	public byte averageLightLevel() {

		long total = 0;
		int n = 0;

		for (Block b : this.allBlocks) {

			if (b.isEmpty()) {
				total += b.getLightLevel();
				++n;
			}

		}
		return n > 0 ? (byte) (total / n) : 0;
	}

	/**
	 * Change all the solid blocks within the Region to the given
	 * BuildingMaterial.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 */
	public void changeTo(BuildingMaterial material) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				List<Block> solidBlocks = allSolidBlocks();
				set(solidBlocks, material);
			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	/**
	 * Check if the given Block is contained within this Region.
	 *
	 * @param b
	 *            the Block to check for
	 * @return true if the Block is within this Region, false otherwise
	 */
	public boolean contains(Block b) {
		return contains(b.getLocation());
	}

	/**
	 * Change all the solid blocks within the Region to the given Material.
	 *
	 * @param material the BuildingMaterial type
	 */
	@Deprecated
	public void changeTo(Material material) {

		BuildingMaterial buildingMaterial = BuildingMaterial.getBuildingMaterial(material, -1);
		changeTo(buildingMaterial);
	}

	public boolean contains(BuildingMaterial material) {

		if (allSerializableBlocks().isEmpty()) {
			return false;
		}

		for (SerializableBlock block : allSerializableBlocks()) {
			BuildingMaterial blockMaterial = block.getBuildingMaterial();
			if (blockMaterial.equals(material)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the given Location is contained within this Region.
	 *
	 * @param location the Location to check for
	 * @return true if the Location is within this Region, false otherwise
	 */
	public boolean contains(Location location) {
		return !allSerializableBlocks.isEmpty() && getWorld().equals(location.getWorld()) && contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	/**
	 * Return true if the point at (x,y,z) is contained within this Region.
	 *
	 * @param x
	 *            the X co-ordinate
	 * @param y
	 *            the Y co-ordinate
	 * @param z
	 *            the Z co-ordinate
	 * @return true if the given point is within this Region, false otherwise
	 */
	public boolean contains(int x, int y, int z) {

		if (allSerializableBlocks().isEmpty()) {
			return false;
		}

		for (Block b : this.allBlocks) {
			if (b.getX() == x && b.getY() == y && b.getZ() == z) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(Material material) {

		if (allSerializableBlocks().isEmpty() || allSerializableBlocks() == null) {
			return false;
		}
		for (SerializableBlock block : allSerializableBlocks()) {
			if (block == null) {
				continue;
			}
			if (block.getBuildingMaterial().getMaterial().equals(material)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the Region contains only blocks of the given type
	 *
	 * @param material
	 *            the material to check for
	 * @return true if this Region contains only blocks of the given type
	 */
	public boolean containsOnly(BuildingMaterial material) {
		for (Block b : this.allBlocks) {
			BuildingMaterial buildingMaterial = new BuildingMaterial(b);
			if (!buildingMaterial.equals(material)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the Blocks at the eight corners of the Region.
	 *
	 * @return array of Block objects representing the Region corners
	 */
	public Block[] corners() {

		Block[] res = new Block[8];

		World w = getWorld();

		int x1 = getLowerX();
		int y1 = getLowerY();
		int z1 = getLowerZ();

		int x2 = getUpperX();
		int y2 = getUpperY();
		int z2 = getUpperZ();

		res[0] = w.getBlockAt(x1, y1, z1);
		res[1] = w.getBlockAt(x1, y1, z2);
		res[2] = w.getBlockAt(x1, y2, z1);
		res[3] = w.getBlockAt(x1, y2, z2);
		res[4] = w.getBlockAt(x2, y1, z1);
		res[5] = w.getBlockAt(x2, y1, z2);
		res[6] = w.getBlockAt(x2, y2, z1);
		res[7] = w.getBlockAt(x2, y2, z2);

		return res;

	}

	/**
	 * Check if the Region contains only blocks of the given type
	 *
	 * @param material the material to check for
	 * @return true if this Region contains only blocks of the given type
	 */
	public boolean containsOnly(Material material) {
		for (Block b : this.allBlocks) {
			if (b.getType() != material) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Remove the liquid within the Region.
	 */
	public void drain() {

		BukkitRunnable runnable = new BukkitRunnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				List<Block> allLiquidBlocks = new LinkedList<>();

				allLiquidBlocks.addAll(allBlocksByType(Material.WATER));
				allLiquidBlocks.addAll(allBlocksByType(Material.LEGACY_STATIONARY_WATER));
				allLiquidBlocks.addAll(allBlocksByType(Material.LAVA));
				allLiquidBlocks.addAll(allBlocksByType(Material.LEGACY_STATIONARY_LAVA));

				set(allLiquidBlocks, BuildingMaterial.getBuildingMaterial("AIR"));
			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	/**
	 * Set all the blocks within the Region to the given BuildingMaterial Type.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 */
	public void fill(BuildingMaterial material) {

		set(allBlocks(), material);

	}

	// */
	// public List<Block> allSerializableBlocksByMaterial(Material material) {
	//
	// List<Block> allSerializableBlocks = new LinkedList<Block>();
	//
	// for (Block b : this.allSerializableBlocks) {
	// if(b.getBuildingMaterial().getMaterial() == material) {
	// allSerializableBlocks.add(b);
	// }
	// }
	// return allSerializableBlocks;
	//
	// }
	//
	// /**
	// * Get all the Blocks in the Region.
	// *
	// * @return array of Block objects.
	// */
	// @SuppressWarnings("deprecation")
	// public List<Block> allSerializableBlocksByMaterial(BuildingMaterial
	// material) {
	//
	// List<Block> allSerializableBlocks = new LinkedList<Block>();
	//
	// for (Block b : this.allSerializableBlocks) {
	// if(b.getBuildingMaterial().getMaterial() == material.getMaterial()) {
	// if(b.getBuildingMaterial().getDamage() == (byte) material.getDamage()) {
	// allSerializableBlocks.add(b);
	// }
	// }
	// }
	// return allSerializableBlocks;
	//
	//
	// }

	/**
	 * Set all the blocks within the Region to the given BuildingMaterial Type.
	 *
	 * @param material the BuildingMaterial type
	 */
	@Deprecated
	public void fill(Material material) {

		BuildingMaterial buildingMaterial = new BuildingMaterial(material, 0);
		fill(buildingMaterial);

	}

	/**
	 * Get the the centre of the Region
	 *
	 * @return Location at the centre of the Region
	 */
	public Location getCenter() {

		int x1 = getUpperX() + 1;
		int y1 = getUpperY() + 1;
		int z1 = getUpperZ() + 1;

		return new Location(getWorld(), getLowerX() + (x1 - getLowerX()) / 2.0, getLowerY() + (y1 - getLowerY()) / 2.0, getLowerZ() + (z1 - getLowerZ()) / 2.0);
	}

	@SuppressWarnings("unused")
	public void flip() {

		List<SerializableBlock> allSerializableBlocks = this.allSerializableBlocks();

		SerializableBlock highest = null;
		SerializableBlock lowest = null;
		for (SerializableBlock block : allSerializableBlocks) {
			// Find Highest Block
			// Find Lowest block
			if (highest == null) {
				highest = block;
				lowest = block;
				continue;
			}
			if (highest.asLocation().getBlockY() < block.asLocation().getBlockY()) {
				highest = block;
			}
			if (lowest.asLocation().getBlockY() > block.asLocation().getBlockY()) {
				lowest = block;
			}
			// block.setType(BuildingMaterial.WOOL);
		}

		HashMap<Location, Material> materialHashmap = new HashMap<Location, Material>();
		HashMap<Location, Byte> dataHashmap = new HashMap<Location, Byte>();
		for (int i = 0; i <= highest.asLocation().getBlockY() - lowest.asLocation().getBlockY(); i++) {

			for (SerializableBlock block : allSerializableBlocks) {

				if (block.asLocation().getBlockY() == lowest.asLocation().getBlockY() + i) {

					SerializableBlock target = null;
					for (SerializableBlock b : allSerializableBlocks) {
						if (b.asLocation().getBlockY() == highest.asLocation().getBlockY() - i) {
							if (b.asLocation().getBlockX() == block.asLocation().getBlockX()) {
								if (b.asLocation().getBlockZ() == block.asLocation().getBlockZ()) {
									target = b;
								}
							}
						}
					}
					if (target == null) {

						materialHashmap.put(block.asLocation(), Material.AIR);
						dataHashmap.put(block.asLocation(), (byte) 0);
						Location location = highest.asLocation().subtract(0, i, 0);
						location.setX(block.asLocation().getBlockX());
						location.setZ(block.asLocation().getBlockZ());

						materialHashmap.put(location, block.getBuildingMaterial().getMaterial());
						dataHashmap.put(location, block.getBuildingMaterial().getDamage());

						materialHashmap.put(block.asLocation(), Material.AIR);
						dataHashmap.put(block.asLocation(), (byte) 0);

					} else {
						materialHashmap.put(block.asLocation(), target.getBuildingMaterial().getMaterial());
						dataHashmap.put(block.asLocation(), target.getBuildingMaterial().getDamage());
					}
				}
			}
		}

		List<Material> flipBlocks = new LinkedList<>();
		List<Material> slabBlocks = new LinkedList<>();
		for (Material m : Material.values()) {
			if (m.name().toLowerCase().contains("stairs")) {
				flipBlocks.add(m);
			}
			if (m.name().toLowerCase().contains("step") && !m.name().toLowerCase().contains("double")) {
				slabBlocks.add(m);
			}
		}
		for (Entry<Location, Material> e : materialHashmap.entrySet()) {
			if (e.getValue() == Material.AIR) {
				e.getKey().getBlock().setType(e.getValue());
				Byte d = dataHashmap.get(e.getKey());
				int current = 0;
				if (d != null) {
					current = d.intValue();
				} else {
					System.out.println("NULL");
				}
				int data = current;
				if (flipBlocks.contains(e.getValue())) {
					if (current < 4) {
						data = current + 4;
					} else {
						data = current - 4;
					}
				}
				if (slabBlocks.contains(e.getValue())) {
					if (current < 9) {
						data = current + 8;
					} else {
						data = current - 8;
					}
				}
				//TODO find replacement
//				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(), (byte) data, true);
			}
		}
		for (Entry<Location, Material> e : materialHashmap.entrySet()) {
			if (e.getValue().isSolid() && e.getValue() != Material.AIR) {
				e.getKey().getBlock().setType(e.getValue());
				int data = 0;
				Byte d = dataHashmap.get(e.getKey());
				int current = 0;
				if (d != null) {
					current = d.intValue();
				} else {
					System.out.println("NULL");
				}
				data = current;
				if (flipBlocks.contains(e.getValue())) {
					if (current < 4) {
						data = current + 4;
					} else {
						data = current - 4;
					}
				}
				if (slabBlocks.contains(e.getValue())) {
					if (current < 9) {
						data = current + 8;
					} else {
						data = current - 8;
					}
				}
				//TODO find replacement: no longer works
//				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(), (byte) data, true);
			}
		}
		for (Entry<Location, Material> e : materialHashmap.entrySet()) {
			if (!e.getValue().isSolid() && e.getValue() != Material.AIR) {
				e.getKey().getBlock().setType(e.getValue());
				int data = 0;
				Byte d = dataHashmap.get(e.getKey());
				int current = 0;
				if (d != null) {
					current = d.intValue();
				} else {
					System.out.println("NULL");
				}
				data = current;
				if (flipBlocks.contains(e.getValue())) {
					if (current < 4) {
						data = current + 4;
					} else {
						data = current - 4;
					}
				}
				if (slabBlocks.contains(e.getValue())) {
					if (current < 9) {
						data = current + 8;
					} else {
						data = current - 8;
					}
				}
				//TODO find replceament:
//				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(), (byte) data, true);
			}
		}
	}

	/**
	 * Get a list of the chunks which are fully or partially contained in this
	 * Region.
	 *
	 * @return a list of Chunk objects
	 */
	public List<Chunk> getChunks() {
		List<Chunk> res = new LinkedList<>();

		World w = getWorld();
		int x1 = getLowerX() & ~0xf;
		int x2 = getUpperX() & ~0xf;
		int z1 = getLowerZ() & ~0xf;
		int z2 = getUpperZ() & ~0xf;
		for (int x = x1; x <= x2; x += 16) {
			for (int z = z1; z <= z2; z += 16) {
				res.add(w.getChunkAt(x >> 4, z >> 4));
			}
		}
		return res;
	}

	/**
	 * Get the minimum X co-ordinate of this Region
	 *
	 * @return the minimum X co-ordinate
	 */
	public int getLowerX() {
		return getLowerNE().getBlockX();
	}

	/**
	 * Get the minimum Y co-ordinate of this Region
	 *
	 * @return the minimum Y co-ordinate
	 */
	public int getLowerY() {
		return getLowerNE().getBlockY();
	}

	/**
	 * Get the minimum Z co-ordinate of this Region
	 *
	 * @return the minimum Z co-ordinate
	 */
	public int getLowerZ() {
		return getLowerNE().getBlockZ();
	}

	/**
	 * Get a block relative to the lower NE point of the Region in the given
	 * World. This version of getRelativeBlock() should be used if being called
	 * many times, to avoid excessive calls to getWorld().
	 *
	 * @param location
	 * @return the block at the given position
	 */
	public Block getRelativeBlock(Location location) {

		// World w = getWorld();
		// int x = location.getBlockX();
		// int y = location.getBlockY();
		// int z = location.getBlockZ();
		//
		// int x1 = getLowerX();
		// int y1 = getLowerY();
		// int z1 = getLowerZ();
		//
		// return w.getBlockAt(x1 + x, y1 + y, z1 + z);
		World w = getWorld();
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();

		int x1 = getLowerX();
		int y1 = getLowerY();
		int z1 = getLowerZ();

		return w.getBlockAt(x - x1, y - y1, z - z1);
	}

	/**
	 * Get a block relative to the lower NE point of the Region in the given
	 * World. This version of getRelativeBlock() should be used if being called
	 * many times, to avoid excessive calls to getWorld().
	 *
	 * @param world
	 *            the World
	 * @param x
	 *            the X co-ordinate
	 * @param y
	 *            the Y co-ordinate
	 * @param z
	 *            the Z co-ordinate
	 * @return the block at the given position
	 */
	public Block getRelativeBlock(World world, int x, int y, int z) {

		// int x1 = getLowerX();
		// int y1 = getLowerY();
		// int z1 = getLowerZ();
		//
		// return world.getBlockAt(x1 + x, y1 + y, z1 + z);
		int x1 = getLowerX();
		int y1 = getLowerY();
		int z1 = getLowerZ();

		return world.getBlockAt(x - x1, y - y1, z - z1);
	}

	/**
	 * Get the size of this Region along the X axis
	 *
	 * @return Size of Region along the X axis
	 */
	public int getSizeX() {
		return (getUpperX() - getLowerX()) + 1;
	}

	/**
	 * Get the size of this Region along the Y axis
	 *
	 * @return Size of Region along the Y axis
	 */
	public int getSizeY() {
		return (getUpperY() - getLowerY()) + 1;
	}

	/**
	 * Get the size of this Region along the Z axis
	 *
	 * @return Size of Region along the Z axis
	 */
	public int getSizeZ() {
		return (getUpperZ() - getLowerZ()) + 1;
	}

	/**
	 * Get the Location of the lower northeast corner of the Region (minimum XYZ
	 * co-ordinates).
	 *
	 * @return Location of the lower northeast corner
	 */
	public Location getLowerNE() {

		int x = 999999999;
		int y = 256;
		int z = 999999999;

		for (Block b : this.allBlocks) {

			if (b.getX() < x && b.getY() < y && b.getZ() < z) {
				x = b.getX();
				y = b.getY();
				z = b.getZ();
			}

		}
		return new Location(getWorld(), x, y, z);
	}

	/**
	 * Get the maximum X co-ordinate of this Region
	 *
	 * @return the maximum X co-ordinate
	 */
	public int getUpperX() {
		return getUpperSW().getBlockX();
	}

	/**
	 * Get the maximum Y co-ordinate of this Region
	 *
	 * @return the maximum Y co-ordinate
	 */
	public int getUpperY() {
		return getUpperSW().getBlockY();
	}

	/**
	 * Get the maximum Z co-ordinate of this Region
	 *
	 * @return the maximum Z co-ordinate
	 */
	public int getUpperZ() {
		return getUpperSW().getBlockZ();
	}

	/**
	 * Get the Location of the upper southwest corner of the Region (maximum XYZ
	 * co-ordinates).
	 *
	 * @return Location of the upper southwest corner
	 */
	public Location getUpperSW() {

		int x = -999999999;
		int y = 0;
		int z = -999999999;

		for (Block b : this.allBlocks) {

			if (b.getX() > x && b.getY() > y && b.getZ() > z) {
				x = b.getX();
				y = b.getY();
				z = b.getZ();
			}

		}
		return new Location(getWorld(), x, y, z);
	}

	/**
	 * Get the Region's world.
	 *
	 * @return the World object representing this Region's world.
	 */
	public World getWorld() {

		return this.allBlocks.get(0).getWorld();

	}

	public void remove(BuildingMaterial material) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				set(allBlocksByType(material), BuildingMaterial.getBuildingMaterial("AIR"));
			}

		};
		runnable.runTaskAsynchronously(plugin);

	}

	/**
	 * Remove the blocks of a certain type within the Region.
	 *
	 * @param material
	 *            The BuildingMaterial to remove
	 */
	public void remove(Material material) {

		BuildingMaterial buildingMaterial = new BuildingMaterial(material, 0);
		remove(buildingMaterial);

	}

	/**
	 * Replace the blocks of a certain type within the Region with another type.
	 *
	 * @param original
	 *            The BuildingMaterial to replace
	 * @param replacement
	 *            The replacement BuildingMaterial
	 */
	public void replace(BuildingMaterial original, BuildingMaterial replacement) {

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				set(allBlocksByType(original), replacement);
			}
		};
		runnable.runTaskAsynchronously(plugin);

	}

	@Deprecated
	public void setBiome(Biome biome) {

		World world = this.getWorld();

		for (Chunk chunk : this.getChunks()) {
			world.setBiome(chunk.getX(), chunk.getZ(), biome);
		}
	}

	/**
	 * Get the volume of this Region.
	 *
	 * @return the Region volume, in blocks
	 */
	public int volume() {
		return getSizeX() * getSizeY() * getSizeZ();
	}

	/**
	 * Replace the blocks of a certain type within the Region with another type.
	 *
	 * @param original
	 *            The BuildingMaterial to replace
	 * @param replacement
	 *            The replacement BuildingMaterial
	 */
	public void replace(Material original, Material replacement) {

		BuildingMaterial materialOriginal = new BuildingMaterial(original, 0);
		BuildingMaterial materialReplacement = new BuildingMaterial(replacement, 0);
		replace(materialOriginal, materialReplacement);
	}

	@SuppressWarnings("unused")
	private void set(List<Block> blocks, BuildingMaterial material) {

		Material type = material.getMaterial();
		byte data = material.getDamage();
		int amountOfBlocks = blocks.size();

		if (amountOfBlocks <= maxCycleSize) {

			for (Block block : blocks) {
				block.setType(type);
				//TODO find replacement
//				block.setData(data);
			}

		}

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;

			@Override
			public void run() {

				for (int i = n; i < n + maxCycleSize; i++) {

					if (i >= amountOfBlocks) {
						this.cancel();
					}

					Block block = null;
					try {
						block = blocks.get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}
					block.setType(type);
					//TODO find replacement
//					block.setData(data);
				}

				n += maxCycleSize;

				if (n > amountOfBlocks + maxCycleSize) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, delayBetweenCycles);

	}

	public void move(Region template) {

		Location baseLocation = getLowerNE();

		List<SerializableBlock> templateBlocks = template.allSerializableBlocks();
		//
		// for (SerializableBlock b : templateBlocks) {
		//
		// Location relativeBlockLocation = template
		// .getRelativeBlock(b.asLocation()).getLocation();
		//
		// double x1 = relativeBlockLocation.getX();
		// double y1 = relativeBlockLocation.getY();
		// double z1 = relativeBlockLocation.getZ();
		//
		// double x2 = baseLocation.getX();
		// double y2 = baseLocation.getY();
		// double z2 = baseLocation.getZ();
		//
		// double no1 = x2 + x1;
		// double no2 = y2 + y1;
		// double no3 = z2 + z1;
		//
		// Location rel = new Location(baseLocation.getWorld(), no1, no2, no3);
		//
		// rel.getBlock().setType(b.getBuildingMaterial().getMaterial());
		// rel.getBlock().setData(b.getBuildingMaterial().getDamage());
		//
		// }

		int amountOfBlocks = templateBlocks.size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;

			@Override
			public void run() {

				for (int i = n; i < n + maxCycleSize; i++) {

					if (i >= amountOfBlocks) {
						this.cancel();
					}

					SerializableBlock block = null;
					try {
						block = templateBlocks.get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}

					Location relativeBlockLocation = template.getRelativeBlock(block.asLocation()).getLocation();

					double x1 = relativeBlockLocation.getX();
					double y1 = relativeBlockLocation.getY();
					double z1 = relativeBlockLocation.getZ();

					double x2 = baseLocation.getX();
					double y2 = baseLocation.getY();
					double z2 = baseLocation.getZ();

					double no1 = x2 + x1;
					double no2 = y2 + y1;
					double no3 = z2 + z1;

					Location rel = new Location(baseLocation.getWorld(), no1, no2, no3);

					rel.getBlock().setType(block.getBuildingMaterial().getMaterial());
					//TODO find replacement
//					rel.getBlock().setData(block.getBuildingMaterial().getDamage());
				}

				n += maxCycleSize;

				if (n > amountOfBlocks + maxCycleSize) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, delayBetweenCycles);

	}

	public void save(JavaPlugin plugin, String folderName, String fileName) {

		// BukkitRunnable runnable = new BukkitRunnable() {
		//
		// @Override
		// public void run() {
		reserializeBlocks();
		DataSaver dataSaver = new DataSaver(plugin, folderName);
		dataSaver.write(this.allSerializableBlocks(), fileName);

		// }
		// };
		// runnable.runTaskAsynchronously(plugin);

	}

}
