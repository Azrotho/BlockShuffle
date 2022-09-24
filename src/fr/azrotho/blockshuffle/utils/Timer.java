package fr.azrotho.blockshuffle.utils;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Timer extends BukkitRunnable {

    @Override
    public void run() {
        if(Main.started){
            Main.timeri++;
            Main.timerRound--;
            if(Main.timerRound == 0){
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("§cLe round est terminé !");
                    if (Main.getAlive().get(p.getUniqueId())) {
                        if (Main.getHasTouchBlock().get(p.getUniqueId())) {
                            p.sendMessage("§aVous avez touché le bloc durant le round, vous passez à la phase suivante !");
                            Main.getHasTouchBlock().put(p.getUniqueId(), false);
                        } else {
                            p.sendMessage("§cVous n'avez pas touché le bloc durant le round, vous êtes éliminé !");
                            p.setHealth(0);
                        }
                    }
                }
                Main.timerRound = 300;
                Main.vague++;
                if(Main.vague <= 10){

                    int random = (int) (Math.random() * 100);
                    if(random < 10){
                        Main.currentMaterial = Material.SAND;
                    }
                    else if(random < 20) {
                        Main.currentMaterial = Material.GRAVEL;
                    }
                    else if(random < 30){
                        Main.currentMaterial = Material.COBBLESTONE;
                    }
                    else if(random < 40){
                        Main.currentMaterial = Material.GLASS;
                    }
                    else if(random < 50){
                        Main.currentMaterial = Material.IRON_ORE;
                    }
                    else if(random < 60){
                        Main.currentMaterial = Material.COPPER_BLOCK;
                    }
                    else if(random < 70){
                        Main.currentMaterial = Material.IRON_ORE;
                    }
                    else if(random < 80){
                        Main.currentMaterial = Material.OAK_PLANKS;
                    }
                    else if(random < 90){
                        Main.currentMaterial = Material.WHITE_CONCRETE;
                    }else if(random < 100){
                        Main.currentMaterial = Material.RED_CONCRETE;
                    }
                }else if(Main.vague <= 15) {
                    int random = (int) (Math.random() * 100);
                    if (random < 20) {
                        Main.currentMaterial = Material.WHITE_WOOL;
                    } else if (random < 30) {
                        Main.currentMaterial = Material.NETHERRACK;
                    } else if (random < 40) {
                        Main.currentMaterial = Material.LAPIS_BLOCK;
                    } else if (random < 50) {
                        Main.currentMaterial = Material.IRON_BLOCK;
                    } else if (random < 60) {
                        Main.currentMaterial = Material.GOLD_ORE;
                    } else if (random < 70) {
                        Main.currentMaterial = Material.OBSIDIAN;
                    }else if (random < 80){
                        Main.currentMaterial = Material.GOLD_BLOCK;
                    }
                    else if(random < 90) {
                        Main.currentMaterial = Material.NETHER_GOLD_ORE;
                    }
                    else if (random < 100) {
                        Main.currentMaterial = Material.PISTON;
                    }
                }
                else if(Main.vague <= 20){
                    int random = (int) (Math.random() * 100);
                    if(random < 20){
                        Main.currentMaterial = Material.MAGMA_BLOCK;
                    }
                    else if(random < 30){
                        Main.currentMaterial = Material.ANVIL;
                    }
                    else if(random < 40){
                        Main.currentMaterial = Material.STONE_BRICK_SLAB;
                    }
                    else if(random < 50){
                        Main.currentMaterial = Material.SOUL_SAND;
                    }
                    else if(random < 60){
                        Main.currentMaterial = Material.STONE_BRICKS;
                    }
                    else if(random < 70){
                        Main.currentMaterial = Material.NETHER_BRICKS;
                    }
                    else if(random < 80){
                        Main.currentMaterial = Material.GRAVEL;
                    }
                    else if(random < 90) {
                        Main.currentMaterial = Material.NETHER_GOLD_ORE;
                    }
                    else if(random < 100){
                        Main.currentMaterial = Material.NETHER_QUARTZ_ORE;
                    }
                }else if(Main.vague == 21){
                    Main.currentMaterial = Material.GRASS_BLOCK;
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.sendMessage("§6§lVous sentez une pression, qui vous demande de vous rapprochez du dragon...");
                    }
                }else if(Main.vague == 22) {
                    Main.currentMaterial = Material.STONE_BRICKS;
                }else if(Main.vague == 23) {
                    Main.currentMaterial = Material.END_STONE;
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.sendMessage("§6§lLe dragon vous regarde, il semble vous attendre...");
                    }
                }else if(Main.vague == 24) {
                    Main.currentMaterial = Material.DRAGON_EGG;
                    Main.timerRound = 600;
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage("§6§lCeci est le round final. Vous devez toucher l'oeuf du dragon pour gagner !");
                    }
                }else if(Main.vague == 25){
                    List<String> winners = new ArrayList<>();
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(Main.getAlive().get(p.getUniqueId())){
                            winners.add(p.getName());
                        }
                    }
                    for(Player p : Bukkit.getOnlinePlayers()){
                        Main.getAlive().put(p.getUniqueId(), false);
                        p.setGameMode(org.bukkit.GameMode.SPECTATOR);
                        p.sendMessage("§6§lLa victoire est remporté par §f:" + winners.toString());
                        p.sendMessage(" §6§lMerci d'avoir joué !");
                    }
                    Main.currentMaterial = Material.AIR;
                }
            }
        }
    }
}
