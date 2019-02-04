package com.samtaber.main.utils;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtilities {

	public static void broadcast(String msg) {
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			
			player.sendMessage(starter() + msg);
			
		}
		
	}
	
	private static String starter() {
		return ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "CadiaGames" + ChatColor.LIGHT_PURPLE + "]" + ChatColor.GREEN + " ";
	}
	
}
