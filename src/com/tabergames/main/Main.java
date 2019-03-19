package com.tabergames.main;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import com.tabergames.util.FileHandler;

import com.tabergames.commands.TeamChoose;

public class Main extends JavaPlugin{

	public static Main instance;
	public static ItemStack SecurityBaton = new ItemStack(Material.STICK);
	public static ItemMeta lmeta = SecurityBaton.getItemMeta();
	FileHandler FileHandler = new FileHandler();
	com.tabergames.events.OnJoin PlayerJoin = new com.tabergames.events.OnJoin();
	
	@Override
	public void onEnable() {
		
		instance = this;
		FileHandler.Setup();
		this.getServer().getPluginManager().registerEvents(PlayerJoin, this);
		this.getCommand("team").setExecutor((CommandExecutor)new TeamChoose());
		
	}

	@Override
	public void onDisable() {
		
		instance = null;
		
	}
	
}
