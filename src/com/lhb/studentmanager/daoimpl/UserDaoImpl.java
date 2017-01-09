package com.lhb.studentmanager.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lhb.studentmanager.DB.ConnectDB;
import com.lhb.studentmanager.dao.UserDao;

import com.lhb.studentmanager.model.User;
import com.lhb.studentmanager.utils.HibernateUtil;

public class UserDaoImpl extends ConnectDB implements UserDao {
	private static UserDaoImpl userDao = null;
	private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	public static UserDaoImpl getInstance() {
		if (userDao == null)
			userDao = new UserDaoImpl();
		return userDao;
	}

	private UserDaoImpl() {

	}

	@Override
	public User getUser(String userName, String password) {
		User user = null;
		String hql="FROM User AS u WHERE u.userName=:name AND u.password=:pw";
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query=session.getNamedQuery(hql);
		query.setParameter("name", userName);
		query.setParameter("pw", password);
		session.getTransaction().commit();
		user=(User) query.uniqueResult();
		return user;
	}
 
	
	
	//<>;
	
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		User user = null;
		String hql="SELECT * FROM User AS u WHERE u.userName=:name";
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query=session.getNamedQuery(hql);
		query.setParameter("name", userName);
		session.getTransaction().commit();
		user=(User) query.uniqueResult();
		return user;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean deleteUser(int id) {	
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(getUser(id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub			
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public List<User> showUser() {
		  Session session = sessionFactory.getCurrentSession();  
	        String hql = "from User";  
	        Query query = session.createQuery(hql);  
	        List<User> userList = query.list();  
	        return userList;  		
	}

	@Override
	public User getUser(int ID) {
		User user =null;
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		user=(User) session.get(User.class,ID);
		session.getTransaction().commit();
		return user;
	}
	

}
