package com.savage.custommobs.commands;

import com.savage.custommobs.CustomMobs;
import com.savage.custommobs.utils.ColorUtils;
import com.savage.custommobs.utils.MobUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MobSpawnCommand implements CommandExecutor {

    MobUtils mobUtils = new MobUtils();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("custommob")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;

                //Basic Checks
                if (args.length < 4) {
                    player.sendMessage(ColorUtils.colorize("&c&lWrong Syntax! &cThe correct syntax is /custommob [type] [name] [health] [damage]!"));
                }

                //Set Attribute Values
                String mobType = args[0];
                String mobName = args[1];
                String mobHealth = args[2];
                String mobDamage = args[3];
                double health = Integer.parseInt(mobHealth);
                double damage = Integer.parseInt(mobDamage);
                EntityType entityType = EntityType.valueOf(mobType.toUpperCase());
                //Check if mob is hostile
                if(!mobUtils.isHostile(entityType)) {
                    player.sendMessage(ColorUtils.colorize("&c&lWARNING! &cThis mob is not hostile! The damage attribute will be ignored!"));
                }
                //Spawn Mob
                mobUtils.createMob(player, mobType, mobName, health, damage);
            }
        }
        return true;
    }
}
