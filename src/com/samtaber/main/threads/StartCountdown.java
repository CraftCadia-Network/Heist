package com.samtaber.main.threads;

import org.bukkit.Bukkit;

import com.samtaber.main.GameState;
import com.samtaber.main.Heist;
import com.samtaber.main.handlers.Game;
import com.samtaber.main.utils.ChatUtilities;

public class StartCountdown implements Runnable{

	private static int timeUntilStart;
	
	public void run() {
		timeUntilStart = 60;
		while (true) {
			if(GameState.isState(GameState.IN_LOBBY))
				if(Game.canStart()) {
				timeUntilStart = 60;
				ChatUtilities.broadcast("Minimum players reached! Game starting soon...");
				for(; timeUntilStart >= 0; timeUntilStart--) {
					if(!Game.canStart()) {
						ChatUtilities.broadcast("Not enough players needed to start. Countdown reset!");
						break;
					}
					if(timeUntilStart == 0) {
						Game.start();
						break;
				}
				
				if(timeUntilStart % 10 == 0 || timeUntilStart < 10) {
					ChatUtilities.broadcast("Game starts in " + timeUntilStart + "seconds!");
					
				}
				
				try {			
					Thread.sleep(1000);
					
				}catch (InterruptedException e) {
					e.printStackTrace();
					Bukkit.shutdown();
					}
				}
			}
			try {			
				Thread.sleep(1000);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
				Bukkit.shutdown();
			}
		}
	}
	
}
