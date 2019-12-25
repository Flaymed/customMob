package customMobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.craftbukkit.v1_8_R1.entity.*;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

//import com.mysql.jdbc.PreparedStatement;

import me.Flaymed.commands.createMob;
import me.Flaymed.commands.test;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R1.NBTTagCompound;


public class Main extends JavaPlugin implements Listener {


	public static Main pl;

	public static Main getPL() {
		return pl;
	}

	public void freezeEntity(Entity en){
	      Entity nmsEn = (Entity) ((CraftEntity) en).getHandle();
	      NBTTagCompound compound = new NBTTagCompound();
	      ((net.minecraft.server.v1_8_R1.Entity) nmsEn).c(compound);
	      compound.setByte("NoAI", (byte) 1);
	      ((net.minecraft.server.v1_8_R1.Entity) nmsEn).f(compound);
	  }
	
	public void mysqlConnect() {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/javadatabase?characterEncoding=latin1&useConfigs=maxPerformance";


		final String USER = "root";
		final String PASS = "Test1234";

		try {
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Bukkit.broadcastMessage("Successfully connected to the database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onEnable() {
		mysqlConnect();
		Bukkit.broadcastMessage("Plugin is on and working!");
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("createMob").setExecutor(new createMob());
		this.getCommand("test").setExecutor(new test());
		
		for(World w: Bukkit.getWorlds()){
	          for(Entity en : w.getEntities()){
	              if(en instanceof Creature && !(en instanceof Player)){
	                  freezeEntity(en);
	              }
	          }
	      }
		
		pl = this;
	}

	@Override
	public void onDisable() {
		Bukkit.broadcastMessage("Server is shutting down");
	}

	//Event Handling
	@EventHandler
	 public void onEntityCombust(EntityCombustEvent event){
		 if(event.getEntity() instanceof Monster){
			 event.setCancelled(true);

		 }
	 }

	@EventHandler
	public void onMobDamage(EntityDamageEvent e) {

	EntityType type = e.getEntityType();

	if(type == EntityType.PLAYER ) return; //If it's a player then return..Don't do damage.

	e.setCancelled(true); //It has to be a zombie to get to this point, cancelling the damage.

	}
}
