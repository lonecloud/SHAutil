package cn.lonecloud;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import cn.lonecloud.util.SHA256Util;
import cn.lonecloud.util.SHAThread;

/**
 * 测试
 * 
 * @Title: NetWorkDemo.java
 * @Package cn.lonecloud
 * @Description:
 * @author lonecloud
 * @date 2017年1月4日 下午12:02:02
 */
public class NetWorkDemo {
	@Test
	public void SHATest() {
		String sha = null;
		try {
			sha = SHA256Util.getSHA(new File(
					"/Users/lonecloud/Desktop/work/邮箱授权码获取步骤.docx"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sha);
	}

	/**
	 * 测试类
	 * 
	 * @Description:
	 * @throws Exception
	 */
	@Test
	public void CallableTest() throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		SHAThread task = new SHAThread(new File(
				"/Users/lonecloud/Desktop/work/邮箱授权码获取步骤.docx"));
		Future<String> result = executor.submit(task);
		System.out.println(result.get());
	}
}
