package fr.azrotho.blockshuffle.events;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnJoin implements Listener {
    @EventHandler
    public static void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        org.bukkit.entity.Player player = event.getPlayer();
        player.sendMessage("§c§lBlockShuffle §7> §aBienvenue sur le serveur !");
        if(Main.started){
            player.kickPlayer("§c§lBlockShuffle §7> §cUne partie est déjà en cours !");
        }

        Main.getAlive().put(player.getUniqueId(), true);
        event.setJoinMessage("§c§lBlockShuffle §7> §a" + player.getName() + " §7a rejoint le serveur !");
        player.teleport(new org.bukkit.Location(player.getWorld(), 0, 196, 0));
        // Create box at 0,0
        for (int x = -5; x < 5; x++) {
            for (int y = 195; y < 200; y++) {
                for (int z = -5; z < 5; z++) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.BARRIER);
                }
            }
        }
        for (int x = -4; x < 4; x++) {
            for (int y = 196; y < 199; y++) {
                for (int z = -4; z < 4; z++) {
                    player.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
                }
            }
        }
    }
}
