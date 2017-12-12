package com.mybatis.spring.util;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thoughtworks.xstream.XStream;


public class CommonUtil {
	public static Object SringToXML(String result) {
		XStream xStream = new XStream();
		Object myObject2 = xStream.fromXML(result);
		return myObject2;
	}

	/**
	 * @description 将String对象转换为对象
	 * @author 徐海
	 * @param Result
	 *            获取的Json字符串
	 * @param param
	 *            需要得到的数值
	 * @return
	 */
	public static String StringToJson(String Result, String param) {
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(Result);
		JsonObject object = element.getAsJsonObject();// 三种情况：1、无法获取。2、正常获取。3、有子节点
		if (object != null) {// 不存在或者在子节点 获取为空值
			if (!(object.get(param).isJsonObject())) {// 正常获取和有子节点的情况
				return object.get(param).getAsString();
			} else {// 有子节点的情况
				JsonObject object2 = object.get(param).getAsJsonObject();// 需要再加循环判断
				return object2.toString();
			}
		} else {
			return "无法获取该值";
		}
	}

	/**
	 * @description 获取常量的值
	 * @author 徐海
	 * 
	 */
	void getParam(String name, String pwd, String param) {

	}
}
