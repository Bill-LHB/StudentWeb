package com.lhb.studentmanager.server;

import java.util.List;

import com.lhb.studentmanager.model.User;

public interface UserServer {
	boolean isUser(String userName, String password);// 检查用户名和密码是否注册

	User getUser(String userName);// 通过用户名获取用户

	User getUser(int id);// 通过ID获取用户
	
	List<User> getUser();// 获取所有用户

	boolean addUser(User user);// 添加用户

	boolean deleteUser(int id);// 删除用户

	boolean updateUser(User user);// 修改用户
}
