package pulsepvp_.BackToServer.utils;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import pulsepvp_.BackToServer.BackToServer;

public class Functions {
	public static boolean isAuth(ProxiedPlayer player) {
        return BackToServer.getAuthPlayerManagerInstance().getAuthPlayer(player).isLogged();
	}
    public static ServerInfo getLastServer(ProxiedPlayer player) {
    	if(BackToServer.last_server.containsKey(player)) return BackToServer.last_server.get(player);
    	else return null;
    }
}