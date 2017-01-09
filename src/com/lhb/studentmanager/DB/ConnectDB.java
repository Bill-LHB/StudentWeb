package com.lhb.studentmanager.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库父类
 * 
 * 1.加载数据库驱动 2.建立连接 3.关闭连接
 * 
 * @author scxh
 *
 */
public class ConnectDB {
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";

	public ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载mysql驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立数据库连接
	 */
	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connect;
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeConnection(Connection connect) {
		try {
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭SQL预处理
	 */
	public void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭结果集
	 * 
	 * @param rs
	 */
	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
