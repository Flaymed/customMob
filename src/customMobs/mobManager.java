package customMobs;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class mobManager {
	
	public static HashMap<String, Entity> mobs = new HashMap<String, Entity>();
	public static HashMap<Entity, Location> mobLocations = new HashMap<Entity, Location>();
	public static HashMap<String, Entity> denyDamage = new HashMap<String, Entity>();
	
	public static void addMob(String name, Entity creature, Location location) {
		mobs.put(name, creature);
		mobLocations.put(creature, location);
	}
	
	public static void removeMob(String name, Entity creature) {
		mobs.remove(name);
		mobLocations.remove(creature);
	}
	
	public static Entity getMob(String name) {
		Entity mobData = mobs.get(name);
		
		return mobData;
	}
	
	public static void updateMobName(String oldName, Entity creature, Location creatureLocation, String newName) {
		mobs.remove(oldName);
		mobs.put(newName, creature);
		
		mobLocations.remove(creature);
		mobLocations.put(creature, creatureLocation);
		
	}

	public static Location getLocation(Entity creature) {
		
		Location mobLocation = mobLocations.get(creature);
		
		return mobLocation;
	}
	
	public static void setMobDamageable(String name) {
		denyDamage.remove(name);
	}
	
	public static void setMobUndamageable(String name, Entity en) {
		denyDamage.put(name, en);
	}
}
