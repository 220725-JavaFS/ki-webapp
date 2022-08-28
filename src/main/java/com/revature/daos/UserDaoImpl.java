package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.orm.ObjectMapper;
import com.revature.orm.utils.Conf;

public class UserDaoImpl implements UserDAO {
	
	private Conf config = new Conf(
			System.getenv("POSTGRES_URL"),
			System.getenv("POSTGRES_UNAME"),
			System.getenv("POSTGRES_PASS")
			);
	
	private ObjectMapper om = new ObjectMapper(config);

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
