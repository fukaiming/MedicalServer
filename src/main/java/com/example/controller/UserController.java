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
	 * description:��ע����û���ӵ����ݿ���
	 * 
	 * @return ����Ƿ�ɹ�
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
			result = "�û��Ѵ��ڣ�������ע��";
		} else {
			userService.addUser(user);
			result = "�û�ע��ɹ�";
		}
		return result;
	}

	/**
	 * descrpiton:�û���¼
	 * 
	 * @return �ɹ���true ʧ�ܣ��û��Ѵ��ڣ�������ע��
	 */
	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute UserInfo userInfo,
			HttpServletRequest request) {
		String result = null;
		boolean isExist = userService.checkUser(userInfo);
		if (isExist) {
			result = "�û��Ѵ��ڣ�������ע��";
			return result;
		}
		User user = userService.login(userInfo);
		if (user != null) {
			//�øõ�¼���û�������session��
			request.getSession().setAttribute("user", user);
			result = "success";
		}
		return result;
	}

	
}
