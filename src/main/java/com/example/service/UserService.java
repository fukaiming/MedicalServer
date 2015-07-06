package com.example.service;

import com.example.domain.UserInfo;
import com.example.model.User;

public interface UserService {
	//添加用户
	public void addUser(User user);
	
	//查看该用户信息是否已经注册过
	public boolean checkUser(UserInfo userInfo);
	
	//登录验证
	public User login(UserInfo userInfo);

}
