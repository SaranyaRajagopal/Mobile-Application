package com.chainsys.mobapp.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.ws.Response;

import org.apache.jasper.tagplugins.jstl.core.Out;


public class UserDAO {

	ResultSet resultSet = null;
	public void addUser(User user) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into userss(mail_id,password,name,gender,age,phone_number) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4,user.getGender());
			preparedStatement.setInt(5,user.getAge());
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setLong(6,user.getPhoneNumber());
			
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean existingUser(User user) throws SQLException
	{
		boolean login=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from userss where mail_id=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
			try {
				preparedStatement.setString(1,user.getEmail());
				preparedStatement.setString(2,user.getPassword());
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()){
				
				String checkUser = resultSet.getString(1);
				String checkPass = resultSet.getString(2);
				if((checkUser.equalsIgnoreCase(user.getEmail())) && (checkPass.equals(user.getPassword())))
				{
				   login=true;	
				}
				else
				{
					login=false;
				}
				}
				else
				{
				    System.out.println("invalid");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return login;
		}
	public boolean checkUser(User user) throws SQLException
	{
		boolean signup=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select mail_id from userss where mail_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,user.getEmail());
		resultSet = preparedStatement.executeQuery();
		
		try {
			if(resultSet.next()){
			/*	String checkUser = resultSet.getString(1);
				System.out.println("checking");
				if((checkUser==null))
				{System.out.println("not present");
					signup=true;
					return signup;
			*/
				signup=false;
				return signup;
				
				}
				else 
				{//System.out.println("present");
					signup=true;
					return signup;
				}
				 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signup;
	}
	
	}


