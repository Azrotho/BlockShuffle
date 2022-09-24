package fr.azrotho.blockshuffle.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnDeath implements Listener {
    @EventHandler
    public static void onDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        org.bukkit.entity.Player player = event.getEntity();
        player.sendMessage("§c§lBlockShuffle §7> §cVous êtes mort !");
        event.setDeathMessage("§c§lBlockShuffle §7> §c" + player.getName() + " §7est mort !");
        player.setHealth(20);
        player.setFoodLevel(20);
        player.teleport(new org.bukkit.Location(player.getWorld(), 0, 196, 0));
        player.setGameMode(org.bukkit.GameMode.SPECTATOR);
        fr.azrotho.blockshuffle.Main.getAlive().put(player.getUniqueId(), false);
        checkWin();
    }

    public static void checkWin(){
        int alive = 0;
        org.bukkit.entity.Player winner = null;
        for(org.bukkit.entity.Player p : org.bukkit.Bukkit.getOnlinePlayers()){
            if(fr.azrotho.blockshuffle.Main.getAlive().get(p.getUniqueId())){
                alive++;
                winner = p;
            }
        }
        if(alive == 1){
            winner.sendMessage("§c§lBlockShuffle §7> §aVous avez gagné !");
            fr.azrotho.blockshuffle.Main.started = false;
            for(org.bukkit.entity.Player p : org.bukkit.Bukkit.getOnlinePlayers()){
                p.kickPlayer("§c§lBlockShuffle §7> §a" + winner.getName() + " §7a gagné !");
            }
        }
    }
}
