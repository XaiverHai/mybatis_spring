package com.test.mybatis.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.spring.pojo.Login;
import com.mybatis.spring.service.impl.LoginServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-dao.xml" })
public class LoginMapperTest {
	@Autowired
	// 这里可以为接口，也可以直接为接口实现的impl类
	 private LoginServiceImpl loginMapper;
	// 空指针异常，问题发现，只能用dao层里面的内容，impl里面的内容无法使用
//	private LoginMapper loginMapper;
	

	// @Test
	// public void loginQueryTest() throws Exception {
	// Login login = loginMapper.selectByPrimaryKey(1);
	// System.out.println(login);
	// System.out.println(login.getToken());
	// }
	/**
	 * 测试没有问题，测试代码的过程中不能有一点差错，否则程序一定会报错
	 */
	@Test
	public void insertTest() throws Exception {
		Login login = new Login();
		login.setUserid(4);
		login.setMsg("测试");
		login.setResult("测试");
		int i = loginMapper.insert(login);
		System.out.println(i);
	}
}
