package com.chainsys.mobapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	ResultSet resultSet = null;
	public void addProduct(Product product) throws Exception {
		System.out.println("Add product");
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into admin(Product_id,Brand,Model,Price,Processor,Memory) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2,product.getBrand());
			preparedStatement.setString(3,product.getModel());
			preparedStatement.setInt(4, product.getPrice());
			preparedStatement.setString(5,product.getProcessor());
			preparedStatement.setString(6,product.getMemory());
			
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Product> brand() throws SQLException
	{
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
		String sql = "select distinct brand from admin";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<Product> list = new ArrayList<Product>();
		while(resultSet.next())
		{
			Product product = new Product();
			product.setBrand(resultSet.getString("brand"));
			list.add(product);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
		  
	}
	public ArrayList<Product> model(Product product) throws SQLException
	{
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
		String sql = "select model from admin where brand=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,product.getBrand());
		resultSet = preparedStatement.executeQuery();
		ArrayList<Product> list1 = new ArrayList<Product>();
		while(resultSet.next())
		{
			Product product2=new Product();
			product2.setModel(resultSet.getString("model"));
			list1.add(product2);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list1;
		  
	}

}
