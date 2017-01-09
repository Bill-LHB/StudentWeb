package com.lhb.studentmanager.daoimpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lhb.studentmanager.dao.UserDao;
import com.lhb.studentmanager.model.User;

public class UserDaoImplTest {
UserDao userDao=UserDaoImpl.getInstance();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() {
		User user=new User("admin","123456",3);
		//userDao.addUser(user);
		 user=userDao.getUser(2);
		 System.out.println("user"+user);
	}

}
