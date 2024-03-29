package net.betterverse.mychunks;

import java.util.LinkedList;
import org.bukkit.entity.Player;

public class OwnedChunk {
    public String world;
    public int x;
    public int z;
    public String owner;
    public LinkedList<String> coOwners = new LinkedList<String>();
    public LinkedList<String> groups = new LinkedList<String>();

    /**
     * Constructs a new OwnedChunk
     * 
     * @param x The x-coordinate of the Chunk
     * @param z The z-coordinate of the Chunk
     * @param owner The name of the owner of the Chunk
     */
    public OwnedChunk(String world, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    /**
     * Returns whether the given player is a CoOwner
     * CoOwner includes being in a group that has CoOwnership
     * 
     * @param player The Player to be check for CoOwnership
     * @return true if the given player is a CoOwner
     */
    public boolean isCoOwner(Player player) {
        //Check to see if the Player is a CoOwner
        for (String coOwner: coOwners)
            if (coOwner.equalsIgnoreCase(player.getName()))
                return true;

        //Return true if the Player is in a group that has CoOwnerShip
        for (String group: groups)
            if (MyChunks.permission.playerInGroup(player, group))
                return true;
        
        //Return false because the Player is not a coowner
        return false;
    }
}
