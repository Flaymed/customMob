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

import me.Flaymed.commands.Armor;
import me.Flaymed.commands.CreateMob;
import me.Flaymed.commands.DamageOff;
import me.Flaymed.commands.DamageOn;
import me.Flaymed.commands.DeleteEntity;
import me.Flaymed.commands.Equip;
import me.Flaymed.commands.FreezeMob;
import me.Flaymed.commands.GetEntityId;
import me.Flaymed.commands.NameOff;
import me.Flaymed.commands.NameOn;
import me.Flaymed.commands.Rename;
import me.Flaymed.commands.UnFreezeMob;

public class Main extends JavaPlugin implements Listener {

	public static Main pl;

	public static Main getPL() {
		return pl;
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("createMob").setExecutor(new CreateMob());
		this.getCommand("unfreeze").setExecutor(new UnFreezeMob());
		this.getCommand("freeze").setExecutor(new FreezeMob());
		this.getCommand("armor").setExecutor(new Armor());
		this.getCommand("rename").setExecutor(new Rename());
		this.getCommand("damageon").setExecutor(new DamageOn());
		this.getCommand("damageoff").setExecutor(new DamageOff());
		this.getCommand("nameon").setExecutor(new NameOn());
		this.getCommand("nameoff").setExecutor(new NameOff());
		this.getCommand("entities").setExecutor(new GetEntityId());
		this.getCommand("equip").setExecutor(new Equip());
		this.getCommand("deletemob").setExecutor(new DeleteEntity());
		pl = this;
	}

	@Override
	public void onDisable() {
		Bukkit.broadcastMessage(MobManager.chatPrefix + " Plugin is shutting down");
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
		
		if (MobManager.mobs.containsValue(creature)) {
			Integer id = creature.getEntityId();
			MobManager.mobs.remove(id);
			MobManager.mobLocations.remove(creature);
		} else {
			return;
		}
		
	}
	
	@EventHandler
	public void onMobDamage(EntityDamageEvent e) {

	Entity en = e.getEntity();
	
	if (MobManager.denyDamage.containsValue(en)) {
		e.setCancelled(true);
	} else {
		return;
	}
	
	}
}
