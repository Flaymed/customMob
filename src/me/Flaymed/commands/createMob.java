package me.Flaymed.commands;

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
//import org.bukkit.potion.PotionEffect;
//import org.bukkit.potion.PotionEffectType;

public class createMob implements CommandExecutor {

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {

			if(sender.hasPermission("mobs.create")) {
				String lowercmd = args[0].toLowerCase();
				Location spawnLoc = player.getLocation();
				World world = player.getWorld();


				switch (lowercmd) {
				case "zombie":

					Zombie zombie = (Zombie) world.spawnEntity(spawnLoc, EntityType.ZOMBIE);
					//zombie.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 18000, 127));
					player.sendMessage("Zombie has been spawned!");
					return true;
					
				case "skeleton":

					Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
					player.sendMessage("Skeleton has been spawned!");
					return true;

				case "villager":

					Villager villager = (Villager) world.spawnEntity(spawnLoc, EntityType.VILLAGER);
					player.sendMessage("Villager has been spawned!");
					return true;

				case "spider":

					Spider spider = (Spider) world.spawnEntity(spawnLoc, EntityType.SPIDER);
					player.sendMessage("Spider has been spawned!");
					return true;
				}
			} else {
				player.sendMessage("&6You do not have permission to execute this command!");
			}

		}
		return true;
	}
}
