package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	
	List<User> selectAll();
	
	void insert(User user);
	
	void delete(User user);
	
	void update(User userOld, User userNew);

}
