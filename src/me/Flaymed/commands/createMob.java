package me.Flaymed.commands;

import customMobs.freeze;
import customMobs.mobManager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;

public class createMob implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, 	Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {

			if(sender.hasPermission("mob.create")) {
				String lowercmd = args[0].toLowerCase();
				String mobName = args[1];
				Location spawnLoc = player.getLocation();
				World world = player.getWorld();

				if(mobName == null) {
					player.sendMessage("Proper usage: /createMob <MobType> <Name>");
				}


				switch (lowercmd) {
				case "zombie":
 
					Zombie zombie = (Zombie) world.spawnEntity(spawnLoc, EntityType.ZOMBIE);
					zombie.setCustomName(mobName);
					zombie.setCustomNameVisible(true);
					zombie.setCanPickupItems(false);
					zombie.setRemoveWhenFarAway(false);
					freeze.freezeEntity(zombie);
					mobManager.addMob(mobName, zombie, spawnLoc);
					mobManager.setMobUndamageable(mobName, zombie);
					player.sendMessage("Zombie has been spawned!");
					return true;

				case "skeleton":

					Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
					freeze.freezeEntity(skeleton);
					skeleton.setCustomName(mobName);
					skeleton.setCustomNameVisible(true);
					skeleton.setCanPickupItems(false);
					skeleton.setRemoveWhenFarAway(false);
					mobManager.addMob(mobName, skeleton, spawnLoc);
					mobManager.setMobUndamageable(mobName, skeleton);
					player.sendMessage("Skeleton has been spawned!");
					return true;

				case "villager":

					Villager villager = (Villager) world.spawnEntity(spawnLoc, EntityType.VILLAGER);
					villager.setCustomName(mobName);
					villager.setCustomNameVisible(true);
					villager.setCanPickupItems(false);
					villager.setRemoveWhenFarAway(false);
					freeze.freezeEntity(villager);
					mobManager.addMob(mobName, villager, spawnLoc);
					mobManager.setMobUndamageable(mobName, villager);
					player.sendMessage("Villager has been spawned!");
					return true;

				case "spider":

					Spider spider = (Spider) world.spawnEntity(spawnLoc, EntityType.SPIDER);
					spider.setCustomName(mobName);
					spider.setCustomNameVisible(true);
					spider.setCanPickupItems(false);
					spider.setRemoveWhenFarAway(false);
					freeze.freezeEntity(spider);
					mobManager.addMob(mobName, spider, spawnLoc);
					mobManager.setMobUndamageable(mobName, spider);
					player.sendMessage("Spider has been spawned!");
					return true;
				}
			} else {
				player.sendMessage("You do not have permission to execute this command!");
			}

		}
		return true;
	}
}
