package com.yourplugin;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Bullet extends Snowball implements Listener {

    private final Player shooter;

    public Bullet(Player shooter) {
        this.shooter = shooter;
    }

    @Override
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Bullet) {
            // Handle bullet hit logic here
            event.setDamage(5); // Set damage dealt by the bullet
            event.getEntity().sendMessage("You've been hit by a bullet!");
        }
    }
}
