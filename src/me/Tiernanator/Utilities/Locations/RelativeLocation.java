package me.Tiernanator.Utilities.Locations;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RelativeLocation {

	public static Location getRelativeLocationsFromString(Player player, String stringX, String stringY, String stringZ) {

		String[] stringCoords = new String[]{stringX, stringY, stringZ};

		Location location = player.getLocation();
		double x = location.getX();
		double y = location.getY();
		double z = location.getZ();
		double[] coordinates = new double[]{x, y, z};

		for (int i = 0; i < stringCoords.length; i++) {
			String stringCoord = stringCoords[i];
			if (stringCoord.contains("~")) {
				stringCoord = stringCoord.replace("~", "0");
				coordinates[i] += Double.parseDouble(stringCoord);
			} else {
				coordinates[i] = Double.parseDouble(stringCoord);
			}
		}

		x = coordinates[0];
		y = coordinates[1];
		z = coordinates[2];

		return new Location(location.getWorld(), x, y, z);
	}

	public static double roundToHalf(double d) {
		return Math.round(d * 2) / 2.0;
	}
}
