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

import com.chainsys.mobapp.dao.ProductDAO;
import com.chainsys.mobapp.model.Product;

/**
 * Servlet implementation class ModelServlet
 */
@WebServlet("/ModelServlet")
public class ModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String brand=request.getParameter("brand");
		Product product = new Product();
		product.setBrand(brand);
		
		ProductDAO dao1 = new ProductDAO();
		
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			list = dao1.model(product);
			request.setAttribute("model", list);
			RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		
		
	}

}
