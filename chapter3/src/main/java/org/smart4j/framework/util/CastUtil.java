package org.smart4j.framework.util;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.mysql.jdbc.StringUtils;

public class CastUtil {
	
	public static String castString(Object obj){
		return castString(obj,"");
	}
	
	public static String castString(Object obj,String defaultValue){
		return obj!=null?String.valueOf(obj):defaultValue; 
	}
	
	public static double castDouble(Object obj){
		return castDouble(obj,0.0);
	}
	
	public static double castDouble(Object obj,double defaultValue){
		Double value = defaultValue;
		if(obj!=null){
			String temp = castString(obj);
			try{
				value = Double.parseDouble(temp);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				value=defaultValue;
			}
			
		}
		return value;
	}
	
	public static long castLong(Object obj){
		return castLong(obj,0l);
	}
	
	public static long castLong(Object obj,long defaultValue){
		Long value = defaultValue;
		if(obj!=null){
			String temp = castString(obj);
			try{
				value = Long.parseLong(temp);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				value = defaultValue;
			}
		}
		return value ;
	}
	
	public static int castInt(Object obj){
		return castInt(obj,0);
	}
	
	public static int castInt(Object obj,int defaultValue){
		int value = defaultValue;
		if(obj!=null){
			String temp = castString(obj);
			try{
				value = Integer.parseInt(temp);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				value = defaultValue;
			}
		}
		return value;
	}
	
	public static boolean castBoolean(Object obj){
		return castBoolean(obj,false);
	}
	
	public static boolean castBoolean(Object obj,boolean defaultValue){
		boolean value = defaultValue;
		if(obj!=null){
			String temp = castString(obj);
			try{
				value= Boolean.parseBoolean(temp);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				value = defaultValue;
			}
		}
		return value;
	}
	
	

}
