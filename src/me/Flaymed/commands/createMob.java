package me.Flaymed.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;

public class createMob implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {
			
			String lowercmd = cmd.getName().toLowerCase();
			Location spawnLoc = player.getLocation();
			World world = player.getWorld();
			
			
			switch (lowercmd) {
			case "zombie":
				
				Zombie zombie = (Zombie) world.spawnEntity(spawnLoc, EntityType.ZOMBIE);	
				player.sendMessage("Zombie has been spawned!");
				return true;
				
			case "skeleton":
				
				Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
				player.sendMessage("Skeleton has been spawned!");
				return true;
			}
			
		}
		return true;
	}
}
