package com.savage.custommobs.utils;

import com.savage.custommobs.CustomMobs;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class MobUtils {

    public Entity mob;

    CustomMobs plugin = CustomMobs.getPlugin();

    private final EntityType[] hostileMobTypes = {
            EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CAVE_SPIDER, EntityType.CREEPER, EntityType.ENDERMAN, EntityType.WITCH,
            EntityType.HOGLIN, EntityType.BLAZE, EntityType.GHAST, EntityType.MAGMA_CUBE, EntityType.SLIME, EntityType.SILVERFISH, EntityType.ENDERMITE,
            EntityType.VEX, EntityType.VINDICATOR, EntityType.EVOKER, EntityType.PILLAGER, EntityType.RAVAGER, EntityType.PHANTOM, EntityType.DROWNED,
            EntityType.STRAY, EntityType.HUSK, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.SHULKER, EntityType.WOLF, EntityType.PIGLIN,
            EntityType.POLAR_BEAR, EntityType.PANDA, EntityType.OCELOT, EntityType.IRON_GOLEM, EntityType.SNOWMAN, EntityType.DOLPHIN, EntityType.STRIDER,
            EntityType.LLAMA, EntityType.TRADER_LLAMA, EntityType.BEE
    };

    public boolean isHostile(EntityType entity) {
        return Arrays.asList(hostileMobTypes).contains(entity);
    }
    public void createMob(Player player, String mobType, String mobName, double health, double damage) {

        //Initialize Variables
        Location location = player.getLocation();
        EntityType entityType = EntityType.valueOf(mobType.toUpperCase());


        //Spawn Mob
        Entity mob = player.getWorld().spawnEntity(location, entityType);

        if(mobName == null) {
            mob.setCustomName(mobType);
            mob.setCustomNameVisible(true);
        } else {
            mob.setCustomName(mobName);
            mob.setCustomNameVisible(true);
        }
        //Change Attributes
        AttributeInstance healthAttribute = ((LivingEntity) mob).getAttribute(Attribute.GENERIC_MAX_HEALTH);
        healthAttribute.setBaseValue(health * 2);
        ((LivingEntity) mob).setHealth(health);

        AttributeInstance damageAttribute = ((LivingEntity) mob).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        if (damageAttribute != null) {
            damageAttribute.setBaseValue(damage);
        } else {
            player.sendMessage(ColorUtils.colorize("&4Entity type " + mobType + " does not have the GENERIC_ATTACK_DAMAGE attribute. It will be ignored."));
        }


    }





}
