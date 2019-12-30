package me.Flaymed.commands;

import customMobs.MobManager;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.EntityEquipment;

public class UnFreezeMob implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
 		if(sender instanceof Player) {
			if(sender.hasPermission("mob.unfreeze")) {
				
				//Identify Mob Variables
				World world = player.getWorld();
				Integer id = Integer.parseInt(args[0]);
				Entity creature = MobManager.getMob(id);
				Location creatureLocation = creature.getLocation();
				EntityEquipment equiped = ((LivingEntity) creature).getEquipment();
				EntityType newEntityType = creature.getType();
				
				MobManager.removeMob(id, creature);
				MobManager.mobNames.remove(id);
				creature.remove();
				
				Entity entity = (Entity) world.spawnEntity(creatureLocation, newEntityType);
				EntityEquipment entityEquiped = ((LivingEntity) entity).getEquipment();
				entityEquiped.setBoots(equiped.getBoots());
				entityEquiped.setLeggings(equiped.getLeggings());
				entityEquiped.setChestplate(equiped.getChestplate());
				entityEquiped.setHelmet(equiped.getHelmet());
				entity.setCustomName(creature.getCustomName());
				entity.setCustomNameVisible(true);
				((LivingEntity) entity).setCanPickupItems(false);
				((LivingEntity) entity).setRemoveWhenFarAway(false);
				MobManager.mobNames.put(entity.getEntityId(), creature.getCustomName());
				MobManager.addMob(entity.getEntityId(), entity, creatureLocation);
				if (MobManager.denyDamage.containsValue(creature)) {
					MobManager.setMobUndamageable(entity.getEntityId(), entity);
				}
				if (entity instanceof Zombie) {
					((Zombie) entity).setBaby(false);
				}
				
				player.sendMessage(MobManager.chatPrefix + " Entity unfrozen! NOTE: This action changes the id of the mob!");
					
			} else {
				player.sendMessage(MobManager.chatPrefix + " You do not have permission to perform this command!");
			}
		} else {
			Bukkit.broadcastMessage("Only players can execute this command!");
		}
		return true;
	}
}
