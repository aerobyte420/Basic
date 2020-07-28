package me.aerobyte;

import me.aerobyte.commands.FlyCommand;
import me.aerobyte.commands.StoreCommand;
import me.aerobyte.commands.TeleportCommand;
import me.aerobyte.commands.TeleportHereCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Basic extends JavaPlugin {

    public void onEnable() {
        getCommand("store").setExecutor(new StoreCommand());
        getCommand("tp").setExecutor(new TeleportCommand());
        getCommand("tphere").setExecutor(new TeleportHereCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }

}
