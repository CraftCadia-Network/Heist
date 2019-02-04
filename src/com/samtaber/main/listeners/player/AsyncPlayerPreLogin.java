package com.samtaber.main.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Game;
import com.samtaber.main.listeners.MGListener;



public class AsyncPlayerPreLogin extends MGListener{

	public AsyncPlayerPreLogin(Heist pl) {
		super(pl);
	}

	@EventHandler
	public void playerPreLogin(AsyncPlayerPreLoginEvent event) {
		
		if(Game.hasStarted())
			event.disallow(Result.KICK_OTHER, ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "CadiaGames" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.GREEN + "The game has already started!");
		
	}
	
}
