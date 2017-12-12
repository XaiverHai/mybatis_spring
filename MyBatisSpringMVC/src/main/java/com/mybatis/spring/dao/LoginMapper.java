package com.mybatis.spring.dao;

import com.mybatis.spring.pojo.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}