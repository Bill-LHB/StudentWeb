package com.lhb.studentmanager.serverimpl;

import java.util.List;

import com.lhb.studentmanager.dao.UserDao;
import com.lhb.studentmanager.daoimpl.UserDaoImpl;
import com.lhb.studentmanager.model.User;
import com.lhb.studentmanager.server.UserServer;

public class UserServerImpl implements UserServer {
	private UserDao userDao = UserDaoImpl.getInstance();
	private static UserServerImpl userServer = null;

	public static UserServerImpl getInstance() {
		if (userServer == null) {
			userServer = new UserServerImpl();
		}
		return userServer;
	}

	private UserServerImpl() {

	}

	@Override
	public boolean isUser(String userName, String password) {
		if (userDao.getUser(userName, password) == null)
			return false;
		return true;
	}
	
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUser(userName);
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}
	
	/**
	 * 添加用户信息
	 */
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.getUser(user.getUserName())!=null){
			return false;
		}
		return userDao.addUser(user);
	}
	/**
	 * 删除用户信息
	 */
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		if(userDao.getUser(id)==null){
			return false;
		}
		return userDao.deleteUser(id);
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public boolean updateUser(User user) {
		User dbuser=userDao.getUser(user.getId());//获取原数据库内用户信息
		if(dbuser==null){//判断修改用户是否存在
			return false;
		}
		if(!user.getUserName().equals(dbuser.getUserName())){//判断是否修改用户名
			if(userDao.getUser(user.getUserName())!=null){//判断修改后的用户名是否存在
				return false;
			}
		}
		//修改数据库
		return userDao.updateUser(user);	
	}
	/**
	 * 显示用户信息
	 */
	@Override
	public List<User> showUser() {
		// TODO Auto-generated method stub		
		return userDao.showUser();
	}

}
