package com.mybatis.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.spring.dao.LoginMapper;
import com.mybatis.spring.pojo.Login;
import com.mybatis.spring.service.ILoginService;

@Transactional
@Service("ILoginService")
public class LoginServiceImpl implements ILoginService {
	@Resource
	private LoginMapper loginMapper;

	/**
	 * 根据主键查询对象
	 */
	@Override
	public Login selectByPrimaryKey(Integer userid) {
		if (userid > 0 && loginMapper.selectByPrimaryKey(userid) != null) {

			return loginMapper.selectByPrimaryKey(userid);
		}
		return null;
	}

	/**
	 * 添加对象
	 */
	@Override
	public int insert(Login record) {
		if (record != null) {
			return loginMapper.insert(record);
		}
		return 0;
	}

}
