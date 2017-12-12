package com.mybatis.spring.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @description 发起Post请求，返回Json数据
 * @author 徐海
 *
 */
public class PostRequestUtil {
	/**
	 * 
	 * @param params
	 *            请求参数传入说明
	 * @param urlPath
	 *            请求接口头
	 * @return String形式的Json字段
	 */
	public String sendPostMessage(Map<String, String> params, String urlPath) {
		URL url = null;
		try {
			url = new URL(urlPath);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		StringBuilder stringBuilder = new StringBuilder();
		// 将密码添加MD5加密
		if (params != null && params.containsKey("pwd")) {
			params.put("pwd", new MD5EncryptionUtil().stringToMD5Code(params.get("pwd")));
		}
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				try {
					stringBuilder.append(entry.getKey()).append("=")
							.append(URLEncoder.encode(entry.getValue(), "utf-8")).append("&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			try {
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setConnectTimeout(3000);
				urlConnection.setRequestMethod("POST"); // 请求方式为POST
				urlConnection.setDoInput(true); //
				urlConnection.setDoOutput(true); //
				// 转化为byte数组
				byte[] myData = stringBuilder.toString().getBytes();
				urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				urlConnection.setRequestProperty("Content-Length", String.valueOf(myData.length));
				// 获取输出流，向目标发送请求信息
				OutputStream outputStream = urlConnection.getOutputStream();
				outputStream.write(myData, 0, myData.length);
				outputStream.close();
				// 获取响应码
				int responseCode = urlConnection.getResponseCode();
				if (responseCode == 200) {
					// 如果服务器有响应，上传信息
					return changeInputStream(urlConnection.getInputStream(), "utf-8");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "";
	}

	/**
	 * 
	 * @param inputStream
	 * @param encode
	 * @return
	 */
	private static String changeInputStream(InputStream inputStream, String encode) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		String result = null;
		if (inputStream != null) {
			try {
				while ((len = inputStream.read(data)) != -1) {
					byteArrayOutputStream.write(data, 0, len);
				}
				result = new String(byteArrayOutputStream.toByteArray(), encode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
