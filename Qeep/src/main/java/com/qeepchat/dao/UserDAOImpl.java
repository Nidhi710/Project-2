package com.qeepchat.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	public UserDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean add(User user) {
		sessionFactory.getCurrentSession().save(user);
		return false;
	}

}
