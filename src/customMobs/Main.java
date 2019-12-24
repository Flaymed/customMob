package customMobs;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Flaymed.commands.createMob;
import me.Flaymed.commands.test;


public class Main extends JavaPlugin implements Listener {

	public static Main pl;
	
	public static Main getPL() {
		return pl;
	}
	
	@Override
	public void onEnable() {
		Bukkit.broadcastMessage("Plugin is on and working!");
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("createMob").setExecutor(new createMob());
		this.getCommand("test").setExecutor(new test());
		
		
		pl = this;
	}
	
	@Override
	public void onDisable() {
		Bukkit.broadcastMessage("Server is shutting down");
	}

}
