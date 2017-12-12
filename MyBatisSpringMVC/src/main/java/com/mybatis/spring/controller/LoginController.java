package com.mybatis.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.spring.pojo.Login;
import com.mybatis.spring.service.impl.LoginServiceImpl;

@Controller
@Configuration
@ComponentScan("com.mybatis.spring.controller") // No need to include component-scan in xml
public class LoginController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;

	/**
	 * 访问这个接口，需要传入参数：mobi，pwd（post方法） 返回登录信息：token
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/loginService")
	public String loginInit(HttpServletResponse response, HttpServletRequest request, Model model)
			throws ServletException, IOException {
		Login login = loginServiceImpl.selectByPrimaryKey(2);
		model.addAttribute("login", login);
		return "login";

	}

}
