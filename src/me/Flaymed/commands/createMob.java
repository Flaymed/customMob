package me.Flaymed.commands;

import customMobs.MobManager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class CreateMob implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, 	Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {

			if(sender.hasPermission("mob.create")) {
				
				@SuppressWarnings("deprecation")
				EntityType mobType = EntityType.fromName(args[0].toUpperCase());
				String mobName = args[1];
				Location spawnLoc = player.getLocation();
				World world = player.getWorld();

				Entity entity = (Entity) world.spawnEntity(spawnLoc, mobType);
				entity.setCustomName(mobName);
				entity.setCustomNameVisible(true);
				((LivingEntity) entity).setCanPickupItems(false);
				((LivingEntity) entity).setRemoveWhenFarAway(false);
				MobManager.freezeEntity(entity);
				MobManager.addMob(entity.getEntityId(), entity, spawnLoc);
				MobManager.mobNames.put(entity.getEntityId(), mobName);
				MobManager.setMobUndamageable(entity.getEntityId(), entity);
				if (entity instanceof Zombie) {
					((Zombie) entity).setBaby(false);
				}
				
				player.sendMessage(MobManager.chatPrefix + " " + mobType + " has been spawned!");
				return true;

			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to execute this command!");
			}

		}
		return true;
	}
}
