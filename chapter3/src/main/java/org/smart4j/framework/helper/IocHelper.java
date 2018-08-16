package org.smart4j.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

public class IocHelper {
	static{
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(CollectionUtil.isNotEmpty(beanMap)){
			for(Map.Entry<Class<?>, Object> beanEntry :beanMap.entrySet()){
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				
				Field[] beanFields = beanClass.getDeclaredFields();
				if(ArrayUtil.isNotEmpty(beanFields)){
					for(Field beanField:beanFields){
						if(beanField.isAnnotationPresent(Inject.class)){
							System.out.println("DI 引用对象:"+beanField.getName());
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance != null){
								System.out.println("为类对象:【"+beanInstance + "】 注入对象：" + beanFieldInstance);
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}

}
