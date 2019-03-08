package com.chainsys.mobapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.mobapp.model.Product;
import com.chainsys.mobapp.util.ConnectionUtil;


public class SearchDAO {

	public ArrayList findall(Product product) throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="SELECT * FROM admin WHERE Model=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		//stmt.setString(1,product.getBrand());
		stmt.setString(1,product.getModel());
		ResultSet resultset = stmt.executeQuery();
		ArrayList<Product> blist=new ArrayList<>();
		while(resultset.next()){
			Product prod =new Product();
			prod.setId(resultset.getInt("product_id"));
			prod.setBrand(resultset.getString("brand"));
			prod.setModel(resultset.getString("model"));
			prod.setPrice(resultset.getInt("price"));
			prod.setProcessor(resultset.getString("processor"));
			prod.setMemory(resultset.getString("memory"));
			blist.add(prod);
		}
		return blist;
	}

}
