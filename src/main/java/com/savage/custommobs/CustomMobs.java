package com.savage.custommobs;

import com.savage.custommobs.commands.MobSpawnCommand;
import com.savage.custommobs.commands.tabCompleters.MobSpawnCommandCompleter;
import com.savage.custommobs.utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CustomMobs extends JavaPlugin {

    Logger log = getServer().getLogger();
    private static CustomMobs plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info(ChatColor.GREEN + "[CustomMobs]: Plugin Enabled!");
        getCommand("custommob").setExecutor(new MobSpawnCommand());
        getCommand("custommob").setTabCompleter(new MobSpawnCommandCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info(ChatColor.RED + "[CustomMobs]: Plugin Disabled!");
    }

    public static CustomMobs getPlugin() {
        return plugin;
    }

}
