package org.smart4j.framework.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropUtil.class);
	
	//加载属性文件
	public static Properties loadProps(String fileName) {
		Properties props = null;
		InputStream is = null;
		try {
			is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if(is==null){
				throw new FileNotFoundException(fileName+"is not found");			
			}
			props = new Properties();
		
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Load properties fail",e);
		} finally {
			if(is !=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					LOGGER.error("close file fail",e);
				}
			}
		}
		return props;
	}
	
	public static String getString(Properties prop,String key){
		return getString(prop, key,"");
	}
	
	public static String getString(Properties prop,String key,String defaultValue){
		String value = defaultValue;
		if(prop.contains(key)){
			value=prop.getProperty(key);
		}
		return value;
	}
	
	public static int getInt(Properties prop,String key){
		return getInt(prop, key,0);
	}
	public static int getInt(Properties prop,String key,int defaultValue){
		int value = defaultValue;
		if(prop.contains(key)){
			value = CastUtil.castInt(prop.getProperty(key));
		}
		return value;
	}
	
	public static boolean getBoolean(Properties prop,String key){
		return getBoolean(prop, key,false);
	}
	
	public static boolean getBoolean(Properties prop,String key,boolean defalutValue){
		boolean value = defalutValue;
		if(prop.contains(value)){
			value = CastUtil.castBoolean(prop.getProperty(key));
		}
		return value;
		
	}
	
}
