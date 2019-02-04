package com.samtaber.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.main.listeners.player.AsyncPlayerPreLogin;
import com.samtaber.main.listeners.player.PlayerDeath;
import com.samtaber.main.listeners.player.PlayerJoin;
import com.samtaber.main.listeners.player.PlayerQuit;
import com.samtaber.main.threads.StartCountdown;

public class Heist extends JavaPlugin{
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		
		System.out.println(strings.get(0));
	}
	
	public void onEnable() {
		GameState.setState(GameState.IN_LOBBY);
		new Thread(new StartCountdown()).start();
	}

	public void registerListeners() {
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
		pm.registerEvents(new AsyncPlayerPreLogin(this), this);
		pm.registerEvents(new PlayerDeath(this), this);
	}
	
	public static boolean canStart() {
		
		return false;
	}
	
}
