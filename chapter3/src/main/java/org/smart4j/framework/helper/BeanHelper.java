package org.smart4j.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.framework.util.ReflectionUtil;

public class BeanHelper {
	private static final Map<Class<?>, Object> Bean_MAP = new HashMap<Class<?>, Object>();
	
	static{
		Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
		for(Class<?> cls:classSet){
			Object newInstance;
			newInstance = ReflectionUtil.newInstance(cls);
			Bean_MAP.put(cls, newInstance);
		}
	}

	//获取bean映射
	public static Map<Class<?>, Object> getBeanMap(){
		return Bean_MAP;
	}
	
	//获取bean实例
	public static <T> T getBean(Class<T> cls){
		if(!Bean_MAP.containsKey(cls)){
			throw new RuntimeException("cann't get bean by class:"+cls);
		}
		return (T)Bean_MAP.get(cls);
	}
	
	
	

	
}
