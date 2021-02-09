package main;

// ZorgProduction is a Plugin by Bchru

import java.util.logging.Logger;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import static org.bukkit.potion.PotionEffectType.NIGHT_VISION;
import main.Testing;

public class ZorgProduction extends JavaPlugin {
    
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    
    Player player;
    EconomyResponse r;
    
    
    public static void main(String[] args){
        
        
    }
    
    @Override
        public void onEnable() {
            
            getLogger().info("Hello World");
            getLogger().info("Plugin Enabled");
            
            if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
        }
        
    }

    @Override
        public void onDisable() {
            
            getLogger().info("ZorgProduction disabled");
            
        }
    
        
    int uses = 0;
    @Override
        public boolean onCommand(CommandSender interpreter, Command cmd, String input, String[] args){
            
            player = (Player) interpreter;
            
            //Loading Commands Class Function
            //
            
            
            //By Bchru
            if (!input.equalsIgnoreCase(input)){
                
                input = input.toLowerCase();
                
            }
            //By Bchru
            
            
            if (interpreter instanceof Player) {
                  
                   r = econ.withdrawPlayer(player, 30);
                if(input.equals("praytoanemo")){
                    
                    player.sendMessage("Praying to the wind of the east");
                    callanemo();
                   if(r.transactionSuccess()) {
                        
                        player.sendMessage("You offered 30 Mora to the Gods");
                        player.sendMessage(String.format("Personal Mora: %s ", econ.format(r.balance)));
                    }
                    uses++;
                    return true;
                }
                if(input.equals("praytogeo")){
                    
                    player.sendMessage("Praying to the Highest Mountains");
                    callgeo();
                   if(r.transactionSuccess()) {
                        
                        player.sendMessage("You offered 30 Mora to the Gods");
                        player.sendMessage(String.format("Personal Mora: %s ", econ.format(r.balance)));
                    }
                    uses++;
                    return true;
                }
                if(input.equals("praytomäx")){
                    
                    player.sendMessage("Praying to the holy Cats");
                    callnifalis();
                   if(r.transactionSuccess()) {
                        
                        player.sendMessage("You offered 30 Mora to the Gods");
                        player.sendMessage(String.format("Your Mora: %s ", econ.format(r.balance)));
                    }
                    uses++;
                    return true;
                }
                if(input.equals("praytocheeseburgers")){
                    
                    player.sendMessage("Praying to Cheeseburgers");
                    callcheeseburgers();
                   if(r.transactionSuccess()) {
                        
                        player.sendMessage("You offered 30 Mora to the Gods and recieved the blessing of the Cheeseburgers");
                        player.sendMessage(String.format("Personal Mora: %s ", econ.format(r.balance)));
                    }
                    uses++;
                    return true;
                }
                if(input.equals("Invest")){
                    
                    player.sendMessage("Praying to Cheeseburgers");
                    callcheeseburgers();
                   if(r.transactionSuccess()) {
                        
                        player.sendMessage("You offered 30 Mora to the Gods and recieved the blessing of the Cheeseburgers");
                        player.sendMessage(String.format("Personal Mora: %s ", econ.format(r.balance)));
                    }
                    uses++;
                    return true;
                }
                
                if(input.equals("cateyes")){
                    
                        cateyes();
                    uses++;
                    return true;
                }
                if(input.equals("cateyesoff")){
                        
                    cateyesoff();
                    uses++;
                    return true;
                }
                
                if(input.equals("uses")){
                    
                    player.sendMessage("Commands used: " + uses);
                    
                }
                
                //Examples -------------------
                if(input.equals("test-economy")) {
                
                    player.sendMessage(String.format("You have %s", econ.format(econ.getBalance(player.getName()))));
                    r = econ.depositPlayer(player, 1.05);//r.transactionSuccess runs the deposit
                    if(r.transactionSuccess()) {
                        player.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
                    } else {
                        callError(player, r);
                    }
                    player.sendMessage(("Now you have %s") + String.format(econ.format(r.balance)));
                    return true;
                  //r = econ.depositPlayer(player, 1337);
                  //r = econ.withdrawPlayer(player, 1048);
                }
                
                //Examples ------------------
                
                if(input.equals("pray")){
                    player.sendMessage("Pray to one of the 4 gods. /praytoanemo /praytogeo /praytomäx /praytocheesburgers. It costs 30 Mora");
                    return true;
                }
                
                
                
               //main command
               ///Alle 30 Minuten 2 Mora
               ///Schachbrett --> Pawns are 5x5 blocks, field size 6x6
                if(input.equals("azure")){
                    
                        player.sendMessage("Azure likes cookies");
                        player.sendMessage("Bchru likes cookies too");
                        player.setHealth(16);
                        return true;
                 }
                
                
                if(input.equals("website")){
                
                    player.sendMessage("https://www.nyxeros.online/");
                
                    return true;
                }
                if(input.equals("getdollars")) {
                // Lets give the player 1.05 currency (note that SOME economic plugins require rounding!)
                player.sendMessage(String.format("You have %s", econ.format(econ.getBalance(player.getName()))));
                player.sendMessage("------------------------------------");
                EconomyResponse r = econ.depositPlayer(player,Integer.valueOf(args[0]));
                
                if(r.transactionSuccess()) {
                    player.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
                } else {
                    player.sendMessage(String.format("An error occured: %s", r.errorMessage));
                }

                player.sendMessage(("Now you have %s") + String.format(econ.format(r.balance)));
                
                
                return true;
            }
            
            return false;
        } else{
            // interpreter is console
            interpreter.sendMessage("Hey Console");
            return true;
             
        }
    }
        
    private boolean setupEconomy() {
            if (null == getServer().getPluginManager().getPlugin("Vault")) {
                return false;
            }
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                return false;
            }
            econ = rsp.getProvider();
            return econ != null;
        }
        
    public static Economy getEconomy() {
        return econ;
    }  
    public static void callError(Player player,EconomyResponse r){
        player.sendMessage(String.format("An error occured: %s", r.errorMessage));
    }
    
    
        //functions \\\\\\\\\\\//////////
    
        public void cateyes(){
            
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 6000, 1));;
                            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 300, 1));;
                            
        }
        public void cateyesoff(){
            
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    player.removePotionEffect(PotionEffectType.GLOWING);
                
        }
        public void callanemo(){
            
            //give beacon effect Speed 2
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 1));
                
        }
        public void callgeo(){
            
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 18000, 1));
        }
        public void callnifalis(){
            
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 18000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 18000, 1));
        }
        public void callcheeseburgers(){
            
                player.setFoodLevel(19);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 300, 1));
        }
       
}

                
        /* Never do that //
        while(true){}
        // Never do that */


                /*
                EconomyResponse[] a = new EconomyResponse[6];
                a[0] = econ.depositPlayer(player, 1.05);
                a[1] = econ.depositPlayer(player, 1.05);
                a[2] = econ.withdrawPlayer(player, 1048);;
                a[3] = econ.depositPlayer(player, 1.05);
                a[4] = econ.depositPlayer(player, 1.05);
                a[5] = econ.withdrawPlayer(player, 1048);;
                player.sendMessage(String.format(("You got %s"), econ.format(r.balance)));
                int i = 0;
                
                while(i<= 5);{
                a[i].transactionSuccess();
                }*/

