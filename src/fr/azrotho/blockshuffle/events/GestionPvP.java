package fr.azrotho.blockshuffle.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GestionPvP implements Listener {

    @EventHandler
    public static void onPvP(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player){
            event.setCancelled(true);
        }
    }

}
