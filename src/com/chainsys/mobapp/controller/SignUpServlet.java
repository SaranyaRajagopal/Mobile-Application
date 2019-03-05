package com.chainsys.mobapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		String gender =request.getParameter("gender");
		String password =request.getParameter("password");
		String email =request.getParameter("email");
		User user = new User();
		user.setUsername(name);
		user.setAge(age);
		user.setGender(gender);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		
				UserDAO dao = new UserDAO();
			//	boolean b=false;
				
		try {
		boolean	b=dao.checkUser(user);
			if(b){
				System.out.println(" inserting......");
			dao.addUser(user);
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			}
			else
			{
			RequestDispatcher rd = request.getRequestDispatcher("incorrectSignin.html");
			rd.forward(request, response);	
			}
		} catch (Exception e) {
			//RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			//rd.forward(request, response);
			e.printStackTrace();
		}
	}

	}


