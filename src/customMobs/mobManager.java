package customMobs;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import net.minecraft.server.v1_8_R1.NBTTagCompound;



public class MobManager {
	
	public static String chatPrefix = ChatColor.GRAY + "[" + ChatColor.RED + "CustomMobs" + ChatColor.GRAY + "]" + ChatColor.YELLOW;
	public static HashMap<Integer, Entity> mobs = new HashMap<Integer, Entity>();
	public static HashMap<Integer, String> mobNames = new HashMap<Integer, String>();
	public static HashMap<Entity, Location> mobLocations = new HashMap<Entity, Location>();
	public static HashMap<Integer, Entity> denyDamage = new HashMap<Integer, Entity>();
	
	public static void addMob(Integer id, Entity creature, Location location) {
		mobs.put(id, creature);
		mobLocations.put(creature, location);
	}
	
	public static void removeMob(Integer id, Entity creature) {
		mobs.remove(id);
		mobLocations.remove(creature);
	}
	
	public static Entity getMob(Integer id) {
		Entity mobData = mobs.get(id);
		
		return mobData;
	}

	public static Location getLocation(Entity creature) {
		
		Location mobLocation = mobLocations.get(creature);
		
		return mobLocation;
	}
	
	public static void setMobDamageable(Integer id) {
		denyDamage.remove(id);
	}
	
	public static void setMobUndamageable(Integer id, Entity en) {
		denyDamage.put(id, en);
	}
	
	
	public static void updateName(Integer id, String newName) {
		mobNames.remove(id);
		
		mobNames.put(id, newName);
	}
	
	/*
	 * @param Entity e | Entity to freeze 
	 */
	
	public static void freezeEntity(Entity en) {
		net.minecraft.server.v1_8_R1.Entity nmsEn = ((CraftEntity) en).getHandle();
	    NBTTagCompound compound = new NBTTagCompound();
	    ((net.minecraft.server.v1_8_R1.Entity) nmsEn).c(compound);
	    compound.setByte("NoAI", (byte) 1);
	    ((net.minecraft.server.v1_8_R1.Entity) nmsEn).f(compound);
	}	
}

