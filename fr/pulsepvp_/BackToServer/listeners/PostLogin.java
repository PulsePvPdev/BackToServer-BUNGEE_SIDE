package pulsepvp_.BackToServer.listeners;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import pulsepvp_.BackToServer.BackToServer;
import pulsepvp_.BackToServer.utils.Functions;

public class PostLogin implements Listener {
	@net.md_5.bungee.event.EventHandler
	public void onLogin(PostLoginEvent event) {
		ProxiedPlayer player = event.getPlayer();
		if(BackToServer.getAuthPlayerManagerInstance().getAuthPlayer(player).isLogged() && Functions.getLastServer(player) != null) {
			player.connect(Functions.getLastServer(player));
		}
	}
}
