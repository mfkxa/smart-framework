package org.smart4j.framework;

import java.util.Properties;

import org.smart4j.framework.util.PropUtil;

public final class ConfigHelper {
	private static final Properties CONFIG_PROPS=PropUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	public static String getJdbcDriver(){
		return PropUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
	}
	
	public static String getJdbcUrl(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	
	public static String getJdbcUsername(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	
	public static String getJdbcPassword(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	
	public static String getAppBasePackage(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	public static String getAppJspPath(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
	}
	
	public static String getAppAssetPath(){
		return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
	}
}
