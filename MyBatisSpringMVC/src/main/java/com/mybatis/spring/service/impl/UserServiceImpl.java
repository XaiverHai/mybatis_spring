package com.mybatis.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mybatis.spring.dao.UserMapper;
import com.mybatis.spring.pojo.User;
import com.mybatis.spring.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

}
