package net.betterverse.mychunks.listeners;

import net.betterverse.mychunks.MyChunks;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerEventListener extends PlayerListener {

    /**
     * Buckets can only be emptied within an OwnedChunk by the owner, a coowner, or an admin
     * 
     * @param event The PlayerBucketEmptyEvent that occurred
     */
    @Override
    public void onPlayerBucketEmpty (PlayerBucketEmptyEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlockClicked().getRelative(event.getBlockFace())))
            event.setCancelled(true);
    }

    /**
     * Buckets can only be filled within an OwnedChunk by the owner, a coowner, or an admin
     * 
     * @param event The PlayerBucketFillEvent that occurred
     */
    @Override
    public void onPlayerBucketFill (PlayerBucketFillEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlockClicked()))
            event.setCancelled(true);
    }
    
    /**
     * Chests can only be opened within an OwnedChunk by the owner, a coowner, or an admin
     * 
     * @param event The PlayerInteractEvent that occurred
     */
    @Override
    public void onPlayerInteract (PlayerInteractEvent event) {
        //Return if the event was not opening a Chest
        if (event.getMaterial() != Material.CHEST || event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;
        
        if (!MyChunks.canBuild(event.getPlayer(), event.getClickedBlock()))
            event.setCancelled(true);
    }
}
