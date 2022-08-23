package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServlet extends HttpServlet {
	
	private ObjectMapper om = new ObjectMapper();
	private UserService us = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
					throws IOException, ServletException {
		
		String[] pathParams = req.getRequestURI().split("/");
		
		if (pathParams.length  == 2 && pathParams[1] == "all") {
			List<User> users = us.selectAll();
			String usersJSON = om.writeValueAsString(users);
			PrintWriter pw = res.getWriter();
			pw.print(usersJSON);
			res.setContentType("application/json");
			res.setStatus(200);
			
		} else {
			res.setStatus(404);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res)
//					throws IOException, ServletException {
//		String[] pathParams = req.getRequestURI().split("/");
//		
//		if (pathParams.length == 2) {
//			switch (pathParams[1]) {
//			case "delete":
//				
//			}
//		} else {
//			res.setStatus(404);
//		}
//	}

}
