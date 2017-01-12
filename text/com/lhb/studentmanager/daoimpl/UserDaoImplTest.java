package com.lhb.studentmanager.daoimpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lhb.studentmanager.dao.UserDao;
import com.lhb.studentmanager.model.User;

public class UserDaoImplTest {
private UserDao userDao=UserDaoImpl.getInstance();



	@Test
	public void testGetUserStringString() {
		assertNotNull(userDao.getUser("admin", "123456"));
	}

	@Test
	public void testGetUserString() {
		assertNotNull(userDao.getUser("admin"));
		
	}

	@Test
	public void testAddUser() {
		User user=new User("JKLJLK", "123456");
		userDao.addUser(user);
		User us=new User("hjkhjk", "123456");
		userDao.addUser(us);
		
	}

	@Test
	public void testDeleteUser() {
		User user=new User("JKLJLK", "123456",3,2);
		userDao.deleteUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user=new User("hjkhjk", "123456",3,3);
		userDao.updateUser(user);
	}

	@Test
	public void testFindAllUser() {
		
		assertNotNull(userDao.findAllUser());
	}

	@Test
	public void testGetUserInt() {
		assertNotNull(userDao.getUser(1));
	}

}
