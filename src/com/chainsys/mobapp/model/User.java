package com.chainsys.mobapp.model;

public class User {

	private String username;
	private String email;
	private String gender;
	private String password;
	private int age;
	private long phoneNumber;
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", gender="
				+ gender + ", password=" + password + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
