package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.orm.ObjectMapper;

public class UserDaoImpl implements UserDAO {
	
	ObjectMapper om = new ObjectMapper();

	@Override
	public List<User> selectAll() {
		return om.selectAll(User.class);
	}

	@Override
	public void insert(User user) {
		om.insert(user);
	}

	@Override
	public void delete(User user) {
		om.delete(user);
	}

	@Override
	public void update(User userOld, User userNew) {
		om.update(userOld, userNew);
	}

}
