package me.Tiernanator.Utilities.Locations.Region;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import me.Tiernanator.Utilities.UtilitiesMain;

public class Shapes {

	private static UtilitiesMain plugin;
	public static List<Block> generateBowl(Location centre, int radius,
			boolean hollow) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bY = centre.getBlockY();
		int bZ = centre.getBlockZ();

		int centreY = centre.getBlockY();

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				for (int x = bX - radius; x < bX + radius; x++) {
					for (int y = bY - radius; y < bY + radius; y++) {
						for (int z = bZ - radius; z < bZ + radius; z++) {
							double diffX = bX - x;
							double diffY = bY - y;
							double diffZ = bZ - z;

							double distance = (diffX * diffX) + (diffY * diffY)
									+ (diffZ * diffZ);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);

								if (loc.getBlockY() <= centreY) {
									allBlocks.add(loc.getBlock());
								}
							}
						}
					}
				}
			}
		};
		runnable.runTaskAsynchronously(plugin);

		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int y = bY - radius; y < bY + radius; y++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffY = bY - y;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffY * diffY)
		// + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		//
		// if(loc.getBlockY() <= centreY) {
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		// }
		return allBlocks;
	}

	public static List<Block> generateCircle(Location centre, int radius,
			boolean hollow) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bZ = centre.getBlockZ();

		int y = centre.getBlockY();

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				for (int x = bX - radius; x < bX + radius; x++) {
					for (int z = bZ - radius; z < bZ + radius; z++) {
						double diffX = bX - x;
						double diffZ = bZ - z;

						double distance = (diffX * diffX) + (diffZ * diffZ);

						if (distance < (radius * radius) && !(hollow
								&& distance < ((radius - 1) * (radius - 1)))) {
							Location loc = new Location(centre.getWorld(), x, y,
									z);
							allBlocks.add(loc.getBlock());
						}
					}
				}
			}
		};
		runnable.runTaskAsynchronously(plugin);
		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		return allBlocks;
	}

	public static List<Block> generateCylinder(Location centre, int radius,
			int height, boolean hollow) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bY = centre.getBlockY();
		int bZ = centre.getBlockZ();

		int radiusHeight = height / 2;

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				for (int x = bX - radius; x < bX + radius; x++) {
					for (int y = bY - radiusHeight; y < bY
							+ radiusHeight; y++) {
						for (int z = bZ - radius; z < bZ + radius; z++) {
							double diffX = bX - x;
							double diffZ = bZ - z;

							double distance = (diffX * diffX) + (diffZ * diffZ);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);
								allBlocks.add(loc.getBlock());
							}
						}
					}
				}
			}
		};
		runnable.runTaskAsynchronously(plugin);
		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int y = bY - radiusHeight; y < bY + radiusHeight; y++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		return allBlocks;
	}

	public static List<Block> generateDome(Location centre, int radius,
			boolean hollow) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bY = centre.getBlockY();
		int bZ = centre.getBlockZ();

		int centreY = centre.getBlockY();

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				for (int x = bX - radius; x < bX + radius; x++) {
					for (int y = bY - radius; y < bY + radius; y++) {
						for (int z = bZ - radius; z < bZ + radius; z++) {
							double diffX = bX - x;
							double diffY = bY - y;
							double diffZ = bZ - z;

							double distance = (diffX * diffX) + (diffY * diffY)
									+ (diffZ * diffZ);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);

								if (loc.getBlockY() >= centreY) {
									allBlocks.add(loc.getBlock());
								}
							}
						}
					}
				}

			}
		};
		runnable.runTaskAsynchronously(plugin);

		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int y = bY - radius; y < bY + radius; y++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffY = bY - y;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffY * diffY)
		// + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		//
		// if(loc.getBlockY() >= centreY) {
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		// }
		return allBlocks;
	}

	public static List<Block> generateHorizontalCylinder(Location centre,
			int radius, int height, boolean hollow, boolean alongX) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bY = centre.getBlockY();
		int bZ = centre.getBlockZ();

		int radiusHeight = height / 2;

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				if (alongX) {
					for (int x = bX - radiusHeight; x < bX
							+ radiusHeight; x++) {
						for (int y = bY - radius; y < bY + radius; y++) {
							for (int z = bZ - radius; z < bZ + radius; z++) {
								double diffX = bX - x;
								double diffZ = bZ - z;

								double distance = (diffX * diffX)
										+ (diffZ * diffZ);

								if (distance < (radius * radius)
										&& !(hollow && distance < ((radius - 1)
												* (radius - 1)))) {
									Location loc = new Location(
											centre.getWorld(), x, y, z);
									allBlocks.add(loc.getBlock());
								}
							}
						}
					}
				} else {
					for (int x = bX - radius; x < bX + radius; x++) {
						for (int y = bY - radius; y < bY + radius; y++) {
							for (int z = bZ - radiusHeight; z < bZ
									+ radiusHeight; z++) {
								double diffX = bX - x;
								double diffZ = bZ - z;

								double distance = (diffX * diffX)
										+ (diffZ * diffZ);

								if (distance < (radius * radius)
										&& !(hollow && distance < ((radius - 1)
												* (radius - 1)))) {
									Location loc = new Location(
											centre.getWorld(), x, y, z);
									allBlocks.add(loc.getBlock());
								}
							}
						}
					}
				}

			}
		};
		runnable.runTaskAsynchronously(plugin);
		// if(alongX) {
		// for (int x = bX - radiusHeight; x < bX + radiusHeight; x++) {
		// for (int y = bY - radius; y < bY + radius; y++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		// } else {
		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int y = bY - radius; y < bY + radius; y++) {
		// for (int z = bZ - radiusHeight; z < bZ + radiusHeight; z++) {
		// double diffX = bX - x;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		// }

		return allBlocks;
	}

	public static List<Block> generateSphere(Location centre, int radius,
			boolean hollow) {

		List<Block> allBlocks = new ArrayList<Block>();
		int bX = centre.getBlockX();
		int bY = centre.getBlockY();
		int bZ = centre.getBlockZ();

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {

				for (int x = bX - radius; x < bX + radius; x++) {
					for (int y = bY - radius; y < bY + radius; y++) {
						for (int z = bZ - radius; z < bZ + radius; z++) {
							double diffX = bX - x;
							double diffY = bY - y;
							double diffZ = bZ - z;

							double distance = (diffX * diffX) + (diffY * diffY)
									+ (diffZ * diffZ);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);
								allBlocks.add(loc.getBlock());
							}
						}
					}
				}

			}
		};
		runnable.runTaskAsynchronously(plugin);

		// for (int x = bX - radius; x < bX + radius; x++) {
		// for (int y = bY - radius; y < bY + radius; y++) {
		// for (int z = bZ - radius; z < bZ + radius; z++) {
		// double diffX = bX - x;
		// double diffY = bY - y;
		// double diffZ = bZ - z;
		//
		// double distance = (diffX * diffX) + (diffY * diffY)
		// + (diffZ * diffZ);
		//
		// if (distance < (radius * radius) && !(hollow
		// && distance < ((radius - 1) * (radius - 1)))) {
		// Location loc = new Location(centre.getWorld(), x, y, z);
		// allBlocks.add(loc.getBlock());
		// }
		// }
		// }
		// }
		return allBlocks;
	}

	public static List<Block> generateVerticalCircle(Location centre,
			int radius, boolean hollow, boolean xAxis) {

		List<Block> allBlocks = new ArrayList<Block>();

		BukkitRunnable runnable = new BukkitRunnable() {

			@Override
			public void run() {
				if (xAxis) {

					// along x - axis
					int bX = centre.getBlockX();
					int bY = centre.getBlockY();

					int z = centre.getBlockZ();

					for (int x = bX - radius; x < bX + radius; x++) {
						for (int y = bY - radius; y < bY + radius; y++) {
							double diffX = bX - x;
							double diffY = bY - y;

							double distance = (diffX * diffX) + (diffY * diffY);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);
								allBlocks.add(loc.getBlock());
							}
						}
					}
				} else {
					// along z - axis
					int bZ = centre.getBlockZ();
					int bY = centre.getBlockY();

					int x = centre.getBlockX();

					for (int z = bZ - radius; z < bZ + radius; z++) {
						for (int y = bY - radius; y < bY + radius; y++) {
							double diffZ = bZ - z;
							double diffY = bY - y;

							double distance = (diffZ * diffZ) + (diffY * diffY);

							if (distance < (radius * radius)
									&& !(hollow && distance < ((radius - 1)
											* (radius - 1)))) {
								Location loc = new Location(centre.getWorld(),
										x, y, z);
								allBlocks.add(loc.getBlock());
							}
						}
					}
				}
			}
		};
		runnable.runTaskAsynchronously(plugin);

		if (xAxis) {

			// along x - axis
			int bX = centre.getBlockX();
			int bY = centre.getBlockY();

			int z = centre.getBlockZ();

			for (int x = bX - radius; x < bX + radius; x++) {
				for (int y = bY - radius; y < bY + radius; y++) {
					double diffX = bX - x;
					double diffY = bY - y;

					double distance = (diffX * diffX) + (diffY * diffY);

					if (distance < (radius * radius) && !(hollow
							&& distance < ((radius - 1) * (radius - 1)))) {
						Location loc = new Location(centre.getWorld(), x, y, z);
						allBlocks.add(loc.getBlock());
					}
				}
			}
		} else {
			// along z - axis
			int bZ = centre.getBlockZ();
			int bY = centre.getBlockY();

			int x = centre.getBlockX();

			for (int z = bZ - radius; z < bZ + radius; z++) {
				for (int y = bY - radius; y < bY + radius; y++) {
					double diffZ = bZ - z;
					double diffY = bY - y;

					double distance = (diffZ * diffZ) + (diffY * diffY);

					if (distance < (radius * radius) && !(hollow
							&& distance < ((radius - 1) * (radius - 1)))) {
						Location loc = new Location(centre.getWorld(), x, y, z);
						allBlocks.add(loc.getBlock());
					}
				}
			}
		}
		return allBlocks;
	}

	public static void setPlugin(UtilitiesMain main) {
		plugin = main;
	}

}
