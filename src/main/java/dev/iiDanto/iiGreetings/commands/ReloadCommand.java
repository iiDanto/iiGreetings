package dev.iiDanto.iiGreetings.commands;

import dev.iiDanto.iiGreetings.IiGreetings;
import dev.iiDanto.iiGreetings.utils.ColorUtils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    private final IiGreetings core;

    public ReloadCommand(IiGreetings core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        core.reloadConfig();
        if (sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage(ColorUtils.color("&7Successfully reloaded &#559effiiGreetings&7."));
            p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
        }
        return true;
    }
}
