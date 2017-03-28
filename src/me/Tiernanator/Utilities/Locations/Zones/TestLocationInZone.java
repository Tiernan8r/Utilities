package me.Tiernanator.Utilities.Locations.Zones;

import org.bukkit.Location;

public class TestLocationInZone {

	public static boolean ifLocationIsInZone(Location toTest, Location centre, int radius) {
		
		int centreX = centre.getBlockX();
		int centreZ = centre.getBlockZ();
		int testX = toTest.getBlockX();
		int testZ = toTest.getBlockZ();
				 
		if (testX >= (centreX + radius) || testZ >= (centreZ + radius) || testX <= (centreX - radius) || testZ <= (centreZ - radius)) {
			return false;
		}
		return true;
	}	
}

