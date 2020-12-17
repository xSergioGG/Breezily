package me.zsergio.breezily.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.zsergio.breezily.Main;
import me.zsergio.breezily.manage.PlayerManager;

public class Mechanics implements Listener {
	
	private Main plugin = Main.getInstance();
	private PlayerManager playerManager = plugin.getPlayerManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		playerManager.addPlayer(player);
		
		ItemStack madera = new ItemStack(Material.WOOD);
		madera.setAmount(64);
		ItemMeta maderameta = madera.getItemMeta();
		maderameta.setDisplayName("§dMadera");
		List<String> maderalore = new ArrayList<String>();
		maderalore.add("§7Contruye con estos Bloques.");
		maderalore.add("§7si no deja deberas activar con el comando §8/breezily§7!");
		maderameta.setLore(maderalore);
		madera.setItemMeta(maderameta);
		
		player.getInventory().setItem(8, madera);
		
		player.updateInventory();
		
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(playerManager.getPlayer(player).getBreezily() == true) {
			if(event.getBlockReplacedState().getType() == Material.AIR) {
				event.setCancelled(false);
				Material type = event.getBlock().getType();
				playerManager.getPlayer(player).placeBlock(event.getBlock().getLocation(), type);
				player.getItemInHand().setAmount(64);
				player.updateInventory();
			} else {
				player.sendMessage("§cNo puedes poner bloques aquí!");
			}
		}
	}

}
