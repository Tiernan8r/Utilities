package me.Tiernanator.Packets;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.PlayerConnection;

public class Packet {

	public static String getJsonColour(ChatColor chatColour) {

		return chatColour.name().toLowerCase();

	}

	public static void sendPacket(Player player,
			net.minecraft.server.v1_12_R1.Packet<?> packet) {
		PlayerConnection connection = ((CraftPlayer) player)
				.getHandle().playerConnection;
		connection.sendPacket(packet);
	}

}
