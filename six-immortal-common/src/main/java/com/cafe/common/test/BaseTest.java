package com.cafe.common.test;

public interface BaseTest {
	public void init();
	public Object preTest();
	public Object doTest();
	public Object afterTest();
	public void destroy();
}
