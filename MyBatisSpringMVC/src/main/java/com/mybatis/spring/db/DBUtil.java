package com.mybatis.spring.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 获取sqlsession的工具类集成
 * 
 * @version 1.0 整合框架没有发现需要用到session的地方，先创建好，后面使用
 * @date 2017-12-11
 */
public class DBUtil {
	public SqlSession getSqlSession(String MapperXML) throws IOException {
		// 读取配置文件，抛出异常，异常在外部dao层统一处理
		Reader reader = Resources.getResourceAsReader(MapperXML);
		// 建立sqlSessionBuilder
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 打开session
		SqlSession session = sessionFactory.openSession();
		// 将得到的session返回,已经打开，用完之后需要关闭
		return session;
	}
}
