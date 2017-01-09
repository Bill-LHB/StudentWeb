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
		User u=new User(userName,password);
				
		User user = null;

		
		
/*		String sql = "SELECT * FROM user WHERE userName=? AND password=?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString("userName");				
				String psw = rs.getString("password");
				int rank=rs.getInt("rank");
				int ID =rs.getInt("ID");
				user = new User(uname, psw,rank,ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}*/
		return user;
	}
 
	
	
	//<>;
	
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "SELECT * FROM user WHERE userName=?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString("userName");				
				String psw = rs.getString("password");
				int rank=rs.getInt("rank");
				int id =rs.getInt("id");
				user = new User(uname, psw,rank,id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}
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
	        String hql = "from USER";  
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
