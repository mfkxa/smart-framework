package com.zhouh.test;

import java.util.stream.Stream;

public class ClassLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   System.out.println(Thread.currentThread().getContextClassLoader());
	   System.out.println(Thread.currentThread().getContextClassLoader().getParent());
	   System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());
	}

}
