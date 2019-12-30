package me.Flaymed.commands;

import customMobs.MobManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Rename implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.name")) {
				
				//Identify Mob Variables
				Integer id = Integer.parseInt(args[0]);
				String newName = args[1];
				Entity creature = MobManager.getMob(id);

				MobManager.updateName(id, newName);
				creature.setCustomName(newName);
				
				player.sendMessage(MobManager.chatPrefix + " Mob name updated!");
					
			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
