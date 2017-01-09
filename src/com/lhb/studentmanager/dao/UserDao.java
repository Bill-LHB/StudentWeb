package com.lhb.studentmanager.dao;

import java.util.List;

import com.lhb.studentmanager.model.User;

public interface UserDao {

	User getUser(String userName, String password);// 通过用户名和密码获取用户

	User getUser(String userName);// 通过用户名获取用户
	
	//User getUserexclude(User user);// 通过用户名获取用户

	User getUser(int ID);// 通过用户id获取用户

	boolean addUser(User user);// 添加用户

	boolean deleteUser(int id);// 删除用户

	boolean updateUser(User user);// 修改用户

	List<User> showUser();// 显示用户列表
}
