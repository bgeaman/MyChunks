package net.betterverse.mychunks.listeners;

import net.betterverse.mychunks.MyChunks;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.SignChangeEvent;

public class BlockEventListener extends BlockListener {
    
    /**
     * Blocks within an OwnedChunk can only be broken by the owner, a coowner, or an admin
     * 
     * @param event The BlockBreakEvent that occurred
     */
    @Override
    public void onBlockBreak (BlockBreakEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }

    /**
     * Blocks within an OwnedChunk can only be damaged by the owner, a coowner, or an admin
     * 
     * @param event The BlockDamageEvent that occurred
     */
    @Override
    public void onBlockDamage (BlockDamageEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }

    /**
     * Blocks within an OwnedChunk can only be ignited by the owner, a coowner, or an admin
     * 
     * @param event The BlockIgniteEvent that occurred
     */
    @Override
    public void onBlockIgnite (BlockIgniteEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }

    /**
     * Blocks can only be placed within an OwnedChunk by the owner, a coowner, or an admin
     * 
     * @param event The BlockPlaceEvent that occurred
     */
    @Override
    public void onBlockPlace (BlockPlaceEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }

    /**
     * Blocks within an OwnedChunk cannot be spread
     * 
     * @param event The BlockSpreadEvent that occurred
     */
    @Override
    public void onBlockSpread (BlockSpreadEvent event) {
        if (!MyChunks.canBuild(null, event.getBlock()))
            event.setCancelled(true);
    }

    /**
     * Signs within an OwnedChunk can only be changed by the owner, a coowner, or an admin
     * 
     * @param event The SignChangeEvent that occurred
     */
    @Override
    public void onSignChange (SignChangeEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }
}
