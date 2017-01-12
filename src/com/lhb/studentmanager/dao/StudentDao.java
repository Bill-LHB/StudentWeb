package com.lhb.studentmanager.dao;

import java.util.List;

import com.lhb.studentmanager.model.Student;

public interface StudentDao {
	List<Student> findStudentByNumber(int number);// 通过学号查找数据库该学生信息

	List<Student> findStudentByName(String name);// 通过姓名查找数据库该学生信息

	Student findStudentById(int id);// 通过ID查找数据库该学生信息

	void addStudent(Student student);// 添加学生到数据库

	void deleteStudent(Student student);// 删除数据库该学生信息

	void updateStudent(Student student);// 修改数据库该学生信息

	List<Student> findAllStudent();// 查询数据库内所有学生信息
}
