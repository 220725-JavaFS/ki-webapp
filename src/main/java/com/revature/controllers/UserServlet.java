package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServlet extends HttpServlet {
	
	private ObjectMapper om = new ObjectMapper();
	private UserService us = new UserService(new UserDaoImpl());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
					throws IOException, ServletException {
		
		List<User> users = us.selectAll();
		String json = om.writeValueAsString(users);
		
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		pw.println(json);
		res.setStatus(200);
	}
}
