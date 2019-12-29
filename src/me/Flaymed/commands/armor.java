package me.Flaymed.commands;

import customMobs.mobManager;
//import mobManager.equip;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class armor implements CommandExecutor {
	
	String chatPrefix = ChatColor.GRAY + "[" + ChatColor.RED + "CustomMobs" + ChatColor.GRAY + "]" + ChatColor.YELLOW;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.armor")) {
				
				//Identify Mob Variables
				String name = args[0];
				String armor = args[1].toLowerCase();
				Entity creature = mobManager.getMob(name);
				EntityEquipment equiped = ((LivingEntity) creature).getEquipment();
				
				switch (armor) {
				 
				case "none":
					equiped.setArmorContents(null);
					break;
					
				case "diamond":
					ItemStack diamond_helmet = new ItemStack(Material.DIAMOND_HELMET);
					ItemStack diamond_chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
					ItemStack diamond_leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
					ItemStack diamond_boots = new ItemStack(Material.DIAMOND_BOOTS);
					
					equiped.setHelmet(diamond_helmet);
					equiped.setChestplate(diamond_chestplate);
					equiped.setLeggings(diamond_leggings);
					equiped.setBoots(diamond_boots);
					
					break;
					
				case "iron":
					ItemStack iron_helmet = new ItemStack(Material.IRON_HELMET);
					ItemStack iron_chestplate = new ItemStack(Material.IRON_CHESTPLATE);
					ItemStack iron_leggings = new ItemStack(Material.IRON_LEGGINGS);
					ItemStack iron_boots = new ItemStack(Material.IRON_BOOTS);
					
					equiped.setHelmet(iron_helmet);
					equiped.setChestplate(iron_chestplate);
					equiped.setLeggings(iron_leggings);
					equiped.setBoots(iron_boots);
					
					break;
					
				case "chain":
					ItemStack chain_helmet = new ItemStack(Material.CHAINMAIL_HELMET);
					ItemStack chain_chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
					ItemStack chain_leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
					ItemStack chain_boots = new ItemStack(Material.CHAINMAIL_BOOTS);
					
					equiped.setHelmet(chain_helmet);
					equiped.setChestplate(chain_chestplate);
					equiped.setLeggings(chain_leggings);
					equiped.setBoots(chain_boots);
					
					break;
					
				case "gold":
					ItemStack gold_helmet = new ItemStack(Material.GOLD_HELMET);
					ItemStack gold_chestplate = new ItemStack(Material.GOLD_CHESTPLATE);
					ItemStack gold_leggings = new ItemStack(Material.GOLD_LEGGINGS);
					ItemStack gold_boots = new ItemStack(Material.GOLD_BOOTS);
					
					equiped.setHelmet(gold_helmet);
					equiped.setChestplate(gold_chestplate);
					equiped.setLeggings(gold_leggings);
					equiped.setBoots(gold_boots);
					
					break;
					
				case "leather":
					ItemStack leather_helmet = new ItemStack(Material.LEATHER_HELMET);
					ItemStack leather_chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leather_leggings = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack leather_boots = new ItemStack(Material.LEATHER_BOOTS);
					
					equiped.setHelmet(leather_helmet);
					equiped.setChestplate(leather_chestplate);
					equiped.setLeggings(leather_leggings);
					equiped.setBoots(leather_boots);
					
					break;
				}
				
				player.sendMessage(chatPrefix + " Mob armor updated!");
				
					
			} else {
				player.sendMessage(chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
