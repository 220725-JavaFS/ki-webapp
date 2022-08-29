package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	
	private UserDAO userDao;
	
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	public void insert(User user) {
		userDao.insert(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
	
	public void update(User userOld, User userNew) {
		userDao.update(userOld, userNew);
	}
	
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

}
