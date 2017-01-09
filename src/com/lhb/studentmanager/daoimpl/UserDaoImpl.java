package com.lhb.studentmanager.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhb.studentmanager.DB.ConnectDB;
import com.lhb.studentmanager.dao.UserDao;

import com.lhb.studentmanager.model.User;

public class UserDaoImpl extends ConnectDB implements UserDao {
	private static UserDaoImpl userDao = null;

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
		String sql = "SELECT * FROM user WHERE userName=? AND password=?";
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
		}
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
		String sql = "insert into user (userName,password,rank)values(?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1,user.getUserName() );
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRank());
			int i=ps.executeUpdate();
			return i==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM user WHERE id = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			return i==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET userName=?,password=?,rank=? where id=?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRank());
			ps.setInt(4, user.getId());
			int i=ps.executeUpdate();
			return i==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public List<User> showUser() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> userList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			userList = new ArrayList<>();
			while (rs.next()) {
				String uname = rs.getString("userName");				
				String psw = rs.getString("password");
				int rank=rs.getInt("rank");
				int id =rs.getInt("id");
				User user = new User(uname, psw,rank,id);
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return userList;
	}

	@Override
	public User getUser(int ID) {
		User user = null;
		String sql = "SELECT * FROM user WHERE ID=?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, ID);
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
	

}
