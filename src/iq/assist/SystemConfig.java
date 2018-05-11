package iq.assist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemConfig {
	private final static String CONFIGFILE = "config.ini";
	private static Properties sets = null;
	
	public static final String SERVERIP = "SERVERIP";
	public static final String SERVERPORT = "SERVERPORT";
	public static final String CLIENTPORT = "CLIENTPORT";
	
	public static String get(String key) throws IOException {
		loadConfig();
		return sets.getProperty(key);
	}
	
	private static void loadConfig() throws IOException {
		if (sets==null) {
			sets = new Properties();
			sets.load(new FileInputStream(CONFIGFILE));
		}
	}
}
