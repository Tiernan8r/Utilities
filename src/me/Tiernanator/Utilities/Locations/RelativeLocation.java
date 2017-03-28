package me.Tiernanator.Utilities.Locations;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RelativeLocation {

	public static double roundToHalf(double d) {
	    return Math.round(d * 2) / 2.0;
	}

	public static Location getRelativeLocationsFromString(Player player,
			String stringX, String stringY, String stringZ) {

		//check if the x, y & z coords given are numbers and not letters 
		String testX = "";
		if (stringX.equalsIgnoreCase("~")) {
			testX = "0";
		} else {
			testX = stringX.replace('~', ' ');
		}
		try {
			Double.parseDouble(testX);
		} catch (Exception e) {
			return null;
		}
		//try for y 
		String testY = "";
		if (stringY.equalsIgnoreCase("~")) {
			testY = "0";
		} else {
			testY = stringY.replace('~', ' ');
		}
		try {
			Double.parseDouble(testY);
		} catch (Exception e) {
			return null;
		}
		//try for z
		String testZ = "";
		if (stringZ.equalsIgnoreCase("~")) {
			testZ = "0";
		} else {
			testZ = stringZ.replace('~', ' ');
		}
		try {
			Double.parseDouble(testZ);
		} catch (Exception e) {
			return null;
		}
		//get the players exact location
		Location playerLocation = player.getLocation();
		int playerX = playerLocation.getBlockX();
		int playerY = playerLocation.getBlockY();
		int playerZ = playerLocation.getBlockZ();
		
		double x;
		if (stringX.contains("~")) {
			if (stringX.equals("~")) {
				x = 0;
			} else {
				String temp = stringX.replace("~", "");
				x = Double.parseDouble(temp);
			}
			x += playerX;
			x = roundToHalf(x);
		} else {
			x = Double.parseDouble(stringX);
		}
		
		double y;
		if (stringY.contains("~")) {
			if (stringY.equals("~")) {
				y = 0;
			} else {
				String temp = stringY.replace("~", "");
				y = Double.parseDouble(temp);
			}
			y += playerY;
			y = roundToHalf(playerY);
		} else {
			y = Double.parseDouble(stringY);
		}
		
		double z;
		if (stringZ.contains("~")) {
			if (stringZ.equals("~")) {
				z = 0;
			} else {
				String temp = stringZ.replace("~", "");
				z = Double.parseDouble(temp);
			}
			z += playerZ;
			z = roundToHalf(playerZ);

		} else {
			z = Double.parseDouble(stringZ);
		}
		
		x = Math.floor(x);
		y = Math.floor(y);
		z = Math.floor(z);
		
		Location relativeLocation = new Location(player.getWorld(), x, y, z);
		
		relativeLocation.add(0.5, 0, 0.5);
		
		return relativeLocation;
	}
}
