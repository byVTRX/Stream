package de.vtrx.signsystem.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by thatv on 26.06.2017.
 */
public class Interact implements Listener{



    @EventHandler
    public void onKlick(PlayerInteractEvent e){
        if(e.getClickedBlock().getType() == Material.SIGN) {
            Sign s = (Sign) e.getClickedBlock();
            String server = s.getLine(2);
            Player p = e.getPlayer();

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);

            try {
                out.writeUTF("connect");
                out.writeUTF(p.getName());
                out.writeUTF(server);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

}
