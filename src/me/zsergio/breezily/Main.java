package me.zsergio.breezily;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.zsergio.breezily.commands.brCMD;
import me.zsergio.breezily.listeners.Mechanics;
import me.zsergio.breezily.manage.PlayerManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		instance = this;
		playerManager = new PlayerManager();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Mechanics(), this);
		getCommand("breezily").setExecutor(new brCMD());
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public static Main getInstance() {
		return instance;
	}

}
