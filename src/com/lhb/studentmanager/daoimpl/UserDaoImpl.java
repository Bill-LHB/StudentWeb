package com.lhb.studentmanager.daoimpl;

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
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static UserDaoImpl getInstance() {
		if (userDao == null)
			userDao = new UserDaoImpl();
		return userDao;
	}

	private UserDaoImpl() {

	}

	/**
	 * 通过账号，密码查找数据库用户信息
	 */
	@Override
	public User getUser(String userName, String password) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "From User AS u WHERE u.userName=:name AND u.password=:pw";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("name", userName);
		query.setParameter("pw", password);
		user = (User) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	/**
	 * 通过账号查找数据库用户信息
	 */
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		User user = null;
		String hql = "FROM User AS u WHERE u.userName=:name";
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("name", userName);
		user = (User) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	/**
	 * 添加用户到数据库
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	/**
	 * 通过ID删除用户
	 */
	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}

	/**
	 * 更新数据库用户信息
	 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	/**
	 * 查找所有数据库用户信息
	 */
	@Override
	public List<User> findAllUser() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		session.getTransaction().commit();
		return userList;
	}

	/**
	 * 通过ID查找数据库用户信息
	 * 
	 */
	@Override
	public User getUser(int ID) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		user = (User) session.get(User.class, ID);
		session.getTransaction().commit();
		return user;
	}

}
