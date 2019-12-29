package customMobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.Flaymed.commands.armor;
import me.Flaymed.commands.createMob;
import me.Flaymed.commands.damageOff;
import me.Flaymed.commands.damageOn;
import me.Flaymed.commands.freezeMob;
import me.Flaymed.commands.nameOff;
import me.Flaymed.commands.nameOn;
import me.Flaymed.commands.rename;
import me.Flaymed.commands.unFreezeMob;

public class Main extends JavaPlugin implements Listener {

	public static Main pl;

	public static Main getPL() {
		return pl;
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("createMob").setExecutor(new createMob());
		this.getCommand("unfreeze").setExecutor(new unFreezeMob());
		this.getCommand("freeze").setExecutor(new freezeMob());
		this.getCommand("armor").setExecutor(new armor());
		this.getCommand("rename").setExecutor(new rename());
		this.getCommand("damageon").setExecutor(new damageOn());
		this.getCommand("damageoff").setExecutor(new damageOff());
		this.getCommand("nameon").setExecutor(new nameOn());
		this.getCommand("nameoff").setExecutor(new nameOff());
		pl = this;
	}

	@Override
	public void onDisable() {
		Bukkit.broadcastMessage("[CustomMobs] Plugin is shutting down");
	}

	//Event Handling
	@EventHandler
	 public void onEntityCombust(EntityCombustEvent event){
		 if(event.getEntity() instanceof Monster){
			 event.setCancelled(true);

		 }
	 }
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		Entity creature = e.getEntity();
		
		if (mobManager.mobs.containsValue(creature)) {
			String name = creature.getCustomName();
			mobManager.mobs.remove(name);
			mobManager.mobLocations.remove(creature);
		} else {
			return;
		}
		
	}
	
	@EventHandler
	public void onMobDamage(EntityDamageEvent e) {

	Entity en = e.getEntity();
	
	if (mobManager.denyDamage.containsValue(en)) {
		e.setCancelled(true);
	} else {
		return;
	}
	
	}
}
