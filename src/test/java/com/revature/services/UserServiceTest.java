package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserServiceTest {
	
	private UserDAO mockDao = Mockito.mock(UserDAO.class);
	private UserService us = new UserService(mockDao);
	
	private List<User> users = Stream.of(
			new User(1, "kyle", "irwin", "STUDENT", "kyle1"),
			new User(2, "ness", "garza", "STUDENT", "ness1"),
			new User(3, "moco", "irwin", "STUDENT", "moco1"),
			new User(4, "fonzi", "garza", "STUDENT", "fonzi1"),
			new User(5, "norm", "macdonald", "ADMIN", "norm1")
			).collect(Collectors.toList());
	
	@Test
	public void testSelectAll() {
		Mockito.when(mockDao.selectAll())
			.thenReturn(users);
		assertEquals(us.selectAll(), users);
	}

}
