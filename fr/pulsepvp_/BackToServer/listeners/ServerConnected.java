package pulsepvp_.BackToServer.listeners;

import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import pulsepvp_.BackToServer.BackToServer;

public class ServerConnected implements Listener {

	@net.md_5.bungee.event.EventHandler
	public void onServerConnect(ServerConnectedEvent event) {
		BackToServer.last_server.put(event.getPlayer(), event.getServer().getInfo());
	}
}