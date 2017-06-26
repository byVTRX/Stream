package de.vtrx.signsystem.listener;


import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by thatv on 26.06.2017.
 */
public class SingPlace implements Listener{


    @EventHandler
    public void onSignPlace(SignChangeEvent e){

        String Line1 = e.getLine(1);
        String Line2 = e.getLine(2);
        if(Line1.equalsIgnoreCase("[SignSystem]") && Line2 != null){

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);

            try {
                out.writeUTF("GetServers");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            int i = 0;

            for(i = 0; i < PluginMessage.serverlist.length; i++){
                if(PluginMessage.serverlist[i].equals(Line2)){
                    break;
                }
            }

            if(i == 0) {

                e.setLine(1, "§c----------------");
                e.setLine(2, "§7" + Line2);
                e.setLine(3, "§cOffline");
                e.setLine(4, "§c----------------");
            } else {
                e.setLine(1, "§a----------------");
                e.setLine(2, "§a" + Line2);
                e.setLine(3, "§aJoin");
                e.setLine(4, "§a----------------");
            }
        }




    }
}
