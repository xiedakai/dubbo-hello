package com.emep.dubbo.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件application.properties
 * @author zxd
 *
 */
public class ConfigManager {
	private static Properties properties; 
	static{
		String configFile="application.properties";
		properties=new Properties();
		InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static  String getString(String key){
		return properties.getProperty(key);
	}
}
