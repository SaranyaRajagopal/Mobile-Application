package com.chainsys.mobapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncorrectSignUp
 */
@WebServlet("/IncorrectSignUp")
public class IncorrectSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncorrectSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		
				
		try {
			UserDAO dao1 = new UserDAO();
			boolean b1 = dao1.checkUser(user);
			if(b1){
			dao1.addUser(user);
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
