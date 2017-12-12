package com.mybatis.spring.pojo;

public class Login {
	private Integer userid;

	private String token;

	private String result;

	private String msg;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg == null ? null : msg.trim();
	}

	@Override
	public String toString() {
		return "{\"userid\":\"" + userid + "\",\"token\":\"" + token + "\",\"result\":\"" + result + "\",\"msg\":\""
				+ msg + "\"}";
	}

}