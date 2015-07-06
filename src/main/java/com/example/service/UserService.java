package com.example.service;

import com.example.domain.UserInfo;
import com.example.model.User;

public interface UserService {
	//����û�
	public void addUser(User user);
	
	//�鿴���û���Ϣ�Ƿ��Ѿ�ע���
	public boolean checkUser(UserInfo userInfo);
	
	//��¼��֤
	public User login(UserInfo userInfo);

}
