package com.mybatis.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.spring.pojo.Login;
import com.mybatis.spring.service.IloginService;

@Controller
@Configuration
@ComponentScan("com.mybatis.spring.controller") // No need to include component-scan in xml
public class LoginController {
	@Autowired
	private ILoginService iloginService;

	/**
	 * 访问这个接口，需要传入参数：mobi，pwd（post方法） 返回登录信息：token
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 * @RequestParam 作用就是从网页里面获取相关字段
	 */
	@RequestMapping("/login")
	public String loginInit(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model)
			throws ServletException, IOException {
		Login login = iloginService.selectByPrimaryKey(2);
		if (username.equals("admin") && password.equals("admin")) {
            model.addAttribute("result", login.toString());
            return "result";
        } else {
            model.addAttribute("username", username);
            return "loginfailed";
        }
		
	}

}
