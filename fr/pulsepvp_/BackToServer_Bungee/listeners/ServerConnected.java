package pulsepvp_.BackToServer_Bungee.listeners;

import java.sql.SQLException;

import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import pulsepvp_.BackToServer_Bungee.BackToServer_Bungee;
import pulsepvp_.BackToServer_Bungee.utils.Functions;

public class ServerConnected implements Listener {

	@EventHandler
	public void onServerConnect(ServerDisconnectEvent event) {
		try {
			if (!event.getTarget().getName().equalsIgnoreCase(BackToServer_Bungee.AuthServer))
				Functions.setLastServer(event.getPlayer().getName(), event.getTarget().getName());
		} catch (SQLException e) {
		}
	}
}