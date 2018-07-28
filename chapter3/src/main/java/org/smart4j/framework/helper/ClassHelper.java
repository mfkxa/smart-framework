package org.smart4j.framework.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.smart4j.framework.ConfigHelper;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

public class ClassHelper {
	private static final Set<Class<?>> CLASS_SET;
	
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET=ClassUtil.getClassSet(basePackage);
	}
	
	//��ȡӦ�ð����µ�������
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	//��ȡӦ�ð���������service��
	public static Set<Class<?>> getServecieClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Service.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	//��ȡ����������controller��
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Controller.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	//��ȡ����������bean��
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServecieClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
}