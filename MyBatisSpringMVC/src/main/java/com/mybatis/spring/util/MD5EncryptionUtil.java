package com.mybatis.spring.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类,返回16位的MD5字符
 * 
 * @description 1.获取digest字段 2.将获取的pwd文件转化为bytes格式，用digest
 *              3.创建StringBuffer存储字符串4.关键方法遍历for (byte b : result) { int number
 *              = b & 0xff; String str = Integer.toHexString(number); if
 *              (str.length() == 1) { buffer.append("0"); } buffer.append(str);
 *              }
 */
public class MD5EncryptionUtil {
	public String stringToMD5Code(String pwd) {
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(pwd.getBytes());
			StringBuffer buffer = new StringBuffer();
			for (byte b : result) {
				int number = b & 0xff;
				String str = Integer.toHexString(number);
				if (str.length() == 1) {
					buffer.append("0");
				}
				buffer.append(str);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
