package de.vtrx.signsystem.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.List;

/**
 * Created by thatv on 26.06.2017.
 */
public class PluginMessage implements org.bukkit.plugin.messaging.PluginMessageListener {

    public static String[] serverlist;

    public void onPluginMessageReceived(String channel, Player p, byte[] message) {
        if(!channel.equals("BungeeCord")){
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if(subchannel.equals("GetServers")){
            serverlist = in.readUTF().split(", ");
        }


    }
}
