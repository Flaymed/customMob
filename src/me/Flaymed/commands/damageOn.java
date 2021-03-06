package me.Flaymed.commands;

import customMobs.MobManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DamageOn implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.damage")) {
				
				//Identify Mob Variables
				Integer id = Integer.parseInt(args[0]);
				
				MobManager.setMobDamageable(id);
				player.sendMessage(MobManager.chatPrefix + " This entity can now take damage!");
					
			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
