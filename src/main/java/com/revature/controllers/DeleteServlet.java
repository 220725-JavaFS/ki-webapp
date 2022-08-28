package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class DeleteServlet extends HttpServlet {
	
	ObjectMapper om = new ObjectMapper();
	UserService us = new UserService();
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res)
					throws IOException, ServletException {
		
		StringBuilder jb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		
		while (line != null) {
			jb.append(line);
			line = reader.readLine();
		}
		
		String userJson = new String(jb);
		User user = om.readValue(userJson, User.class);
		us.delete(user);
		res.setStatus(200);
	}

}
