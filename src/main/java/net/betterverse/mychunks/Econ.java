package net.betterverse.mychunks;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

public class Econ {
    public static Economy economy;
    public static double buyPrice;
    public static double sellPrice;
    static String insufficientFundsMsg;
    static String buyMsg;
    static String sellMsg;
    static String adminSellMsg;
    static String adminSoldMsg;

    /**
     * Charges a Player a given amount of money, which goes to a Player/Bank
     * 
     * @param player The name of the Player to be charged
     * @param source The Player/Bank that will receive the money
     * @param amount The amount that will be charged
     * @return True if the transaction was successful
     */
    public static boolean buy(Player player) {
        String name = player.getName();
        
        if (economy != null) {
            //Cancel if the Player cannot afford the transaction
            if (!economy.has(name, buyPrice)) {
                player.sendMessage(insufficientFundsMsg.replaceAll("<price>", economy.format(buyPrice)));
                return false;
            }

            economy.withdrawPlayer(name, buyPrice);
        }
        
        player.sendMessage(buyMsg.replaceAll("<price>", economy.format(buyPrice)));
        return true;
    }
    
    /**
     * Adds the sellPrice to the Player's total balance
     * 
     * @param player The Player who is selling
     */
    public static void sell(Player player) {
        if (economy != null)
            economy.depositPlayer(player.getName(), sellPrice);
        player.sendMessage(sellMsg.replaceAll("<price>", economy.format(sellPrice)));
    }
    
    /**
     * Forces the Player to sell their land
     * 
     * @param admin The Player who is forcing the sale
     * @param seller The Player who is being forced to sell
     */
    public static void sell(Player admin, String owner) {
        if (economy != null)
            economy.depositPlayer(owner, sellPrice);

        //Notify the Seller
        Player seller = MyChunks.server.getPlayer(owner);
        if (seller != null)
            seller.sendMessage(adminSoldMsg.replaceAll("<price>", economy.format(sellPrice)));
        
        admin.sendMessage(adminSellMsg.replaceAll("<price>", economy.format(sellPrice)));
    }
    
    /**
     * Formats the money amount by adding the unit
     * 
     * @param amount The amount of money to be formatted
     * @return The String of the amount + currency name
     */
    public static String format(double amount) {
        if (economy == null)
            return "nothing";
        
        return economy.format(amount).replace(".00", "");
    }
}
