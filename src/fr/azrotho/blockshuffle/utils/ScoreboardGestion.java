package fr.azrotho.blockshuffle.utils;

import fr.azrotho.blockshuffle.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class ScoreboardGestion extends BukkitRunnable {
    @Override
    public void run() {
        if(Main.started) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
                Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
                Objective objective = scoreboard.registerNewObjective("test", "dummy", "§c§lBLOCKSHUFFLE");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName("§6§lBlockShuffle");
                Score score = objective.getScore("§f");
                score.setScore(4);
                Score actualBlock = objective.getScore("§cBloc actuel: §f" + fr.azrotho.blockshuffle.Main.currentMaterial);
                Score actualRound = objective.getScore("§cRound actuel: §f" + (fr.azrotho.blockshuffle.Main.vague + 1));
                actualRound.setScore(3);
                actualBlock.setScore(2);
                Score time = objective.getScore("§cTemps restant: §f" + Main.timerRound);
                time.setScore(1);
                final Score Timeri = objective.getScore("§f" + ((Main.timeri - (1200 * (Main.timeri / 1200))) / 60 + " §cmin§f " + Main.timeri % 60));
                Timeri.setScore(0);

                p.setScoreboard(scoreboard);
            }
        }
    }
}
