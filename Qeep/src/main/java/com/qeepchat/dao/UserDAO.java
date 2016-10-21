package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.User;

public interface UserDAO {
	public boolean add(User user);
	List<User> listUser();
	User getUserById(int id);
	void update(User user);
    void delete(int id);
  
}
