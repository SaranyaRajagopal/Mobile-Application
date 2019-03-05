package com.chainsys.mobapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		PrintWriter out = response.getWriter();
		//System.out.println("123");
		if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("pass")){
			RequestDispatcher rd = request.getRequestDispatcher("MobDetails.html");
			rd.forward(request, response);
		}else {
			out.print("you dont have an account please signup to continue");
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.forward(request, response);	
		}
		
	}

}
