package me.Tiernanator.Utilities.Colours;

import org.bukkit.ChatColor;

/**
 * MessageColourer is a class that contains the function parseMessage, it serves
 * simply to contain this function in a relevantly named class.
 * 
 * @author Tiernan
 * 
 */

public class MessageColourer {

	/**
	 * parseMessage() if a function that takes a string containing colour code
	 * strings, and interprets them as colours, returning a coloured string as
	 * output. It uses the Class {@link me.Tiernanator.Utilities.Colours.Colour} to
	 * handle the colour codes.
	 * 
	 * @param message
	 *            the String containing colour codes to be parsed
	 * @param defaultColour
	 *            the colour of the message if no colour codes are present
	 * @return String containing relevant colouring from colour codes.
	 * @see Colour
	 */
	public static String parseMessage(String message, ChatColor defaultColour) {

		if (message == null) {
			return null;
		}
		// Convert the input string to an array of characters
		char[] messageArray = message.toCharArray();

		String parsedMessage = "";

		for (int i = 0; i < messageArray.length; i++) {

			String currentCharacter = Character.toString(messageArray[i]);

			if (currentCharacter.equals("&")) {
				if (i < messageArray.length - 2) {

					String code = currentCharacter + Character
							.toString(messageArray[i + 1]).toUpperCase();

					ChatColor colour = Colour.parseCodeToChatColour(code);

					if (colour != null) {
						parsedMessage += "§";
					}
				}
			} else {
				parsedMessage += currentCharacter;
			}
		}

		return parsedMessage;
	}

	public static String removeColours(String message) {

		if (message == null) {
			return null;
		}
		// Convert the input string to an array of characters
		char[] messageArray = message.toCharArray();

		String parsedMessage = "";

		for (int i = 0; i < messageArray.length; i++) {

			String currentCharacter = Character.toString(messageArray[i]);

			if (currentCharacter.equals("§")) {
				if (!(i + 1 > messageArray.length)) {

					String code = "&" + Character.toString(messageArray[i + 1])
							.toUpperCase();

					ChatColor colour = Colour.parseCodeToChatColour(code);

					if (colour == null) {
						parsedMessage += currentCharacter;
					} else {
						i++;
						continue;
					}
				}
			} else {
				parsedMessage += currentCharacter;
			}
		}

		return parsedMessage;
	}

}