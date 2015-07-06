package com.example.dao;

import com.example.domain.UserInfo;
import com.example.model.User;

public interface UserDAO {

	//�����û�
	public void save(User user);
	
	//����user_id�����û�
	public User findUser(long userId);
	
	//�����û�
	public User findUser(UserInfo userInfo);

}
