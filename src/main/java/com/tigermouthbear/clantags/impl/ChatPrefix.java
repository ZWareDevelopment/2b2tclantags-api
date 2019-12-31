package com.tigermouthbear.clantags.impl;

import com.tigermouthbear.clantags.data.ClanMember;
import com.tigermouthbear.clantags.utils.ChatUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/***
 * @author Tigermouthbear
 * 12/30/19
 */

public class ChatPrefix
{
	public ChatPrefix()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent()
	public void onChatMessage(ClientChatReceivedEvent event)
	{
		if(!event.getMessage().getUnformattedText().startsWith("<")) return;
		String username = event.getMessage().getUnformattedText().split("<")[1].split(">")[0];
		ClanMember clanMember = ClanMember.getClanMemberByUsername(username);

		if(clanMember != null) event.setMessage(ChatUtils.getInteractiveClanTag(clanMember).appendSibling(event.getMessage()));
	}
}
