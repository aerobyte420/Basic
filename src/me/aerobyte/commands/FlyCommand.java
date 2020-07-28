package me.aerobyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;
        if (player.hasPermission("basic.fly")) {
            if (player.isFlying()) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(ChatColor.GRAY + "Flight mode: " + ChatColor.RED + "Disabled");
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatColor.GRAY + "Flight mode: " + ChatColor.GREEN + "Enabled");
            }
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Error: Player not found");
                }

                ChatColor color = ChatColor.WHITE;

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
                if (target.isFlying()) {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    target.sendMessage(ChatColor.GRAY + "Flight mode: " + ChatColor.RED + "Disabled");
                    player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.RED + "disabled " + color + target.getName() + ChatColor.GRAY + " 's flight mode.");
                } else {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    target.sendMessage(ChatColor.GRAY + "Flight mode: " + ChatColor.GREEN + "Enabled");
                    player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.GREEN + "enabled " + color + target.getName() + ChatColor.GRAY + " 's flight mode.");
                return true;
                }
            }
        }
        return false;
    }
}

