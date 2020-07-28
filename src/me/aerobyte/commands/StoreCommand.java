package me.aerobyte.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.GOLD + "You may purchase a rank at " + ChatColor.WHITE + "lunar.gg/store");
        }

        Player player = (Player) commandSender;
        if(command.getName().equalsIgnoreCase("store")) {
            player.sendMessage(ChatColor.GRAY + "You may purchase a rank at " + ChatColor.AQUA + "lunar.gg/store");
        }
        return false;
    }
}
