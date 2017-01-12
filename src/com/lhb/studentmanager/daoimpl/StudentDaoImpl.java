package com.lhb.studentmanager.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

	// private static Session session = sessionFactory.getCurrentSession();
	public static StudentDaoImpl getInstance() {
		if (studentDaoImpl == null)
			studentDaoImpl = new StudentDaoImpl();
		return studentDaoImpl;
	}

	private StudentDaoImpl() {

	}

	/**
	 * 添加学生到数据库
	 */
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	/**
	 * 通过ID删除数据库学生信息
	 */
	@Override
	public void deleteStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}

	/**
	 * 更新数据库学生信息
	 */
	@Override
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
	}

	/**
	 * 通过ID查找数据库学生信息
	 */
	@Override
	public Student findStudentById(int id) {
		Student student = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		student = (Student) session.get(Student.class, id);
		session.getTransaction().commit();
		return student;
	}

	/**
	 * 通过学号查找学生信息
	 */
	@Override
	public List<Student> findStudentByNumber(int number) {
		List<Student> studentList = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// int id, String name, int number, int age, int sex, String headerImg
		String hql = "FROM Student AS s WHERE s.number =:num";
		Query query = session.createQuery(hql);
		query.setParameter("num", number);
		studentList = query.list();
		session.getTransaction().commit();
		return studentList;
	}

	/**
	 * 通过姓名查找学生信息
	 */
	@Override
	public List<Student> findStudentByName(String name) {
		List<Student> studentList = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM Student AS s where s.name =:names";
		Query query = session.createQuery(hql);
		query.setParameter("names", name);
		studentList = query.list();
		session.getTransaction().commit();
		return studentList;
	}

	/**
	 * 获取数据库所有学生信息
	 */
	@Override
	public List<Student> findAllStudent() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> studentList = query.list();
		session.getTransaction().commit();
		return studentList;
	}

}
