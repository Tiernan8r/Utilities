package me.Tiernanator.Colours;

import org.bukkit.ChatColor;

public enum Colour {

	INFORMATIVE(ChatColor.AQUA), ALTERNATE_INFORMATIVE(
			ChatColor.DARK_PURPLE), HIGHLIGHT(
					ChatColor.LIGHT_PURPLE), ALTERNATE_HIGHLIGHT(
							ChatColor.DARK_AQUA), WARNING(
									ChatColor.DARK_RED), ALTERNATE_WARNING(
											ChatColor.RED), SEVERE(
													ChatColor.BLACK), GOOD(
															ChatColor.GREEN), ALTERNATE_GOOD(
																	ChatColor.BLUE), CAUTION(
																			ChatColor.GRAY), BAD(
																					ChatColor.DARK_PURPLE), ALTERNATE_BAD(
																							ChatColor.WHITE), REGAL(
																									ChatColor.GOLD);

	public static String parseChatColourToCode(ChatColor colour) {

		switch (colour) {
			case BLACK :
				return "&0";
			case DARK_BLUE :
				return "&1";
			case DARK_GREEN :
				return "&2";
			case DARK_AQUA :
				return "&3";
			case DARK_RED :
				return "&4";
			case DARK_PURPLE :
				return "&5";
			case GOLD :
				return "&6";
			case GRAY :
				return "&7";
			case DARK_GRAY :
				return "&8";
			case BLUE :
				return "&9";
			case GREEN :
				return "&A";
			case AQUA :
				return "&B";
			case RED :
				return "&C";
			case LIGHT_PURPLE :
				return "&D";
			case YELLOW :
				return "&E";
			case WHITE :
				return "&F";
			case MAGIC :
				return "&K";
			case BOLD :
				return "&L";
			case STRIKETHROUGH :
				return "&M";
			case UNDERLINE :
				return "&N";
			case ITALIC :
				return "&O";
			case RESET :
				return "&R";
			default :
				return null;
		}
	}

	public static ChatColor parseCodeToChatColour(String code) {

		code = code.toUpperCase();

		switch (code) {
			case "&0" :
				return ChatColor.BLACK;
			case "&1" :
				return ChatColor.DARK_BLUE;
			case "&2" :
				return ChatColor.DARK_GREEN;
			case "&3" :
				return ChatColor.DARK_AQUA;
			case "&4" :
				return ChatColor.DARK_RED;
			case "&5" :
				return ChatColor.DARK_PURPLE;
			case "&6" :
				return ChatColor.GOLD;
			case "&7" :
				return ChatColor.GRAY;
			case "&8" :
				return ChatColor.DARK_GRAY;
			case "&9" :
				return ChatColor.BLUE;
			case "&A" :
				return ChatColor.GREEN;
			case "&B" :
				return ChatColor.AQUA;
			case "&C" :
				return ChatColor.RED;
			case "&D" :
				return ChatColor.LIGHT_PURPLE;
			case "&E" :
				return ChatColor.YELLOW;
			case "&F" :
				return ChatColor.WHITE;
			case "&K" :
				return ChatColor.MAGIC;
			case "&L" :
				return ChatColor.BOLD;
			case "&M" :
				return ChatColor.STRIKETHROUGH;
			case "&N" :
				return ChatColor.UNDERLINE;
			case "&O" :
				return ChatColor.ITALIC;
			case "&R" :
				return ChatColor.RESET;
			default :
				return null;
		}
	}

	private ChatColor colour;

	private Colour(ChatColor colour) {
		this.colour = colour;
	}

	public ChatColor getColour() {
		switch (this) {
			case INFORMATIVE :
				return INFORMATIVE.colour;
			case BAD :
				return BAD.colour;
			case CAUTION :
				return CAUTION.colour;
			case GOOD :
				return GOOD.colour;
			case HIGHLIGHT :
				return HIGHLIGHT.colour;
			case REGAL :
				return REGAL.colour;
			case SEVERE :
				return SEVERE.colour;
			case WARNING :
				return WARNING.colour;
			case ALTERNATE_BAD :
				return ALTERNATE_BAD.colour;
			case ALTERNATE_GOOD :
				return ALTERNATE_GOOD.colour;
			case ALTERNATE_HIGHLIGHT :
				return ALTERNATE_HIGHLIGHT.colour;
			case ALTERNATE_INFORMATIVE :
				return ALTERNATE_INFORMATIVE.colour;
			case ALTERNATE_WARNING :
				return ALTERNATE_WARNING.colour;
			default :
				return null;
		}
	}
}
