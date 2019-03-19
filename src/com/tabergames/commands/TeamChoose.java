package com.tabergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.tabergames.main.Main;
import com.tabergames.util.TeamName;

public class TeamChoose implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		Player player = (Player) sender;
		
		PlayerInventory i = player.getInventory();
		
		if(label.equalsIgnoreCase("Team")) {
			
			if(args.length == 0) {
				
				player.sendMessage(ChatColor.RED + "You need to put a team name in! Try 'Security' or 'Robbers'");
				
			}else if(args.length == 1) {
				
		
				String teamName = args[0];
				if(teamName.equalsIgnoreCase("Security")) {
					
						Main.lmeta.setDisplayName(TeamName.teamSecurity);
						Main.SecurityBaton.setItemMeta(Main.lmeta);
						i.addItem(Main.SecurityBaton);
						PlayerHandler.setRank(player, TeamName.securityDepend);
						player.sendMessage(ChatColor.GREEN + "You have chosen the team color of " + ChatColor.BLUE + "Security");
					
				}else if(teamName.equalsIgnoreCase("Robbers")) {
					
					Main.lmeta.setDisplayName(TeamName.teamRobbers);
					PlayerHandler.setRank(player, TeamName.robbersDepend);
					player.sendMessage(ChatColor.GREEN + "You have chosen the team color of " + ChatColor.RED + "Robbers");
				
			}		
				
			
				
			}
			
		}
		
		return false;
	}

	
	
	
}
