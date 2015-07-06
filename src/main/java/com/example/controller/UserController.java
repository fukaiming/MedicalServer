package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.UserInfo;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.UserTreatService;

@Controller
@RequestMapping(value = "/userInfo")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserTreatService userTreatService;

	/**
	 * description:将注册的用户添加到数据库中
	 * 
	 * @return 添加是否成功
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute User user) {
		String result = null;
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(user.getUsername());
		userInfo.setPassword(user.getPassword());
		boolean isExist = userService.checkUser(userInfo);
		if (isExist) {
			result = "用户已存在，请重新注册";
		} else {
			userService.addUser(user);
			result = "用户注册成功";
		}
		return result;
	}

	/**
	 * descrpiton:用户登录
	 * 
	 * @return 成功：true 失败：用户已存在，请重新注册
	 */
	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute UserInfo userInfo,
			HttpServletRequest request) {
		String result = null;
		boolean isExist = userService.checkUser(userInfo);
		if (isExist) {
			result = "用户已存在，请重新注册";
			return result;
		}
		User user = userService.login(userInfo);
		if (user != null) {
			//用该登录的用户保存在session中
			request.getSession().setAttribute("user", user);
			result = "success";
		}
		return result;
	}

	
}
