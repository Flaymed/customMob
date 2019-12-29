package me.Flaymed.commands;

import customMobs.freeze;
import customMobs.mobManager;
//import mobManager.equip;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;

public class rename implements CommandExecutor {
	
	String chatPrefix = ChatColor.GRAY + "[" + ChatColor.RED + "CustomMobs" + ChatColor.GRAY + "]" + ChatColor.YELLOW;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.name")) {
				
				//Identify Mob Variables
				World world = player.getWorld();
				String name = args[0];
				String newName = args[1];
				Entity creature = mobManager.getMob(name);
				Location creatureLocation = mobManager.getLocation(creature);
				
				mobManager.removeMob(name, creature);
				creature.remove();
				
				if (mobManager.denyDamage.containsValue(creature)) {
					
					if (creature instanceof Zombie) {
						Zombie zombie = (Zombie) world.spawnEntity(creatureLocation, EntityType.ZOMBIE);
						zombie.setCustomName(newName);
						zombie.setCustomNameVisible(true);
						zombie.setCanPickupItems(false);
						zombie.setRemoveWhenFarAway(false);
						freeze.freezeEntity(zombie);
						mobManager.setMobUndamageable(newName, zombie);
						mobManager.addMob(newName, zombie, creatureLocation);
						
					} else if (creature instanceof Skeleton) {
						Skeleton skeleton = (Skeleton) world.spawnEntity(creatureLocation, EntityType.SKELETON);
						skeleton.setCustomName(newName);
						skeleton.setCustomNameVisible(true);
						skeleton.setCanPickupItems(false);
						skeleton.setRemoveWhenFarAway(false);
						freeze.freezeEntity(skeleton);
						mobManager.setMobUndamageable(newName, skeleton);
						mobManager.addMob(newName, skeleton, creatureLocation);
						
					} else if (creature instanceof Spider) {
						Spider spider = (Spider) world.spawnEntity(creatureLocation, EntityType.SPIDER);
						spider.setCustomName(newName);
						spider.setCustomNameVisible(true);
						spider.setCanPickupItems(false);
						spider.setRemoveWhenFarAway(false);
						freeze.freezeEntity(spider);
						mobManager.setMobUndamageable(newName, spider);
						mobManager.addMob(newName, spider, creatureLocation);
						
					} else if (creature instanceof Villager) {
						Villager villager = (Villager) world.spawnEntity(creatureLocation, EntityType.VILLAGER);
						villager.setCustomName(newName);
						villager.setCustomNameVisible(true);
						villager.setCanPickupItems(false);
						villager.setRemoveWhenFarAway(false);
						freeze.freezeEntity(villager);
						mobManager.setMobUndamageable(newName, villager);
						mobManager.addMob(newName, villager, creatureLocation);
						
					}
					
				} else {
					if (creature instanceof Zombie) {
						Zombie zombie = (Zombie) world.spawnEntity(creatureLocation, EntityType.ZOMBIE);
						zombie.setCustomName(newName);
						zombie.setCustomNameVisible(true);
						zombie.setCanPickupItems(false);
						zombie.setRemoveWhenFarAway(false);
						freeze.freezeEntity(zombie);
						mobManager.addMob(newName, zombie, creatureLocation);
						
					} else if (creature instanceof Skeleton) {
						Skeleton skeleton = (Skeleton) world.spawnEntity(creatureLocation, EntityType.SKELETON);
						skeleton.setCustomName(newName);
						skeleton.setCustomNameVisible(true);
						skeleton.setCanPickupItems(false);
						skeleton.setRemoveWhenFarAway(false);
						freeze.freezeEntity(skeleton);
						mobManager.addMob(newName, skeleton, creatureLocation);
						
					} else if (creature instanceof Spider) {
						Spider spider = (Spider) world.spawnEntity(creatureLocation, EntityType.SPIDER);
						spider.setCustomName(newName);
						spider.setCustomNameVisible(true);
						spider.setCanPickupItems(false);
						spider.setRemoveWhenFarAway(false);
						freeze.freezeEntity(spider);
						mobManager.addMob(newName, spider, creatureLocation);
						
					} else if (creature instanceof Villager) {
						Villager villager = (Villager) world.spawnEntity(creatureLocation, EntityType.VILLAGER);
						villager.setCustomName(newName);
						villager.setCustomNameVisible(true);
						villager.setCanPickupItems(false);
						villager.setRemoveWhenFarAway(false);
						freeze.freezeEntity(villager);
						mobManager.addMob(newName, villager, creatureLocation);

					}
				}
				
				player.sendMessage(chatPrefix + " Mob name updated!");
					
			} else {
				player.sendMessage(chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
