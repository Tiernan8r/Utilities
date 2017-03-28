package me.Tiernanator.Packets.Titler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.Tiernanator.Packets.Packet;
import me.Tiernanator.Utilities.Main;
import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle.EnumTitleAction;

public class PlayerTitler implements Listener {

	public PlayerTitler(Main main) {
	}

	public static void playerTitle(Player player, String phrase, boolean isBold,
			boolean isItalic, boolean isUnderLine, ChatColor chatColour,
			int fadeInTicks, int stayTicks, int fadeOutTicks,
			EnumTitleAction title) {

		String bold = Boolean.toString(isBold);

		String italic = Boolean.toString(isItalic);

		String underline = Boolean.toString(isUnderLine);

		String colour = Packet.getJsonColour(chatColour);

		String start = "{\"text\":\"";
		String end = "\",\"color\":\"" + colour + "\",\"bold\":" + bold
				+ ",\"italic\":" + italic + ",\"underlined\":" + underline
				+ "}";

		IChatBaseComponent chatSerialized = ChatSerializer
				.a(start + phrase + end);

		PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(title,
				chatSerialized, fadeInTicks, stayTicks, fadeOutTicks);

		Packet.sendPacket(player, packetTitle);
		
	}

}
