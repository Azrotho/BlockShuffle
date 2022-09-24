package fr.azrotho.blockshuffle.utils;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockTouch extends BukkitRunnable {
    @Override
    public void run() {
        if(Main.started){
            // Check if player is in currentMaterial

                // Check if player has touch block
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(Main.getHasTouchBlock().get(p.getUniqueId())){
                        if (p.getLocation().add(0, -1, 0).getBlock().getType() == Main.currentMaterial) {
                            Main.getHasTouchBlock().put(p.getUniqueId(), true);
                            p.sendMessage("§aVous avez touché le bloc, vous passerez au round suivant !");
                        }
                        if (p.getLocation().getBlock().getType() == Main.currentMaterial) {
                            Main.getHasTouchBlock().put(p.getUniqueId(), true);
                            p.sendMessage("§aVous avez touché le bloc, vous passerez au round suivant !");
                        }
                }
            }
        }
    }
}
