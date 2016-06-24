package com.cafe.common.test;

import java.lang.reflect.Method;

import com.cafe.common.log.CafeLogger;

public  abstract class BaseTestImpl implements BaseTest {

	public void init() {
		CafeLogger.log(this.getClass().getName()+":init()");
	}

	public Object preTest() {
		CafeLogger.log(this.getClass().getName()+":preTest()");
		return null;
	}

	public abstract  Object doTest();

	public Object afterTest() {
		CafeLogger.log(this.getClass().getName()+":afterTest()");
		return null;
	}
	
	public void destroy(){
		CafeLogger.log(this.getClass().getName()+":destroy()");
	}
	
	
	public void run(){
		init();
		preTest();
		invokeDoTestMethod();
		afterTest();
		destroy();
	}
	public void invokeDoTestMethod(){
		String classFullName=getClassFullName();
		try {
			Class cla=Class.forName(classFullName);
			Method method=cla.getMethod("doTest");
			method.invoke(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private  String getClassFullName(){
		return this.getClass().getName();
	}
	private String getClassName(){
		return this.getClass().getSimpleName();
	}

}
