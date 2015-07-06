package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.UserTreat;
import com.example.service.UserTreatDAO;
@Repository(value="userTreatDAO")
public class UserTreatDAOImpl implements UserTreatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void add(UserTreat userTreat) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userTreat);
		transaction.commit();
		session.close();
	}

}
