package pulsepvp_.BackToServer;

import java.lang.reflect.Field;
import java.util.HashMap;

import fr.xephi.authmebungee.AuthMeBungee;
import fr.xephi.authmebungee.services.AuthPlayerManager;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BackToServer extends Plugin{
	private static BackToServer instance;
	private static AuthMeBungee instance_AuthMeBungee;
	public static AuthPlayerManager instance_AuthPlayerManager;
	public static HashMap<ProxiedPlayer, ServerInfo> last_server = new HashMap<ProxiedPlayer, ServerInfo>();
    @Override
    public void onEnable() {
    	instance = this;
    	instance_AuthMeBungee = (AuthMeBungee) getProxy().getPluginManager().getPlugin("AuthMeBungee");
        try{
            Field field = instance_AuthMeBungee.getClass().getDeclaredField("authPlayerManager");
            field.setAccessible(true);
            instance_AuthPlayerManager = (AuthPlayerManager) field.get(instance_AuthMeBungee);
        } catch (Exception e){
            e.printStackTrace();
        }
        getLogger().info("[BackToServer] Successfully enabled !");
        
    }
    @Override
    public void onDisable() {
    	getLogger().info("[BackToServer] Disabled...");
    }
    public static AuthPlayerManager getAuthPlayerManagerInstance() {
    	return instance_AuthPlayerManager;
    }
    public static BackToServer getInstance() {
    	return instance;
    }
    public static AuthMeBungee getAuthMeBungeeInstance() {
    	return instance_AuthMeBungee;
    }
}
