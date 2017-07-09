package me.Tiernanator.Packets.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.Tiernanator.Packets.Packet;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;

public class ClickableChat {

	@SuppressWarnings("unused")
	public static void clickChat(Player player, String text1, String url,
			ChatColor chatColour, String text2) {

		String colour = Packet.getJsonColour(chatColour);

		PacketPlayOutChat clickableChat = new PacketPlayOutChat(
				ChatSerializer.a("{\"text\":\"" + text1
						+ "\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\""
						+ url
						+ "\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\""
						+ text2 + "\",\"color\":\"" + colour + "\"}]}}}"));

		// player.set

		// Packet.sendPacket(player, clickableChat);
	}

}

//
// {"text":"text1", "color":"colour",
// "clickEvent":
// {"action":"open_url","value":"url"},
// "hoverEvent":
// {"action":"show_text",
// "value":
// {"text":"",
// "extra":
// [{"text":"text2",
// "color":"colour"}]}}}
