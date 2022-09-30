package fr.azrotho.blockshuffle;

import fr.azrotho.blockshuffle.events.DamageGestion;
import fr.azrotho.blockshuffle.events.GestionPvP;
import fr.azrotho.blockshuffle.utils.BlockTouch;
import fr.azrotho.blockshuffle.utils.ScoreboardGestion;
import fr.azrotho.blockshuffle.utils.Timer;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static int timeri;
    public static boolean started;
    private static HashMap<UUID, Boolean> hasTouchBlock = new HashMap<>();
    private static HashMap<UUID, Boolean> alive = new HashMap<>();
    public static int vague = 0;
    public static int timerRound = 300;
    public static Material currentMaterial;


    public void onEnable() {
        timeri = 0;
        started = false;
        currentMaterial = Material.BEDROCK;
        getServer().getPluginManager().registerEvents(new fr.azrotho.blockshuffle.events.OnJoin(), this);
        getServer().getPluginManager().registerEvents(new DamageGestion(), this);
        getServer().getPluginManager().registerEvents(new fr.azrotho.blockshuffle.events.OnDeath(), this);
        getServer().getPluginManager().registerEvents(new GestionPvP(), this);
        Timer timer = new Timer();
        timer.runTaskTimer(this, 0, 20);
        BlockTouch blockTouch = new BlockTouch();
        blockTouch.runTaskTimer(this, 0, 1);
        ScoreboardGestion scoreboard = new ScoreboardGestion();
        scoreboard.runTaskTimer(this, 0, 5);
        getCommand("debug").setExecutor(new fr.azrotho.blockshuffle.commands.DebugCommand());
    }

    public static HashMap<UUID, Boolean> getHasTouchBlock() {
        return hasTouchBlock;
    }

    public static HashMap<UUID, Boolean> getAlive() {
        return alive;
    }

}
