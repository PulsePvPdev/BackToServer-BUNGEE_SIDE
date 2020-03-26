package pulsepvp_.BackToServer_Bungee;

import java.io.IOException;
import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import pulsepvp_.BackToServer_Bungee.listeners.ServerConnected;
import pulsepvp_.BackToServer_Bungee.utils.Functions;
import pulsepvp_.BackToServer_Bungee.utils.MySQL;

public class BackToServer_Bungee extends Plugin {
	private static BackToServer_Bungee instance;
	public static HashMap<String, String> last_server = new HashMap<String, String>();
	public static HashMap<String, Integer> points = new HashMap<String, Integer>();
	public static Configuration configuration;
	public static String AuthServer;
	public static MySQL database;
	public static String console_prefix = "" + ChatColor.GOLD + ChatColor.BOLD + "[" + ChatColor.RESET
			+ ChatColor.YELLOW + "BackToServer - Bungee" + ChatColor.BOLD + ChatColor.GOLD + "]" + " ";

	@Override
	public void onEnable() {
		try {
			configuration = ConfigurationProvider.getProvider(YamlConfiguration.class)
					.load(Functions.loadResource(this, "config.yml"));
			database = new MySQL(configuration.getString("host"), configuration.getString("database"),
					configuration.getString("username"), configuration.getString("password"));
			AuthServer = configuration.getString("auth_server");

		} catch (IOException e) {
			e.printStackTrace();
		}
		database.Connect();
		Functions.initDB();
		instance = this;
		getProxy().getPluginManager().registerListener(this, new ServerConnected());
		getLogger().info("[BackToServer - Bungee] Successfully enabled !");

	}

	@Override
	public void onDisable() {
		database.Disconnect();
		getLogger().info("[BackToServer - Bungee] Disabled...");
	}

	public static BackToServer_Bungee getInstance() {
		return instance;
	}
}
