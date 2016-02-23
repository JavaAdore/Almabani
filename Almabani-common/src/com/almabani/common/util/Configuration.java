package com.almabani.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public final static String CONFIGURATION_FOLDER_PATH ="config/";
	public final static String CONFIGURATION_FILE_NAME = "configurations.properties";
	private static Properties properties = null;
	private static final String SERVER_GMT_TIME_DEFF = "SERVER_GMT_TIME_DEFF";
	
	public final static Integer serverGMT ; 
	static {

		try {
			properties = new Properties();
			properties.load(Configuration.class.getClassLoader().getResourceAsStream("../"+CONFIGURATION_FOLDER_PATH+CONFIGURATION_FILE_NAME));
		} catch(Exception e){
			e.printStackTrace();
			properties = null;
		} finally {
			if (properties == null) {
				throw new RuntimeException("NOT ABLE TO LOAD CONFI FILE");
			}
		}
		serverGMT = loadServerGMTTimeZone();

	}
	
	
	
	public static Integer getServerGMTTimeZone()
	{
		return serverGMT;  
	}



	private static Integer loadServerGMTTimeZone() {
		String deff = properties.getProperty(SERVER_GMT_TIME_DEFF, "0");
		return Integer.parseInt(deff);
	}

}

