package com.lhb.studentmanager.dao;

import java.util.List;

import com.lhb.studentmanager.model.User;

public interface UserDao {

	User getUser(String userName, String password);// 通过用户名和密码获取数据库用户信息

	User getUser(String userName);// 通过用户名获取数据库用户信息

	User getUser(int ID);// 通过用户id获取数据库用户信息

	void addUser(User user);// 添加用户信息到数据库

	void deleteUser(User user);// 删除数据库该用户信息

	void updateUser(User user);// 修改数据该用户信息

	List<User> findAllUser();// 查询数据库所有用户信息
}
