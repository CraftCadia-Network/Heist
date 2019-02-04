package com.samtaber.main.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Team;
import com.samtaber.main.listeners.MGListener;

public class PlayerDeath extends MGListener {

	public PlayerDeath(Heist pl) {
		super(pl);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		Team.getTeam(player).remove(player);
		
		player.kickPlayer(ChatColor.YELLOW + "" + ChatColor.BOLD + "!!" + ChatColor.GRAY + "You died, but stay around for the end!");
	}
	
}
