package me.Flaymed.commands;

import customMobs.MobManager;

import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetEntityId implements CommandExecutor {
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.list")) {
				
				String message = "\n";
				
				Iterator<?> mobsIterator = MobManager.mobs.entrySet().iterator();
				
				while (mobsIterator.hasNext()) {
					Map.Entry mapElement = (Map.Entry)mobsIterator.next();
					message = message + mapElement.getKey() + " " + mapElement.getValue() + " | " + MobManager.mobNames.get(mapElement.getKey()) + "\n";
				}
				
				player.sendMessage(MobManager.chatPrefix + message);
					
			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
