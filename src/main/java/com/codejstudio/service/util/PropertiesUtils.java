package com.codejstudio.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件工具类
 * @author Marco
 *
 */
public class PropertiesUtils {

	public static String getValue(String key){
		Properties prop = new Properties();
		InputStream in = PropertiesUtils.class.getResourceAsStream("/msg.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String)prop.get(key);
	}
	
	public static Properties getInstence(String fileName){
		Properties prop = new Properties();
		InputStream in = PropertiesUtils.class.getResourceAsStream(fileName);
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}
