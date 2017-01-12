package com.lhb.studentmanager.server;

import java.io.File;
import java.util.List;

import com.lhb.studentmanager.model.Student;

public interface StudentServer {

	List<Student> findStudent(String message);// 通过姓名或学号查找学生

	List<Student> findStudent(int message);// 通过学号查找学生

	Student findStudentById(int id);// 通过Id查找学生

	List<Student> getStudent();// 获取所有学生信息

	boolean addStudent(Student student, File headerImg, String headerImgFileName, String savedir);// 添加学生

	boolean deleteStudent(int id, String rootDir);// 删除学生

	boolean updateStudent(Student student, String savedir, String headerImgFileName, File headerImg);// 更新学生信息

}
