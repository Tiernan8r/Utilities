package me.Tiernanator.Utilities.Locations.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.Materials.BuildingMaterial;
import me.Tiernanator.Utilities.Locations.Region.Cuboids.Cuboid;

public class Region {

	private static JavaPlugin plugin;

	public static void setPlugin(JavaPlugin pl) {
		plugin = pl;
	}
	protected int maxCycleSize = plugin.getConfig().getInt("Region.MaxCycleSize");

	protected final List<Block> allBlocks;

	/**
	 * Construct a Region from a Cuboid.
	 *
	 * @param cuboid
	 *            the cuboid
	 */
	public Region(Cuboid cuboid) {

		this.allBlocks = cuboid.allBlocks();

	}

	/**
	 * Construct a Region from a block array.
	 *
	 * @param blocks
	 *            the array
	 */
	public Region(List<Block> blocks) {

		this.allBlocks = blocks;

	}

	/**
	 * Construct a Region given two Location objects which represent any two
	 * corners of the Region.
	 *
	 * @param l1
	 *            one of the corners
	 * @param l2
	 *            the other corner
	 */
	public Region(Location location1, Location location2) {

		if (!location1.getWorld().equals(location2.getWorld())) {
			throw new IllegalArgumentException(
					"locations must be on the same world");
		}

		Cuboid cuboid = new Cuboid(location1, location2);

		this.allBlocks = cuboid.allBlocks();

	}

	/**
	 * Get all the Blocks in the Region.
	 *
	 * @return array of Block objects.
	 */
	public List<Block> allBlocks() {

		// List<Block> allBlocks = new ArrayList<Block>();
		//
		// for (Block b : this.allBlocks) {
		// allBlocks.add(b);
		// }
		return this.allBlocks;

	}

