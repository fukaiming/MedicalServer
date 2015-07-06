package com.example.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.UserTreat;
@Repository(value="userTreatMaterialDAO")
public class UserTreatMaterialDAOImpl implements UserTreatMaterialDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(UserTreat userTreat) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session == null);
		session.save(userTreat);
	}

}
