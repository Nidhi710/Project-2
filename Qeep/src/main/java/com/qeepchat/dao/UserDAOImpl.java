package com.qeepchat.dao;

import java.util.List;
import org.hibernate.Query;
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


	public List<User> listUser() {
		@SuppressWarnings("unchecked")
		List<User> listUser =(List<User>)
		sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return listUser;
	}


	public User getUserById(int id) {
		String hql = "from User where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}


	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}


	public void delete(int id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}

}
