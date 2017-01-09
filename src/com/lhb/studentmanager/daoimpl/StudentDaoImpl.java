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
import com.lhb.studentmanager.dao.StudentDao;
import com.lhb.studentmanager.model.Student;
import com.lhb.studentmanager.model.User;
import com.lhb.studentmanager.utils.HibernateUtil;

public class StudentDaoImpl extends ConnectDB implements StudentDao {
	private static StudentDaoImpl studentDaoImpl = null;
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(findStudentById(id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public Student findStudentById(int id) {
		Student student = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		student = (Student) session.get(Student.class, id);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public List<Student> findStudentByNumber(int number) {
		ArrayList<Student> studentList=null;
		
		
		String hql = "SELECT FROM student where  number = ?" ;  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, number);  
        query.executeUpdate();
		
		
		
		
		/*String sql = "SELECT * FROM student WHERE number = ?";
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
		}*/

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
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> studentList = query.list();
		return studentList;
	}

}
