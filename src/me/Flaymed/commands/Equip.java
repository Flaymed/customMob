package me.Flaymed.commands;

import customMobs.MobManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class Equip implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.equip")) {
				
				//Identify Mob Variables
				Integer id = Integer.parseInt(args[0]);
				String useMaterial = args[1];
				Entity creature = MobManager.getMob(id);
				EntityEquipment equiped = ((LivingEntity) creature).getEquipment();
				
				if (useMaterial.toLowerCase() == "none") {
					equiped.setItemInHand(null);
				} else {
					Material addMaterial = Material.valueOf(useMaterial.toUpperCase());
					ItemStack item = new ItemStack(addMaterial);
					equiped.setItemInHand(item);
				}
				
				player.sendMessage(MobManager.chatPrefix + " Mob equipment updated!");
					
			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
