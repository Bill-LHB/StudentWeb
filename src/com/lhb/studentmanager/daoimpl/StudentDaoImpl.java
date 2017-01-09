package com.lhb.studentmanager.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhb.studentmanager.DB.ConnectDB;
import com.lhb.studentmanager.dao.StudentDao;
import com.lhb.studentmanager.model.Student;

public class StudentDaoImpl extends ConnectDB implements StudentDao {
	private static StudentDaoImpl studentDaoImpl = null;

	public static StudentDaoImpl getInstance() {
		if (studentDaoImpl == null)
			studentDaoImpl = new StudentDaoImpl();
		return studentDaoImpl;
	}

	private StudentDaoImpl() {

	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "insert into student (name,number,age,sex,fileUrl)values(?,?,?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getNumber());
			ps.setInt(3, student.getAge());
			ps.setBoolean(4, student.isSex());
			ps.setString(5, student.getHeaderImg());
			int i = ps.executeUpdate();
			return i == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM student WHERE id = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			return i == 1 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE student SET name=?,age=?,sex=?,fileUrl=? ,number=? where sid=?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setBoolean(3, student.isSex());
			ps.setString(4, student.getHeaderImg());
			ps.setInt(5, student.getNumber());
			ps.setInt(5, student.getId());
			int i = ps.executeUpdate();
			return i == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return false;
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "SELECT * FROM student WHERE sid = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {

			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				int dbid = rs.getInt("sid");
				String name = rs.getString("name");
				int num = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("fileUrl");
				student = new Student(dbid, name, num, age, sex, url);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}

		return student;
	}

	@Override
	public List<Student> findStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;

		try {
			studentList = new ArrayList<>();
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if (rs.next()) {
				int dbid = rs.getInt("sid");
				String na = rs.getString("name");
				int num = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("fileUrl");
				Student student = new Student(dbid, na, num, age, sex, url);
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}

		return studentList;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE name = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;
		try {
			studentList = new ArrayList<>();
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				int dbid = rs.getInt("sid");
				String na = rs.getString("name");
				int num = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("fileUrl");
				Student student = new Student(dbid, na, num, age, sex, url);
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return studentList;
	}

	@Override
	public List<Student> showStudent() {
		String sql = "SELECT * FROM student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			studentList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("name");
				int number = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("fileUrl");
				Student student = new Student(id, name, number, age, sex, url);
				studentList.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(connect);
		}
		return studentList;
	}

}
