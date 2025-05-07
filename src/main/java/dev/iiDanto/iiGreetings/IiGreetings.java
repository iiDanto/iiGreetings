package dev.iiDanto.iiGreetings;

import dev.iiDanto.iiGreetings.commands.ReloadCommand;
import dev.iiDanto.iiGreetings.listeners.ConnectionListener;
import dev.iiDanto.iiGreetings.utils.ColorUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class IiGreetings extends JavaPlugin {
    public static final Logger LOGGER = Logger.getLogger("iiGreetings");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ConnectionListener(this), this);
        getCommand("iireload").setExecutor(new ReloadCommand(this));
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        LOGGER.info(ColorUtils.color("&7iiGreetings has &astarted &7successfully."));
    }

    @Override
    public void onDisable() {
        LOGGER.info(ColorUtils.color("&7iiGreetings is &cshutting down&7."));
    }
}
