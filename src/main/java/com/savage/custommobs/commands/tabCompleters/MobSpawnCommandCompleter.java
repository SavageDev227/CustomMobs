package com.savage.custommobs.commands.tabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MobSpawnCommandCompleter implements TabCompleter {

    String[] animalArray = {
            "Axolotl", "Bat", "Cat", "Chicken", "Cod", "Cow", "Donkey", "Fox", "Frog", "Glow Squid",
            "Horse", "Mooshroom", "Mule", "Ocelot", "Parrot", "Pig", "Pufferfish", "Rabbit", "Salmon",
            "Sheep", "Skeleton Horse", "Snow Golem", "Squid", "Strider", "Tadpole", "Tropical Fish",
            "Turtle", "Villager", "Wandering Trader", "Bee", "Cave Spider", "Dolphin", "Enderman",
            "Goat", "Iron Golem", "Llama", "Panda", "Piglin", "Polar Bear", "Spider", "Trader Llama",
            "Wolf", "Zombified Piglin", "Blaze", "Creeper", "Drowned", "Elder Guardian", "Endermite",
            "Evoker", "Ghast", "Guardian", "Hoglin", "Husk", "Magma Cube", "Phantom", "Piglin Brute",
            "Pillager", "Ravager", "Shulker", "Silverfish", "Skeleton", "Slime", "Stray", "Vex",
            "Vindicator", "Warden", "Witch", "Wither Skeleton", "Zoglin", "Zombie", "Zombie Villager",
            "Ender Dragon", "Wither", "Camel", "Sniffer"
    };

    List<String> animals = Arrays.asList(animalArray);

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1) {
            return animals;
        }
        return Collections.emptyList();
    }
}
