package me.Tiernanator.Utilities.Locations.Region.Cuboids;

import java.util.Iterator;

import org.bukkit.World;
import org.bukkit.block.Block;

public class CuboidIterator implements Iterator<Block> {
	
	private World w;
	private int baseX, baseY, baseZ;
	private int x, y, z;
	private int sizeX, sizeY, sizeZ;

	public CuboidIterator(World w, int x1, int y1, int z1, int x2, int y2, int z2) {
		
		this.w = w;
		baseX = x1;
		baseY = y1;
		baseZ = z1;
		sizeX = Math.abs(x2 - x1) + 1;
		sizeY = Math.abs(y2 - y1) + 1;
		sizeZ = Math.abs(z2 - z1) + 1;
		x = y = z = 0;
		
	}

	public boolean hasNext() {
		return x < sizeX && y < sizeY && z < sizeZ;
	}

	public Block next() {
		
		Block b = w.getBlockAt(baseX + x, baseY + y, baseZ + z);
		if (++x >= sizeX) {
			x = 0;
			if (++y >= sizeY) {
				y = 0;
				++z;
			}
		}
		return b;
	}

}