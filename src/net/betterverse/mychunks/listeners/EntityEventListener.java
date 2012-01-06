package net.betterverse.mychunks.listeners;

import net.betterverse.mychunks.MyChunks;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.painting.PaintingPlaceEvent;

public class EntityEventListener extends EntityListener {

    /**
     * Paintings can only be placed within an OwnedChunk by the owner, a coowner, or an admin
     * 
     * @param event The PaintingPlaceEvent that occurred
     */
    @Override
    public void onPaintingPlace (PaintingPlaceEvent event) {
        if (!MyChunks.canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }
}