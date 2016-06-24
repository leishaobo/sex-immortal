package com.cafe.common.test;

import com.cafe.common.log.CafeLogger;

public class BaseCrudTestImpl extends BaseTestImpl implements BaseCrudTest
{

	@Override
	public Object doTest() {
		CafeLogger.log(this.getClass().getName()+":doTest()");
		testInsert();
		testGet();
		testUpdate();
		testGet();
		testDelete();
		return null;
	}

	public void testInsert() {
		CafeLogger.log(this.getClass().getName()+":testInsert()");
		
	}

	public void testDelete() {
		CafeLogger.log(this.getClass().getName()+":testDelete()");
	}

	public void testUpdate() {
		CafeLogger.log(this.getClass().getName()+":testUpdate()");
	}

	public void testGet() {
		CafeLogger.log(this.getClass().getName()+":testGet()");
	}

}