	/**
	 * Get all the Blocks in the Region by material
	 *
	 * @param material
	 *            the type of BuildingMaterial the blocks must have
	 * @return array of Block objects.
	 */
	@SuppressWarnings("deprecation")
	public List<Block> allBlocksByType(BuildingMaterial material) {

		List<Block> allBlocks = new ArrayList<Block>();

		for (Block b : this.allBlocks) {
			if (b.getType().equals(material.getMaterial())
					&& b.getData() == material.getDamage()) {
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
	public List<Block> allBlocksByType(Material material) {

		List<Block> allBlocks = new ArrayList<Block>();

		for (Block b : this.allBlocks) {
			if (b.getType().equals(material)) {
				allBlocks.add(b);
			}
		}
		return allBlocks;

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
	 * @param damage
	 *            The damage value of the block
	 */
	@SuppressWarnings("deprecation")
	public void changeTo(BuildingMaterial material) {

		Material type = material.getMaterial();
		byte data = material.getDamage();

		int amount = allBlocks().size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;
			int blocksPerIteration = (int) Math.ceil(amount / 20) + 1;

			@Override
			public void run() {

				if (amount < maxCycleSize) {
					blocksPerIteration = maxCycleSize;
				}

				for (int i = n; i < n + blocksPerIteration; i++) {

					if (i >= amount) {
						this.cancel();
					}

					Block block = null;
					try {
						block = allBlocks().get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}
					if (block.getType() != Material.AIR) {
						block.setType(type);
						block.setData(data);
					}
				}
				n += blocksPerIteration;

				if (n > amount) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, 20);

	}

	/**
	 * Change all the solid blocks within the Region to the given Material.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 * @param damage
	 *            The damage value of the block
	 */
	@Deprecated
	public void changeTo(Material material) {

		int amount = allBlocks().size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;
			int blocksPerIteration = (int) Math.ceil(amount / 20) + 1;

			@Override
			public void run() {

				if (amount < maxCycleSize) {
					blocksPerIteration = maxCycleSize;
				}

				for (int i = n; i < n + blocksPerIteration; i++) {

					if (i >= amount) {
						this.cancel();
					}

					Block block = null;
					try {
						block = allBlocks().get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}
					if (block.getType() != Material.AIR) {
						block.setType(material);
					}
				}
				n += blocksPerIteration;

				if (n > amount) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, 20);
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

	@SuppressWarnings("deprecation")
	public boolean contains(BuildingMaterial material) {

		if (allBlocks().isEmpty()) {
			return false;
		}

		for (Block block : allBlocks()) {
			if (block.getType().equals(material.getMaterial())) {
				if (block.getData() == material.getDamage()) {
					return true;
				}
			}
		}
		return false;
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

		if (allBlocks().isEmpty()) {
			return false;
		}

		for (Block b : this.allBlocks) {
			if (b.getX() == x && b.getY() == y && b.getZ() == z) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the given Location is contained within this Region.
	 *
	 * @param location
	 *            the Location to check for
	 * @return true if the Location is within this Region, false otherwise
	 */
	public boolean contains(Location location) {
		if (allBlocks().isEmpty()) {
			return false;
		}

		return getWorld().equals(location.getWorld())
				&& contains(location.getBlockX(), location.getBlockY(),
						location.getBlockZ());
	}

	public boolean contains(Material material) {

		if (allBlocks().isEmpty() || allBlocks() == null) {
			return false;
		}
		for (Block block : allBlocks()) {
			if (block == null) {
				continue;
			}
			if (block.getType().equals(material)) {
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
	@SuppressWarnings("deprecation")
	public boolean containsOnly(BuildingMaterial material) {
		for (Block b : this.allBlocks) {
			if (b.getType() != material.getMaterial()) {
				return false;
			} else {
				if (b.getData() != material.getDamage()) {
					return false;
					// } else {
					// return true;
				}
			}
		}
		return true;
	}

	/**
	 * Check if the Region contains only blocks of the given type
	 *
	 * @param material
	 *            the material to check for
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
	 * Remove the liquid within the Region.
	 */
	public void drain() {

		List<Block> allLiquidBlocks = new ArrayList<Block>();

		allLiquidBlocks.addAll(allBlocksByType(Material.WATER));
		allLiquidBlocks.addAll(allBlocksByType(Material.STATIONARY_WATER));
		allLiquidBlocks.addAll(allBlocksByType(Material.LAVA));
		allLiquidBlocks.addAll(allBlocksByType(Material.STATIONARY_LAVA));

		for (Block block : allLiquidBlocks) {
			if (block.getType() == Material.AIR) {
				continue;
			}
			block.setType(Material.AIR);
		}

	}

	/**
	 * Set all the blocks within the Region to the given BuildingMaterial Type.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 */
	@SuppressWarnings("deprecation")
	public void fill(BuildingMaterial material) {

		Material type = material.getMaterial();
		byte data = material.getDamage();

		int amount = allBlocks().size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;
			int blocksPerIteration = (int) Math.ceil(amount / 20) + 1;

			@Override
			public void run() {

				if (amount < maxCycleSize) {
					blocksPerIteration = maxCycleSize;
				}

				for (int i = n; i < n + blocksPerIteration; i++) {

					if (i >= amount) {
						this.cancel();
					}

					Block block = null;
					try {
						block = allBlocks().get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}
					block.setType(type);
					block.setData(data);
				}
				n += blocksPerIteration;

				if (n > amount) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, 20);

	}

	/**
	 * Set all the blocks within the Region to the given BuildingMaterial Type.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 */
	@Deprecated
	public void fill(Material material) {

		int amount = allBlocks().size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;
			int blocksPerIteration = (int) Math.ceil(amount / 20) + 1;

			@Override
			public void run() {

				if (amount < maxCycleSize) {
					blocksPerIteration = maxCycleSize;
				}

				for (int i = n; i < n + blocksPerIteration; i++) {

					if (i >= amount) {
						this.cancel();
					}

					Block block = null;
					try {
						block = allBlocks().get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}
					block.setType(material);
				}
				n += blocksPerIteration;

				if (n > amount) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, 20);

	}

	// /**
	// * Get all the Blocks in the Region.
	// *
	// * @return array of Block objects.
	// */
	// public List<Block> allBlocksByMaterial(Material material) {
	//
	// List<Block> allBlocks = new ArrayList<Block>();
	//
	// for (Block b : this.allBlocks) {
	// if(b.getType() == material) {
	// allBlocks.add(b);
	// }
	// }
	// return allBlocks;
	//
	// }
	//
	// /**
	// * Get all the Blocks in the Region.
	// *
	// * @return array of Block objects.
	// */
	// @SuppressWarnings("deprecation")
	// public List<Block> allBlocksByMaterial(BuildingMaterial material) {
	//
	// List<Block> allBlocks = new ArrayList<Block>();
	//
	// for (Block b : this.allBlocks) {
	// if(b.getType() == material.getMaterial()) {
	// if(b.getData() == (byte) material.getDamage()) {
	// allBlocks.add(b);
	// }
	// }
	// }
	// return allBlocks;
	//
	//
	// }

	@SuppressWarnings("deprecation")
	public void flip() {

		List<Block> allBlocks = this.allBlocks();

		Block highest = null;
		Block lowest = null;
		for (Block block : allBlocks) {
			// Find Highest Block
			// Find Lowest block
			if (highest == null || lowest == null) {
				highest = block;
				lowest = block;
				continue;
			}
			if (highest.getLocation().getBlockY() < block.getLocation()
					.getBlockY()) {
				highest = block;
			}
			if (lowest.getLocation().getBlockY() > block.getLocation()
					.getBlockY()) {
				lowest = block;
			}
			// block.setType(BuildingMaterial.WOOL);
		}

		HashMap<Location, Material> materialHashmap = new HashMap<Location, Material>();
		HashMap<Location, Byte> dataHashmap = new HashMap<Location, Byte>();
		for (int i = 0; i <= highest.getLocation().getBlockY()
				- lowest.getLocation().getBlockY(); i++) {

			for (Block block : allBlocks) {

				if (block.getLocation()
						.getBlockY() == lowest.getLocation().getBlockY() + i) {

					Block target = null;
					for (Block b : allBlocks) {
						if (b.getLocation().getBlockY() == highest.getLocation()
								.getBlockY() - i) {
							if (b.getLocation().getBlockX() == block
									.getLocation().getBlockX()) {
								if (b.getLocation().getBlockZ() == block
										.getLocation().getBlockZ()) {
									target = b;
								}
							}
						}
					}
					if (target == null) {

						materialHashmap.put(block.getLocation(), Material.AIR);
						dataHashmap.put(block.getLocation(), (byte) 0);
						Location location = highest.getLocation().subtract(0, i,
								0);
						location.setX(block.getLocation().getBlockX());
						location.setZ(block.getLocation().getBlockZ());

						materialHashmap.put(location, block.getType());
						dataHashmap.put(location, block.getData());

						materialHashmap.put(block.getLocation(), Material.AIR);
						dataHashmap.put(block.getLocation(), (byte) 0);

					} else {
						materialHashmap.put(block.getLocation(),
								target.getType());
						dataHashmap.put(block.getLocation(), target.getData());
					}
				}
			}
		}

		List<Material> flipBlocks = new ArrayList<Material>();
		List<Material> slabBlocks = new ArrayList<Material>();
		for (Material m : Material.values()) {
			if (m.name().toLowerCase().contains("stairs")) {
				flipBlocks.add(m);
			}
			if (m.name().toLowerCase().contains("step")
					&& !m.name().toLowerCase().contains("double")) {
				slabBlocks.add(m);
			}
		}
		for (Entry<Location, Material> e : materialHashmap.entrySet()) {
			if (e.getValue() == Material.AIR) {
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
				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(),
						(byte) data, true);
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
				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(),
						(byte) data, true);
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
				e.getKey().getBlock().setTypeIdAndData(e.getValue().getId(),
						(byte) data, true);
			}
		}
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

		return new Location(getWorld(), getLowerX() + (x1 - getLowerX()) / 2.0,
				getLowerY() + (y1 - getLowerY()) / 2.0,
				getLowerZ() + (z1 - getLowerZ()) / 2.0);
	}

	/**
	 * Get a list of the chunks which are fully or partially contained in this
	 * Region.
	 *
	 * @return a list of Chunk objects
	 */
	public List<Chunk> getChunks() {
		List<Chunk> res = new ArrayList<Chunk>();

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
	 * @param w
	 *            the World
	 * @param x
	 *            the X co-ordinate
	 * @param y
	 *            the Y co-ordinate
	 * @param z
	 *            the Z co-ordinate
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
	 * @param w
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
	 * Get the Region's world.
	 *
	 * @return the World object representing this Region's world.
	 */
	public World getWorld() {

		World world = this.allBlocks.get(0).getWorld();
		return world;

	}

	/**
	 * Change all the solid blocks within the Region to the given
	 * BuildingMaterial Type, instantly.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 * @param damage
	 *            The damage value of the block
	 */
	@SuppressWarnings("deprecation")
	public void instantChangeTo(BuildingMaterial material) {

		Material type = material.getMaterial();

		for (Block block : allBlocks()) {
			if (block.getType() != Material.AIR) {
				if (block.getType() != type) {
					block.setType(type);
					block.setData(material.getDamage());
				}
			}
		}

	}

	/**
	 * Set all the blocks within the Region to the given BuildingMaterial Type,
	 * instantly.
	 *
	 * @param material
	 *            the BuildingMaterial type
	 */
	@SuppressWarnings("deprecation")
	public void instantFill(BuildingMaterial material) {

		Material type = material.getMaterial();
		byte data = material.getDamage();

		for (Block block : allBlocks()) {
			block.setType(type);
			block.setData(data);
		}

	}

	/**
	 * Replace the blocks of a certain type within the Region with another type,
	 * instantly.
	 *
	 * @param original
	 *            The BuildingMaterial to replace
	 * @param replacement
	 *            The replacement BuildingMaterial
	 */
	@SuppressWarnings("deprecation")
	public void instantReplace(BuildingMaterial original,
			BuildingMaterial replacement) {

		for (Block block : this.allBlocks) {
			if (block.getType() == original.getMaterial()) {

				if (block.getData() == (byte) 99) {
					block.setType(replacement.getMaterial());
					block.setData(replacement.getDamage());
				}
				if (block.getData() == original.getDamage()) {
					block.setType(replacement.getMaterial());
					block.setData(replacement.getDamage());
				}
			}
		}
	}

	/**
	 * Replace the blocks of a certain type within the Region with another type,
	 * instantly.
	 *
	 * @param original
	 *            The Material to replace
	 * @param replacement
	 *            The replacement Material
	 */
	@Deprecated
	public void instantReplace(Material original, Material replacement) {

		for (Block block : this.allBlocks) {
			if (block.getType().equals(original)) {
				block.setType(replacement);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void remove(BuildingMaterial material) {

		for (Block block : this.allBlocks) {
			if (block.getType() == material.getMaterial()
					&& block.getData() == material.getDamage()) {
				block.setType(Material.AIR);
			}
		}
	}

	/**
	 * Remove the blocks of a certain type within the Region.
	 *
	 * @param material
	 *            The BuildingMaterial to remove
	 * @param damage
	 *            The damage value of the block
	 */
	public void remove(Material material) {

		for (Block block : this.allBlocks) {
			if (block.getType().equals(material)) {
				block.setType(Material.AIR);
			}
		}
	}

	/**
	 * Replace the blocks of a certain type within the Region with another type.
	 *
	 * @param original
	 *            The BuildingMaterial to replace
	 * @param replacement
	 *            The replacement BuildingMaterial
	 */
	@SuppressWarnings("deprecation")
	public void replace(BuildingMaterial original,
			BuildingMaterial replacement) {

		Material originalType = original.getMaterial();
		byte originalData = original.getDamage();

		Material replacementType = replacement.getMaterial();
		byte replacementData = replacement.getDamage();

		int amount = allBlocks().size();

		BukkitRunnable runnable = new BukkitRunnable() {

			int n = 0;
			int blocksPerIteration = (int) Math.ceil(amount / 20) + 1;

			@Override
			public void run() {

				if (amount < maxCycleSize) {
					blocksPerIteration = maxCycleSize;
				}

				for (int i = n; i < n + blocksPerIteration; i++) {

					if (i >= amount) {
						this.cancel();
					}

					Block block = null;
					try {
						block = allBlocks().get(i);
					} catch (Exception e) {
						continue;
					}
					if (block == null) {
						continue;
					}

					if (block.getType() == originalType) {
						if (block.getData() == originalData) {

							block.setType(replacementType);
							block.setData(replacementData);

						}
					}
				}
				n += blocksPerIteration;

				if (n > amount) {
					this.cancel();
				}

			}
		};
		runnable.runTaskTimer(plugin, 0, 20);
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

}
