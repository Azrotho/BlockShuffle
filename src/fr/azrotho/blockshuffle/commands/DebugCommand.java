package fr.azrotho.blockshuffle.commands;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings[0]) {
            case "start":
                Main.currentMaterial = Material.STONE;
                Main.started = true;
                Main.timerRound = 300;
                for(Player p : Bukkit.getOnlinePlayers()){
                    fr.azrotho.blockshuffle.Main.getHasTouchBlock().put(p.getUniqueId(), false);
                    Main.getAlive().put(p.getUniqueId(), true);
                    p.teleport(new org.bukkit.Location(p.getWorld(), 0, 190, 0));
                    p.sendMessage("§c§lBlockShuffle §7> §aLe jeu commence !");
                    p.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    p.sendMessage("§c§lBlockShuffle §7> §aVous devez toucher le bloc de §c" + Main.currentMaterial.name().toLowerCase() + " §aavant que le temps ne s'écoule,");
                    p.sendMessage("§c§lBlockShuffle §7> §aou vous serez éliminé !");
                    p.sendMessage("§c§lBlockShuffle §7> §aLe Jeu se termine au bout de la 25ème manche, qui est l'Oeuf de l'Ender Dragon !");
                }
                break;
            case "stop":
                fr.azrotho.blockshuffle.Main.started = false;
                break;
        }
        return true;
    }
}
