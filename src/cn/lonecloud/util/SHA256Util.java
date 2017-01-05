package cn.lonecloud.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;
/**
 * 获取散列码的Util
 * @Title: SHA256Util.java
 * @Package cn.lonecloud.util
 * @Description: 
 * @author lonecloud
 * @date 2017年1月4日 下午4:51:11
 */
public class SHA256Util {

	/**
	 * 获取散列码
	 * 
	 * @Description:
	 * @param file 目标文件
	 * @return
	 * @throws Exception
	 */
	public static String getSHA(final File file) throws Exception {
		final StringBuilder sb = new StringBuilder();
		InputStream in = null;
		MessageDigest sha = null;
		DigestInputStream din = null;
		byte[] digest = null;
		try {
			in = new FileInputStream(file);
			sha = MessageDigest.getInstance("SHA-256");
			din = new DigestInputStream(in, sha);
			while (din.read() != -1)
				;
			digest = sha.digest();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (din != null) {
				try {
					din.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		sb.append(DatatypeConverter.printHexBinary(digest));
		return sb.toString();
	}
}
