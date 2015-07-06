package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.domain.UserInfo;
import com.example.model.User;

@Service(value = "userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Transactional(readOnly = false)
	public void addUser(User user) {
		userDao.save(user);
	}

	public boolean checkUser(UserInfo userInfo) {
		User findUser = userDao.findUser(userInfo);
		return findUser == null ? false : true;
	}

	public User login(UserInfo userInfo) {
		String result = null;
		User findUser = userDao.findUser(userInfo);
		return findUser;
	}

}
