package main;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.milkbowl.vault.economy.Economy;


public class Memories_I extends JavaPlugin {
    
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
            
            
            if (!input.equalsIgnoreCase(input)){
                
                input = input.toLowerCase();
                
            }
            
            
            //main command
                if(input.equals("azure")){
                    
                        player.sendMessage("Azure likes cookies");
                        player.sendMessage("Bchru likes cookies too");
                        player.setHealth(16);
                        if(player.getFoodLevel()<9) {
                            player.setFoodLevel(16);
                        
                        }
                    
                        return true;
                    
                    
                }
                if(input.equals("website")){
                
                    player.sendMessage("https://www.nyxeros.online/");
                
                    return true;
                }
                if(input.equals("magic")){
                    
                    player.sendMessage("arg[0]: " + args[0]);
                    
                    if(args[0].equals("cateyes")){
                        cateyes();
                    }
                    if(args[0].equals("cateyesoff")){
                        cateyesoff();
                    }
                    
                    return true;
                }
        } else {
            // interpreter is console
            interpreter.sendMessage("Hey Console");
            return true;
                    }
            
        return false;
        
    }
        //function cateyes
        public void cateyes(){
                        PotionEffect effect;
                        effect = (new PotionEffect(PotionEffectType.NIGHT_VISION, 6000, 1));
                            player.addPotionEffect(effect);
                        effect = (new PotionEffect(PotionEffectType.GLOWING, 300, 1));
                            player.addPotionEffect(effect);
                   /*
                    while(addeffectpointer<20){
                        player.addPotionEffect(effect[addeffectpointer]);
                        addeffectpointer++;
                    }
                    */
        }
        public void cateyesoff(){
            
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    player.removePotionEffect(PotionEffectType.GLOWING);
                
        }
}
