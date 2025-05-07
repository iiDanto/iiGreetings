package dev.iiDanto.iiGreetings.listeners;

import dev.iiDanto.iiGreetings.IiGreetings;
import dev.iiDanto.iiGreetings.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    private final IiGreetings main;

    public ConnectionListener(IiGreetings main) {
        this.main = main;
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e){
        if (main.getConfig().getBoolean("configuration.join-message-enabled")){
            String msg = main.getConfig().getString("configuration.welcome-message");
            if (msg != null) {
                String message = msg.replace("%player%", e.getPlayer().getName());
                e.setQuitMessage(null);
                Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ColorUtils.color(message)));
            } else {
                IiGreetings.LOGGER.warning("[iiGreetings]: Error while sending welcome message, ensure a correct configuration and try again.");
            }
        }
        if (main.getConfig().getBoolean("configuration.join-sound.enabled")){
            String sound = main.getConfig().getString("configuration.join-sound.sound");
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.valueOf(sound), 1.0f, 1.0f));
        }
        if (main.getConfig().getBoolean("configuration.send-private-welcome")){
            String msg = main.getConfig().getString("configuration.private-welcome-message");
            if (msg != null) {
                String message = msg.replace("%player%", e.getPlayer().getName());
                e.getPlayer().sendMessage(ColorUtils.color(message));
            } else {
                IiGreetings.LOGGER.warning("[iiGreetings]: Error while sending private welcome message, ensure a correct configuration and try again.");
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (main.getConfig().getBoolean("configuration.leave-message-enabled")){
            String msg = main.getConfig().getString("configuration.leave-message");
            if (msg != null) {
                String message = msg.replace("%player%", e.getPlayer().getName());
                e.setJoinMessage(null);
                Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ColorUtils.color(message)));
            } else {
                IiGreetings.LOGGER.warning("[iiGreetings]: Error while sending leave message, ensure a correct configuration and try again.");
            }
        }
    }
}
