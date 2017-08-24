package net.oculate.darkfreeze.listeners;

import net.oculate.darkfreeze.DarkFreeze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private DarkFreeze plugin;

    public PlayerListener(DarkFreeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler //TODO: Make it broadcast if a player disconnect
    public void onPlayerDisconnectEvent(PlayerQuitEvent event) {
        if (event.getPlayer() != null) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                plugin.getManagerHandler().getFrozenManager().unfreezePlayer(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPlayerKickedEvent(PlayerKickEvent event) {
        if (event.getPlayer() != null) {
            if (plugin.getManagerHandler().getFrozenManager().isFrozen(event.getPlayer().getUniqueId())) {
                plugin.getManagerHandler().getFrozenManager().unfreezePlayer(event.getPlayer());
            }
        }
    }
}