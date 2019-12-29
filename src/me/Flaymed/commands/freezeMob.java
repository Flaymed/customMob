package me.Flaymed.commands;

import customMobs.mobManager;
import customMobs.freeze;
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
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.EntityEquipment;

public class freezeMob implements CommandExecutor {
	
	String chatPrefix = ChatColor.GRAY + "[" + ChatColor.RED + "CustomMobs" + ChatColor.GRAY + "]" + ChatColor.YELLOW;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.freeze")) {
				
				//Identify Mob Variables
				World world = player.getWorld();
				String name = args[0];
				Entity creature = mobManager.getMob(name);
				Location creatureLocation = creature.getLocation();
				EntityEquipment equiped = ((LivingEntity) creature).getEquipment();
				
				mobManager.removeMob(name, creature);
				creature.remove();
				
				if (creature instanceof Zombie) {
					Zombie zombie = (Zombie) world.spawnEntity(creatureLocation, EntityType.ZOMBIE);
					EntityEquipment zombieEquiped = ((LivingEntity) zombie).getEquipment();
					zombieEquiped.setBoots(equiped.getBoots());
					zombieEquiped.setLeggings(equiped.getLeggings());
					zombieEquiped.setChestplate(equiped.getChestplate());
					zombieEquiped.setHelmet(equiped.getHelmet());
					zombie.setCustomName(name);
					zombie.setCustomNameVisible(true);
					zombie.setCanPickupItems(false);
					zombie.setRemoveWhenFarAway(false);
					freeze.freezeEntity(zombie);
					mobManager.addMob(name, zombie, creatureLocation);
					if (mobManager.denyDamage.containsValue(creature)) {
						mobManager.setMobUndamageable(name, zombie);
					}
					
				} else if (creature instanceof Skeleton) {
					Skeleton skeleton = (Skeleton) world.spawnEntity(creatureLocation, EntityType.SKELETON);
					EntityEquipment skeletonEquiped = ((LivingEntity) skeleton).getEquipment();
					skeletonEquiped.setBoots(equiped.getBoots());
					skeletonEquiped.setLeggings(equiped.getLeggings());
					skeletonEquiped.setChestplate(equiped.getChestplate());
					skeletonEquiped.setHelmet(equiped.getHelmet());
					skeleton.setCustomName(name);
					skeleton.setCustomNameVisible(true);
					skeleton.setCanPickupItems(false);
					skeleton.setRemoveWhenFarAway(false);
					freeze.freezeEntity(skeleton);
					mobManager.addMob(name, skeleton, creatureLocation);
					if (mobManager.denyDamage.containsValue(creature)) {
						mobManager.setMobUndamageable(name, skeleton);
					}
					
				} else if (creature instanceof Spider) {
					Spider spider = (Spider) world.spawnEntity(creatureLocation, EntityType.SPIDER);
					spider.setCustomName(name);
					spider.setCustomNameVisible(true);
					spider.setCanPickupItems(false);
					spider.setRemoveWhenFarAway(false);
					freeze.freezeEntity(spider);
					mobManager.addMob(name, spider, creatureLocation);
					if (mobManager.denyDamage.containsValue(creature)) {
						mobManager.setMobUndamageable(name, spider);
					}
					
				} else if (creature instanceof Villager) {
					Villager villager = (Villager) world.spawnEntity(creatureLocation, EntityType.VILLAGER);
					villager.setCustomName(name);
					villager.setCustomNameVisible(true);
					villager.setCanPickupItems(false);
					villager.setRemoveWhenFarAway(false);
					freeze.freezeEntity(villager);
					mobManager.addMob(name, villager, creatureLocation);
					if (mobManager.denyDamage.containsValue(creature)) {
						mobManager.setMobUndamageable(name, villager);
					}

				}
				
				player.sendMessage(chatPrefix + " Entity unfrozen!");
					
			} else {
				player.sendMessage(chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
