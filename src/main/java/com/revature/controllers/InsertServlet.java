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

public class InsertServlet extends HttpServlet {
	
	private ObjectMapper om = new ObjectMapper();
	private UserService us = new UserService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
					throws IOException, ServletException {
		
		StringBuilder jb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		
		while (line != null ) {
			jb.append(line);
			line = reader.readLine();
		}
		
		String json = new String(jb);
		User user = om.readValue(json, User.class);
		us.insert(user);
		res.setStatus(201);
	}

}
