package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class UpdateServlet extends HttpServlet {

	private ObjectMapper om = new ObjectMapper();
	private UserService us = new UserService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
					throws IOException, ServletException {
		
		StringBuilder jb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		
		while (line != null) {
			jb.append(line);
			line = reader.readLine();
		}
		
		String json = new String(jb);
		List<User> swap = om.readValue(json, new TypeReference<List<User>>() {});
		us.update(swap.get(0), swap.get(1));
		res.setStatus(201);
	}
}
