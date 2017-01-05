package cn.lonecloud.util;

import java.io.File;
import java.util.concurrent.Callable;
/**
 * 散列码的线程类
 * @Title: SHAThread.java
 * @Package cn.lonecloud.util
 * @Description: 
 * @author lonecloud
 * @date 2017年1月5日 上午9:29:27
 */
public class SHAThread implements Callable<String> {

	public SHAThread(File file) {
		super();
		this.file = file;
	}

	private String sha;
	private File file;

	@Override
	public String call() throws Exception {
		sha=SHA256Util.getSHA(file);
		return sha;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

}
