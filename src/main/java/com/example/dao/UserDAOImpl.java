package com.example.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.example.domain.UserInfo;
import com.example.model.User;

@Repository(value="userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public User findUser(long userId) {
		String hql = "from User where id = ?";
		Query query = createQuery(hql, userId);
		User user = (User) query.list().get(0);
		return user;
	}
	
	public User findUser(UserInfo userInfo) {
		String hql = "from User where username = ?";
		Query query = createQuery(hql, userInfo.getUsername());
		User findUser = (User) query.list().get(0);
		return findUser;
	}
	
	// 定义条件查询
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	
	
}
