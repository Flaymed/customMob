package me.Flaymed.commands;

import customMobs.mobManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class damageOn implements CommandExecutor {
	
	String chatPrefix = ChatColor.GRAY + "[" + ChatColor.RED + "CustomMobs" + ChatColor.GRAY + "]" + ChatColor.YELLOW;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.damage")) {
				
				//Identify Mob Variables
				String name = args[0];
				
				mobManager.setMobDamageable(name);
				player.sendMessage(chatPrefix + " This entity can now take damage!");
					
			} else {
				player.sendMessage(chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
