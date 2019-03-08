package com.chainsys.mobapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.mobapp.dao.SearchDAO;
import com.chainsys.mobapp.model.Product;



/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model =request.getParameter("model");
		
		Product product = new Product();
		//produ
		product.setModel(model);
		//PrintWriter out = response.getWriter();
		
		 //String brand1;
			SearchDAO dao = new SearchDAO();
			
			try {
				
					ArrayList<Product> plist=dao.findall(product);
					HttpSession session = request.getSession(false);
					session.setAttribute("PRODUCT", plist);
					request.setAttribute("product", plist);
					RequestDispatcher rd=request.getRequestDispatcher("ProductList.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
			
			}
			
		
	
	

	}

