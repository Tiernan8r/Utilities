package me.Tiernanator.Utilities.Packets.Titler;

import me.Tiernanator.Utilities.Packets.Packet;
import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerTitler implements Listener {

	public static void playerTitle(Player player, String phrase, boolean isBold,
			boolean isItalic, boolean isUnderLine, ChatColor chatColour,
			int fadeInTicks, int stayTicks, int fadeOutTicks,
			TitleAction title) {

		String bold = Boolean.toString(isBold);

		String italic = Boolean.toString(isItalic);

		String underline = Boolean.toString(isUnderLine);

		String colour = Packet.getJsonColour(chatColour);

		String start = "{\"text\":\"";
		String end = "\",\"color\":\"" + colour + "\",\"bold\":" + bold
				+ ",\"italic\":" + italic + ",\"underlined\":" + underline
				+ "}";

		IChatBaseComponent chatSerialized = IChatBaseComponent.ChatSerializer
				.a(start + phrase + end);

		PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(
				title.getAction(), chatSerialized, fadeInTicks, stayTicks,
				fadeOutTicks);

		Packet.sendPacket(player, packetTitle);

	}

}
