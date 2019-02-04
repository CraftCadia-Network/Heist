package com.samtaber.main.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.samtaber.main.utils.LocationUtilities;

public class Game {

	private static boolean canStart = false;
	private static boolean hasStarted = false;
	
	public static void start() {
		hasStarted = true;
		new Team("Robbers", new Location(Bukkit.getWorld("world"), 20, 64, 20));
		new Team("Security", new Location(Bukkit.getWorld("world"), 40, 64, 20));
		
		int i = 0;
		for (Player player : Bukkit.getOnlinePlayers()) {
			if(i > Team.getAllTeams().size())
				i = 0;
			Team.getAllTeams().get(i).add(player);
			LocationUtilities.teleportToGame(player, Team.getAllTeams().get(i));
			i++;
		}
		
	}
	
	public static void stop() {
		hasStarted = false;
	}
	
	public static boolean canStart() {
		
		return canStart;
	}
	
	public static boolean hasStarted() {
		
		return hasStarted;
		
	}
	
	
	public static void setCanStart(boolean b) {
		canStart = b;
	}
	
}
