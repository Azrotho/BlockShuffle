package fr.azrotho.blockshuffle.events;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageGestion implements Listener {

    @EventHandler
    public static void onDamage(EntityDamageEvent event) {
        if(!Main.started){
            event.setCancelled(true);
        }
        if(Main.timeri <= 30){
            event.setCancelled(true);
        }
    }
}
