package com.cafe.zookeeper.example;

import java.util.Collection;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

import com.cafe.common.test.BaseCrudTestImpl;
import com.cafe.common.test.BaseTestImpl;

public class Test extends BaseCrudTestImpl {

	public static String path="/cafe-data";
	public CuratorFramework client=null;
	
	public static void main(String[] args) {
		Test test=new Test();
		test.run();
	}
	
	@Override
	public void init(){
		super.init();
		Builder builder=CuratorFrameworkFactory.builder();
		client = builder.connectString("192.168.137.222:2181")  
		        .sessionTimeoutMs(30000)  
		        .connectionTimeoutMs(30000)  
		        .canBeReadOnly(false)  
		        .retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))  
		        .namespace("lsb-cafe")  
		        .defaultData(null)  
		        .build();  
		client.start();
	}

	

	@Override
	public void testInsert() {
		super.testInsert();
		try {
			client.create().forPath(path,"i love cafe".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void testDelete() {
		super.testDelete();
		try {
			client.delete().forPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void testUpdate() {
		super.testUpdate();
		Stat stat;
		try {
			stat = client.checkExists().forPath(path);
			if(stat!=null){
				client.setData().forPath(path,"cafe love me".getBytes());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void testGet() {
		super.testGet();
		try {
			byte[] bytes=client.getData().forPath(path);
			System.out.println(new String(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy(){
		CloseableUtils.closeQuietly(client);
	}
	
	
	public  void testTransaction() {
		
		try {
		
		    
			CuratorTransaction transaction = client.inTransaction();  
			  
            Collection<CuratorTransactionResult> results = transaction.create()  
                    .forPath("/a/path", "some data".getBytes()).and().setData()  
                    .forPath("/another/path", "other data".getBytes()).and().delete().forPath("/yet/another/path")  
                    .and().commit();  
  
            for (CuratorTransactionResult result : results) {  
                System.out.println(result.getForPath() + " - " + result.getType());  
            }  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
