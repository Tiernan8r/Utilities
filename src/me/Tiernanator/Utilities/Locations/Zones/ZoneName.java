package me.Tiernanator.Utilities.Locations.Zones;

public class ZoneName {

	public static String parseNameToZoneCode(String name) {

		char[] charArray = name.toCharArray();
		for (int i = 0; i < name.length(); i++) {
			char currentChar = charArray[i];
			if (currentChar == ' ') {
				charArray[i] = '_';
			}

		}
		String newName = new String(charArray, 0, charArray.length);

		return newName;
	}

	public static String parseZoneCodeToName(String name) {

		char[] charArray = name.toCharArray();
		for (int i = 0; i < name.length(); i++) {
			char currentChar = charArray[i];
			if (currentChar == '_') {
				charArray[i] = ' ';
			}

		}
		String newName = new String(charArray, 0, charArray.length);

		return newName;
	}
}
