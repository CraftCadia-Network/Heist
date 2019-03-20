package com.tabergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.tabergames.main.Main;
import com.tabergames.util.TeamName;

public class GameStart implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		Player player = (Player) sender;
		
		PlayerInventory i = player.getInventory();
		
		if(label.equalsIgnoreCase("heist")) {
			
      File f = new File("plugins/Heist/PlayerData/" + p.getUniqueId() + ".yml");
      YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
      
			if(args.length == 0) {
				
				player.sendMessage(ChatColor.RED + "Invalid usage. Try: /heist help for a list of commands.");
				
			}else if(args.length == 1) {
				
				String argument = args[0];
				if(argument.equalsIgnoreCase("start")) {
					
						PlayerHandler.getRank(player);
            if(yml.getString("Rank") == "security"){
            
            
            
            }
					
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
