package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	void saveUser(User userinfo);
	//public boolean checklogin(String userName,String password);
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUser(int userId);
	User findUserByName(String username);
	List<User> getAllUsers();
}
