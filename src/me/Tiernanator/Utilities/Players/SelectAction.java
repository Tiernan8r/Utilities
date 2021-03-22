package me.Tiernanator.Utilities.Players;

import org.bukkit.event.block.Action;

/**
 * The class enumerator of SelectAction it serves solely to confine the type of
 * clicks down to two options, left or right
 * 
 * @author Tiernan
 *
 */
public enum SelectAction {

	LEFT_CLICK, RIGHT_CLICK, UNKNOWN;

	/**
	 * Determine the type of SelectAction a player used, based off of the
	 * {@linkplain org.bukkit.block.Action} action types
	 * 
	 * @param action
	 * @return A SelectAction of the correct type, unknown if not left or right
	 *         click.
	 */
	public static SelectAction getSelectAction(Action action) {
		// If it's not a right or left click, we don't know what it was
		if (!(action == Action.RIGHT_CLICK_BLOCK
				|| action == Action.LEFT_CLICK_BLOCK)) {
			return UNKNOWN;
		}

		// this just determines which type was used
		if (action == Action.LEFT_CLICK_BLOCK) {
			return LEFT_CLICK;
		} else {
			return RIGHT_CLICK;
		}
	}

}
