package pulsepvp_.BackToServer_Bungee.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import com.google.common.io.ByteStreams;

import net.md_5.bungee.api.plugin.Plugin;
import pulsepvp_.BackToServer_Bungee.BackToServer_Bungee;

public class Functions {
	public static void setLastServer(String player_name, String last_server_name) throws SQLException {
		BackToServer_Bungee.database
				.ExecuteCommand("REPLACE INTO players VALUES ('" + player_name + "', '" + last_server_name + "')");
	}

	public static File loadResource(Plugin plugin, String resource) {
		File folder = plugin.getDataFolder();
		if (!folder.exists())
			folder.mkdir();
		File resourceFile = new File(folder, resource);
		try {
			if (!resourceFile.exists()) {
				resourceFile.createNewFile();
				try (InputStream in = plugin.getResourceAsStream(resource);
						OutputStream out = new FileOutputStream(resourceFile)) {
					ByteStreams.copy(in, out);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resourceFile;
	}

}