package me.zsergio.breezily.manage;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PlayerManager {

	private HashMap<UUID, CustomPlayer> playerMap = new HashMap<>();
	
	public HashMap<UUID, CustomPlayer> getPlayerMap() {
		return playerMap;
	}
	
	public void addPlayer(Player player) {
		UUID uuid = player.getUniqueId();
		if(!playerMap.containsKey(uuid)) {
			playerMap.put(uuid, new CustomPlayer(uuid));
		}
	}
	
	public CustomPlayer getPlayer(Player player) {
		return playerMap.get(player.getUniqueId());
	}
	
}
