package com.lhb.studentmanager.daoimpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lhb.studentmanager.model.Student;

public class StudentDaoImplTest {
	private StudentDaoImpl studentDaoImpl=StudentDaoImpl.getInstance();


	@Test
	public void testAddStudent() {
		//Student(String name, int number, int age, boolean sex, String headerImg)
		Student student=new Student("小胖",2011,21,1,"#");
		studentDaoImpl.addStudent(student);
		Student stu=new Student("小小胖",2011,21,1,"#");
		studentDaoImpl.addStudent(stu);
	}

	@Test
	public void testDeleteStudent() {
		Student student=new Student(2,"小胖",2011,21,1,"#");
		studentDaoImpl.deleteStudent(student);
	}

	@Test
	public void testUpdateStudent() {
		Student stu=new Student(1,"小小胖",2011,21,1,"#");
		studentDaoImpl.updateStudent(stu);
		
	}

	@Test
	public void testFindStudentById() {
		assertNotNull(studentDaoImpl.findStudentById(1));
	}

	@Test
	public void testFindStudentByNumber() {
		System.out.println(studentDaoImpl.findStudentByNumber(2011));
		assertNotNull(studentDaoImpl.findStudentByNumber(2011));
		
	}

	@Test
	public void testFindStudentByName() {
		assertNotNull(studentDaoImpl.findStudentByName("小小胖"));
	}

	@Test
	public void testFindAllStudent() {
		assertNotNull(studentDaoImpl.findAllStudent());
	}

}
