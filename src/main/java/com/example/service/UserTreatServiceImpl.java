package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserTreat;
@Service(value="userTreatService")
public class UserTreatServiceImpl implements UserTreatService {
	@Autowired
	private UserTreatDAO userTreatDAO;
	public void addUserTreat(UserTreat userTreat) {
		userTreatDAO.add(userTreat);
	}

}
