// src/main/java/com/yourplugin/AK47Plugin.java
package com.yourplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AK47Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("AK-47 Plugin Enabled!");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("AK-47 Plugin Disabled!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        // Check if the player is holding the AK-47 (custom item)
        if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) { // Replace with your custom item
            // Implement shooting logic here
            shootAK47(player);
        }
    }

    private void shootAK47(Player player) {
        // Create a custom bullet projectile to represent the bullet
        Bullet bullet = new Bullet(player);
        bullet.setVelocity(player.getLocation().getDirection().multiply(2)); // Adjust speed as necessary
        player.sendMessage("You fired the AK-47!");
    }
}