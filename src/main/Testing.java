package main;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.milkbowl.vault.economy.Economy;


public class Testing extends JavaPlugin {
    
    public static void main(String[] args){
        
    }
    @Override
        public void onEnable() {
            
            getLogger().info("Hello World");
            getLogger().info("Plugin Enabled");
            
        }

    @Override
        public void onDisable() {
            
            getLogger().info("ZorgProduction disabled");
            
        }
    
        public Player player;
        
        public boolean Command(CommandSender interpreter, Command cmd, String input, String[] args){
    
            
            if (interpreter instanceof Player) {
            
            player = (Player) interpreter;
            
            
            if (!input.equalsIgnoreCase(input)){    input = input.toLowerCase();    }
            
            
            //main command
                if(input.equals("chess")){
                    
                    
                    
                    
                        return true;
                }
                if(input.equals("website")){
                
                    player.sendMessage("https://www.nyxeros.online/");
                
                    return true;
                }
            
        return false;
        
    }
        //functions go here
        return false;
        }
}
