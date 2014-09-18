package com.gus.weatherVote;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class VotingSession {
	
	//the length of the vote, in seconds, which is defined in the config.
	int voteLength;

	//an object representing the plugin itself
	final WeatherVote plugin;
	
	public VotingSession(WeatherVote weatherVote, Player player){
		
		plugin = weatherVote;
		
		//if there isn't a current voting session (indicated by currentSession being null)
		if(plugin.currentSession == null){
			
			//this is where the voting session is actually defined.
			
			voteLength = 1;//but other than 1, it is actually some value attained from the config.
				
			//setting the plugin object's current session to this specific session.
			plugin.currentSession = this;
			
			//informing players they can vote...
			plugin.getServer().broadcastMessage("Voting has begun! You may vote on the weather now.");
			
			//then, begin a new thread, that will shut the vote down after a time delay.
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				 
			    public void run() {
			        plugin.currentSession.endVote();
			    }
			}, (voteLength*20)/*times 20 because there are 20 ticks per second.*/);
			
			
			
		}else player.sendMessage("Voting already in progress!");
		
		
	}
	
	
	public void endVote(){
		
		//set the plugin's current session back to null.
		plugin.currentSession = null;
		
		//this is where you'd calculate the results and change the weather accordingly; you can do that yourself though.
		
	}
	
}
