package me.Tiernanator.Utilities.Packets.Titler;

import net.minecraft.server.v1_14_R1.PacketPlayOutTitle.EnumTitleAction;

public enum TitleAction {

	ACTIONBAR(EnumTitleAction.ACTIONBAR), CLEAR(EnumTitleAction.CLEAR), RESET(EnumTitleAction.RESET), SUBTITLE(EnumTitleAction.SUBTITLE), TIMES(EnumTitleAction.TIMES), TITLE(EnumTitleAction.TITLE);

	private EnumTitleAction titleAction;

	TitleAction(EnumTitleAction titleAction) {
		this.titleAction = titleAction;
	}

	public EnumTitleAction getAction() {
		return this.titleAction;
	}

}
