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
	
	//获取应用包名下的所有类
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	//获取应用包名下所有service类
	public static Set<Class<?>> getServecieClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Service.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	//获取包名下所有controller类
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Controller.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	//获取包名下所有bean类
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServecieClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	
	//获取应用包名下某父类（或接口）的所有子类（或实现类）
	public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(superClass.isAssignableFrom(cls)&&superClass.equals(cls)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	//获取应用包名下带有某注解的所有类
	public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(annotationClass)){
				classSet.add(cls);
			}				
		}
		return classSet;
	}
}
