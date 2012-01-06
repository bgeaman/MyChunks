package net.betterverse.mychunks.listeners;

import net.betterverse.mychunks.MyChunks;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleListener;

public class VehicleEventListener extends VehicleListener {

    /**
     * Vehicles within an OwnedChunk can only be damaged by the owner, a coowner, or an admin
     * 
     * @param event The VehicleDamageEvent that occurred
     */
    @Override
    public void onVehicleDamage (VehicleDamageEvent event) {
        Player player = null;
        Entity entity = event.getAttacker();
        if (entity instanceof Player)
            player = (Player)entity;
        
        if (!MyChunks.canBuild(player, event.getVehicle().getLocation().getBlock()))
            event.setCancelled(true);
    }

    /**
     * Vehicles within an OwnedChunk can only be destroyed by the owner, a coowner, or an admin
     * 
     * @param event The VehicleDestroyEvent that occurred
     */
    @Override
    public void onVehicleDestroy (VehicleDestroyEvent event) {
        Player player = null;
        Entity entity = event.getAttacker();
        if (entity instanceof Player)
            player = (Player)entity;
        
        if (!MyChunks.canBuild(player, event.getVehicle().getLocation().getBlock()))
            event.setCancelled(true);
    }
}