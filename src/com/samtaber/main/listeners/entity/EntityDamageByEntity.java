package com.samtaber.main.listeners.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Game;
import com.samtaber.main.handlers.Team;
import com.samtaber.main.listeners.MGListener;

public class EntityDamageByEntity extends MGListener {

	public EntityDamageByEntity(Heist pl) {
		super(pl);
		
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		
		if(!(event.getEntity() instanceof Player && event.getDamager() instanceof Player)) {
			
			event.setCancelled(true);
			return;
		}
		if(!Game.hasStarted()) {
			event.setCancelled(true);
			return;
		}
		Player player = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();
		
		if(Team.getTeam(player) == Team.getTeam(damager)) {
			event.setCancelled(true);
		}
	}
	
}
