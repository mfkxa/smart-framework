package org.smart4j.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
	
	//创建实例
	public static Object newInstance(Class<?> cls){
		Object instance = null;
		try {
			instance = cls.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}
	
	//调用方法
	public static Object invokeMethod(Object obj,Method method,Object...args){
		Object result = null;
		method.setAccessible(true);
		try {
			result = method.invoke(obj, args);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("invoke method fail",e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	//设置成员变量的值
	public static void setField(Object obj,Field field,Object value){
		field.setAccessible(true);
		try {
			field.set(field, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("setField fail",e);
			throw new RuntimeException(e);
		}
	}
}
