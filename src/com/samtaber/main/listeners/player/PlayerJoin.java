package com.samtaber.main.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Game;
import com.samtaber.main.listeners.MGListener;
import com.samtaber.main.utils.LocationUtilities;

public class PlayerJoin extends MGListener{

	public PlayerJoin(Heist pl) {
		super(pl);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Game.setCanStart(Bukkit.getOnlinePlayers().size() >= 8);
		LocationUtilities.teleportToSpawn(event.getPlayer());
	}
	
}
