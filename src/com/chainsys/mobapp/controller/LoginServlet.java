package com.chainsys.mobapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password =request.getParameter("password");
		String email =request.getParameter("email");
		
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO dao = new UserDAO();
		PrintWriter out = response.getWriter();
		try {
			boolean b = dao.existingUser(user);
			ProductDAO dao1 = new ProductDAO();
			ArrayList<Product> list = new ArrayList<Product>();
			ArrayList<Product> list1 = new ArrayList<Product>();
			if(b){
		        list = dao1.brand();
		        request.setAttribute("brand", list);
		        //list1 = dao1.model();
		       // request.setAttribute("model", list1);
				RequestDispatcher rd = request.getRequestDispatcher("BrandSearch.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("incorrectLogin.html");
			//	out.println("invalid username or password");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
	}

}
