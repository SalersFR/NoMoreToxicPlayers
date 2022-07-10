package fr.salers.nomoretoxic.nomoretoxicplayers;

import fr.salers.nomoretoxic.nomoretoxicplayers.listener.PlayerChatListener;
import fr.salers.nomoretoxic.nomoretoxicplayers.manager.CheckManager;
import fr.salers.nomoretoxic.nomoretoxicplayers.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoMoreToxicPlayers extends JavaPlugin {

    private ConfigManager configManager;
    private CheckManager checkManager;
    private static NoMoreToxicPlayers instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        this.saveDefaultConfig();

        this.configManager = new ConfigManager(this.getConfig());
        this.checkManager = new CheckManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public CheckManager getCheckManager() {
        return checkManager;
    }

    public static NoMoreToxicPlayers getInstance() {
        return instance;
    }
}
