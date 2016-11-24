package com.codejstudio.common;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceHelper {
	private static Logger log = LoggerFactory.getLogger(ResourceHelper.class);
	
	public static String get(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = ResourceHelper.class.getResourceAsStream(filePath);
			props.load(in);
			String value = props.getProperty(key); 
			return value;
		} catch (Exception e) {
			log.error("error when get from resource ");
			if (log.isInfoEnabled()){
				e.printStackTrace();
			}
			return null;
		}
	}
 
	public static Map<String,String> list(String filePath) {
//		log.info("filePath:{}",filePath);
		
		Properties props = new Properties();
		Map<String,String> rtn = new HashMap<String, String>();
		try {
			InputStream in = ResourceHelper.class.getResourceAsStream(filePath);
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key).trim();
				rtn.put(key, Property);
			}
		} catch (Exception e) {
			log.error("error when list from resource ");
			if (log.isInfoEnabled()){
				e.printStackTrace();
			}
		}
		return rtn;
	}
}
