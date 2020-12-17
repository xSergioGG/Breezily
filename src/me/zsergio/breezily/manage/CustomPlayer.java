package me.zsergio.breezily.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.zsergio.breezily.Main;

public class CustomPlayer {
	
	private static Main plugin = Main.getInstance();
	
	private UUID uuid;
	
	private boolean breezily = false;
	private Player player;
	private List<Integer> runnables = new ArrayList<>();
	
	public CustomPlayer(UUID uuid) {
		this.uuid = uuid;
		this.player = Bukkit.getPlayer(uuid);
	}
	
	public void toggleBreezily() {
		if(breezily == false) {
			//HABILITAR
			breezily = true;
			
			player.updateInventory();
			
		} else {
			player.updateInventory();
			
			breezily = false;
		}
	}
	
	public boolean getBreezily() {
		return breezily;
	}
	
	public void setBreezily(boolean breezily) {
		this.breezily = breezily;
	}
	
	public void placeBlock(Location loc, Material material) {
		loc.getBlock().setType(material);
			runnables.add(Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				int taskID = runnables.size();
				int seconds = 5;
				@Override
				public void run() {
					if(seconds == 5) {
						loc.getBlock().setType(Material.DIAMOND_ORE);
					} if(seconds == 4) {
						loc.getBlock().setType(Material.EMERALD_ORE);
					} if(seconds == 3) {
						loc.getBlock().setType(Material.GOLD_ORE);
					} if(seconds == 2) {
						loc.getBlock().setType(Material.IRON_ORE);
					} if(seconds == 1) {
						loc.getBlock().setType(Material.REDSTONE_ORE);
					}
					seconds--;
					if(seconds == 0) {
						loc.getBlock().setType(Material.AIR);
						Bukkit.getScheduler().cancelTask(taskID);
					}
					
				}
			}, 20L, 20L));
	}

}
