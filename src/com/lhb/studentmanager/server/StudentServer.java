package com.lhb.studentmanager.server;

import java.io.File;
import java.util.List;

import com.lhb.studentmanager.model.Student;

public interface StudentServer {
	boolean addStudent(Student student, File headerImg, String headerImgFileName, String savedir);// 添加学生

	boolean deleteStudent(int id, String rootDir);// 删除学生

	boolean updateStudent(Student student, String savedir, String headerImgFileName, File headerImg);// 更新学生信息

	List<Student> findStudent(String message);// 查找学生

	List<Student> findStudent(int message);// 查找学生

	List<Student> showStudent();// 显示学生列表

	Student findStudentById(int id);// 通过Id查找学生
}
