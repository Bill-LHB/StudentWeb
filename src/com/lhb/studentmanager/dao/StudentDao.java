package com.lhb.studentmanager.dao;

import java.util.List;

import com.lhb.studentmanager.model.Student;

public interface StudentDao {
	boolean addStudent(Student student);// 添加学生

	boolean deleteStudent(int id);// 删除学生

	boolean updateStudent(Student student);// 修改学生

	List<Student> findStudentByNumber(int number);// 查找学号查找学生

	List<Student> findStudentByName(String name);// 通过姓名查找学生

	Student findStudentById(int id);// 通过id查找学生

	List<Student> showStudent();// 显示学生列表
}
