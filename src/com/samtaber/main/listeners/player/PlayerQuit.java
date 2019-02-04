package com.samtaber.main.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import com.samtaber.main.GameState;
import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Game;
import com.samtaber.main.handlers.Team;
import com.samtaber.main.listeners.MGListener;

public class PlayerQuit extends MGListener{

	public PlayerQuit(Heist pl) {
		super(pl);
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		
		if(GameState.isState(GameState.IN_LOBBY)) 
			Game.setCanStart(Bukkit.getOnlinePlayers().size() -1 >= 8);
			
		
		Player player = event.getPlayer();
		
		if(Game.hasStarted())
			Team.getTeam(player).remove(player);
		
		
	}

	
	
}
