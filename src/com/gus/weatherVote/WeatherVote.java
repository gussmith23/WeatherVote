package com.gus.weatherVote;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WeatherVote extends JavaPlugin{

	//i will explain this later.
	public VotingSession currentSession = null;
		
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		
		
		super.onCommand(sender, command, label, args);
		 
		 Player player = (Player) sender;
		 
		 //base command
		 if(command.getName().equalsIgnoreCase("bvt")){
			 
			 //you can combine both conditions which should indicate incorrect usage.
			 if(  (args.length == 0)   ||   (args.length > 1)   ){
                //if you return false wherever a command is used incorrectly, bukkit will display the
			 	//command usage that you have entered in plugin.yml. no need to make your own error messages.
			 	return false;
	         }
			
			 
			//this is the important stuff
			if(args[0].equalsIgnoreCase("start")){
				
				if(player.hasPermission("WeatherVote.start")){
					
					
					//creating a new vote; individual voting sessions are now represented by a new class.
					new VotingSession(this, player);
					
				}
				
			}
			 
			 
			 
			 
		 }
		 
		 
		 
		 return false;
	}
		
}
