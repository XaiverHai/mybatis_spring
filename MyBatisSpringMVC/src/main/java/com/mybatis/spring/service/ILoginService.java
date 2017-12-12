package com.mybatis.spring.service;

import com.mybatis.spring.pojo.Login;


public interface ILoginService {
	public Login selectByPrimaryKey(Integer userid);
	public int insert(Login record);
}