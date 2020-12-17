package me.zsergio.breezily.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zsergio.breezily.Main;
import me.zsergio.breezily.manage.PlayerManager;

public class brCMD implements CommandExecutor {
	
	private Main plugin = Main.getInstance();
	private PlayerManager playerManager = plugin.getPlayerManager();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			playerManager.getPlayer(player).toggleBreezily();
			if(playerManager.getPlayer(player).getBreezily() == true) {
				player.sendMessage("§aModo Breezily activado.");
			} else {
				player.sendMessage("§cModo Breezily desactivado.");
			}
		}
		return true;
	}

}
