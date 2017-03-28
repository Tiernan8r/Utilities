package me.Tiernanator.Utilities.Blocks;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public enum BlockDirection {

	DOWN, DOWN_NORTH, DOWN_NORTH_EAST,
	// DOWN_NORTH_NORTH_EAST,
	// DOWN_NORTH_NORTH_WEST,
	DOWN_NORTH_WEST, DOWN_EAST,
	// DOWN_EAST_NORTH_EAST,
	// DOWN_EAST_SOUTH_EAST,
	DOWN_SOUTH, DOWN_SOUTH_EAST,
	// DOWN_SOUTH_SOUTH_EAST,
	// DOWN_SOUTH_SOUTH_WEST,
	DOWN_SOUTH_WEST, DOWN_WEST,
	// DOWN_WEST_NORTH_WEST,
	// DOWN_WEST_SOUTH_WEST,

	UP, UP_NORTH, UP_NORTH_EAST,
	// UP_NORTH_NORTH_EAST,
	// UP_NORTH_NORTH_WEST,
	UP_NORTH_WEST, UP_EAST,
	// UP_EAST_NORTH_EAST,
	// UP_EAST_SOUTH_EAST,
	UP_SOUTH, UP_SOUTH_EAST,
	// UP_SOUTH_SOUTH_EAST,
	// UP_SOUTH_SOUTH_WEST,
	UP_SOUTH_WEST, UP_WEST,
	// UP_WEST_NORTH_WEST,
	// UP_WEST_SOUTH_WEST,

	EAST,
	// EAST_NORTH_EAST,
	// EAST_SOUTH_EAST,

	NORTH, NORTH_EAST,
	// NORTH_NORTH_EAST,
	// NORTH_NORTH_WEST,
	NORTH_WEST,

	SOUTH, SOUTH_EAST,
	// SOUTH_SOUTH_EAST,
	// SOUTH_SOUTH_WEST,
	SOUTH_WEST,

	WEST;
	// WEST_NORTH_WEST,
	// WEST_SOUTH_WEST;

	public static Block getRelativeBlock(Block block,
			BlockDirection direction) {

		switch (direction) {
			case DOWN :
				block = block.getRelative(BlockFace.DOWN);
				break;
			case DOWN_EAST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.EAST);
				break;
			case DOWN_NORTH :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.NORTH);
				break;
			case DOWN_NORTH_EAST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.NORTH_EAST);
				break;
			case DOWN_NORTH_WEST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.NORTH_WEST);
				break;
			case DOWN_SOUTH :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.SOUTH);
				break;
			case DOWN_SOUTH_EAST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.SOUTH_EAST);
				break;
			case DOWN_SOUTH_WEST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.SOUTH_WEST);
				break;
			case DOWN_WEST :
				block = block.getRelative(BlockFace.DOWN);
				block = block.getRelative(BlockFace.WEST);
				break;
			case EAST :
				block = block.getRelative(BlockFace.EAST);
				break;
			case NORTH :
				block = block.getRelative(BlockFace.NORTH);
				break;
			case NORTH_EAST :
				block = block.getRelative(BlockFace.NORTH_EAST);
				break;
			case NORTH_WEST :
				block = block.getRelative(BlockFace.NORTH_WEST);
				break;
			case SOUTH :
				block = block.getRelative(BlockFace.SOUTH);
				break;
			case SOUTH_EAST :
				block = block.getRelative(BlockFace.SOUTH_EAST);
				break;
			case SOUTH_WEST :
				block = block.getRelative(BlockFace.SOUTH_WEST);
				break;
			case UP :
				block = block.getRelative(BlockFace.UP);
				break;
			case UP_EAST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.EAST);
				break;
			case UP_NORTH :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.NORTH);
				break;
			case UP_NORTH_EAST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.NORTH_EAST);
				break;
			case UP_NORTH_WEST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.NORTH_WEST);
				break;
			case UP_SOUTH :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.SOUTH);
				break;
			case UP_SOUTH_EAST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.SOUTH_EAST);
				break;
			case UP_SOUTH_WEST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.SOUTH_WEST);
				break;
			case UP_WEST :
				block = block.getRelative(BlockFace.UP);
				block = block.getRelative(BlockFace.WEST);
				break;
			case WEST :
				block = block.getRelative(BlockFace.WEST);
				break;
			default :
				break;

		}
		return block;
	}

	public static BlockDirection getCardinalBlockDirection(float yaw) {

		// 0 & -360 = pos z
		// 90 & -270 = neg x
		// 180 & -180 = neg z
		// 270 & -90 = pos x

		if (yaw < 0) {
			yaw += 360f;
		}

		if (yaw >= -45 && yaw < 45) {
			yaw = 0;
		} else if (yaw >= 45 && yaw < 135) {
			yaw = 90;
		} else if (yaw >= 135 && yaw < 225) {
			yaw = 180;
		} else if (yaw >= 225 && yaw < 315) {
			yaw = 270;
		} else if (yaw >= 315 && yaw < 360) {
			yaw = 0;
		}

		if (yaw == 0) {
			return BlockDirection.SOUTH;
		} else if (yaw == 90) {
			return BlockDirection.WEST;
		} else if (yaw == 180) {
			return BlockDirection.NORTH;
		} else if (yaw == 270) {
			return BlockDirection.EAST;
		}
		return null;

	}

	public static BlockDirection getBlockDirection(float yaw, float pitch) {

		// Pitch = vertical :
		// from 90 - 45 = Down
		// From 45 - -45 = Level
		// From -45 - -90 = UP
		String yDirection = "";
		if (pitch > 90) {
			pitch = 90;
		} else if (pitch < -90) {
			pitch = -90;
		}
		if (pitch <= 90 && pitch > 30) {
			yDirection = "DOWN";
			// } else if(pitch < 45 && pitch > -45) {
			// yDirection = "";
		} else if (pitch < -30 && pitch >= -90) {
			yDirection = "UP";
		}

		// 0 & -360 = pos z
		// 90 & -270 = neg x
		// 180 & -180 = neg z
		// 270 & -90 = pos x
		String xDirection = "";

		if (yaw < 0) {
			yaw += 360f;
		}

		if (yaw >= -45 && yaw < 0) {
			yaw = 0;
		} else if (yaw >= 0 && yaw < 45) {
			yaw = 45;
		} else if (yaw >= 45 && yaw < 90) {
			yaw = 90;
		} else if (yaw >= 90 && yaw < 135) {
			yaw = 135;
		} else if (yaw >= 135 && yaw < 180) {
			yaw = 180;
		} else if (yaw >= 180 && yaw < 225) {
			yaw = 225;
		} else if (yaw >= 225 && yaw < 270) {
			yaw = 270;
		} else if (yaw >= 270 && yaw < 315) {
			yaw = 315;
		} else if (yaw >= 315 && yaw < 360) {
			yaw = 360;
		}

		if (yaw == 0) {
			xDirection = "SOUTH";
		} else if(yaw == 45) {
			xDirection = "SOUTH_WEST";
		} else if (yaw == 90) {
			xDirection = "WEST";
		}else if(yaw == 135) {
			xDirection = "NORTH_WEST";
		} else if (yaw == 180) {
			xDirection = "NORTH";
		} else if(yaw == 225) {
			xDirection = "NORTH_EAST";
		} else if (yaw == 270) {
			xDirection = "EAST";
		} else if(yaw == 315) {
			xDirection = "SOUTH_EAST";
		} else {
			xDirection = "SOUTH";
		}

		String direction = "";
		if (yDirection.equalsIgnoreCase("")) {
			direction = xDirection;
		} else {
			direction = yDirection + "_" + xDirection;
		}
		BlockDirection blockDirection = valueOf(direction);
		return blockDirection;
	}

	public static BlockDirection getFacingDirection(Player player) {

		Location playerLocation = player.getLocation();
		float yaw = playerLocation.getYaw();
		float pitch = playerLocation.getPitch();
		return getBlockDirection(yaw, pitch);

	}

}
