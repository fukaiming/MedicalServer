package com.example.dao;

import com.example.domain.UserInfo;
import com.example.model.User;

public interface UserDAO {

	//保存用户
	public void save(User user);
	
	//根据user_id查找用户
	public User findUser(long userId);
	
	//查找用户
	public User findUser(UserInfo userInfo);

}
