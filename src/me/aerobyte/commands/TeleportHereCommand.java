package me.aerobyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportHereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;
        if (player.hasPermission("basic.tphere")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Usage: /teleporthere <player>");
            }
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Error: Player not found.");

                }
                target.teleport(player);
                for (Player staff : Bukkit.getServer().getOnlinePlayers()) {

                    ChatColor color = ChatColor.BLACK;

                    if (target.isOp()) {
                        color = ChatColor.RED;
                    }
                    if (target.hasPermission("spark.default")) {
                        color = ChatColor.WHITE;
                    }
                    if (target.hasPermission("spark.trialmod")) {
                        color = ChatColor.YELLOW;
                    }
                    if (target.hasPermission("spark.mod")) {
                        color = ChatColor.DARK_PURPLE;
                    }
                    if (target.hasPermission("spark.seniormod")) {
                        color = ChatColor.DARK_AQUA;
                    }
                    if (target.hasPermission("spark.admin")) {
                        color = ChatColor.RED;
                    }
                    if (target.hasPermission("spark.senioradmin")) {
                        color = ChatColor.RED;
                    }
                    if (target.hasPermission("spark.platadmin")) {
                        color = ChatColor.DARK_RED;
                    }
                    if (target.hasPermission("spark.manager")) {
                        color = ChatColor.AQUA;
                    }
                    if (target.hasPermission("spark.owner")) {
                        color = ChatColor.DARK_RED;
                    }
                    player.sendMessage(ChatColor.GRAY + "Teleporting " + color + target.getName() + ChatColor.GRAY + " to yourself");
                    target.sendMessage(ChatColor.GRAY + "You have been teleported to " + color + player.getName());
                    return true;
                }
                if(!(player.hasPermission("basic.tphere"))) {
                    player.sendMessage(ChatColor.RED + "Error: You do not have permission to use this command");
                }
            }
        }
            return false;
        }

}
