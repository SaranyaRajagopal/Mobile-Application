package com.chainsys.mobapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.mobapp.model.Product;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet("/DisplayProduct")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String brand =request.getParameter("brand");
		String model =request.getParameter("model");
		int price=Integer.parseInt(request.getParameter("price"));
		String processor =request.getParameter("processor");
		String memory =request.getParameter("memory");
		Product product = new Product();
		product.setId(id);
		product.setBrand(brand);
		product.setModel(model);
		product.setPrice(price);
		product.setProcessor(processor);
		product.setMemory(memory);
	
	}

}
