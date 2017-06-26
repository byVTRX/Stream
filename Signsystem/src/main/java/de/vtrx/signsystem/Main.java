package de.vtrx.signsystem;

import de.vtrx.signsystem.listener.Interact;
import de.vtrx.signsystem.listener.PluginMessage;
import de.vtrx.signsystem.listener.SingPlace;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by thatv on 26.06.2017.
 */
public class Main extends JavaPlugin {


    @Override
    public void onEnable() {

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage());

        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new SingPlace(), this);

        System.out.println("[SignSystem] loadet!");
    }


    @Override
    public void onDisable() {


        System.out.println("{SignSystem] unloadet!");
    }
}
