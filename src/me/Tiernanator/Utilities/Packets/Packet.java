package me.Tiernanator.Utilities.Packets;

import net.minecraft.server.v1_14_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Packet {

	public static String getJsonColour(ChatColor chatColour) {

		return chatColour.name().toLowerCase();

	}

	public static void sendPacket(Player player,
			net.minecraft.server.v1_14_R1.Packet<?> packet) {
		PlayerConnection connection = ((CraftPlayer) player)
				.getHandle().playerConnection;
		connection.sendPacket(packet);
	}

}
