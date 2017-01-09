package com.lhb.studentmanager.serverimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import com.lhb.studentmanager.dao.StudentDao;
import com.lhb.studentmanager.daoimpl.StudentDaoImpl;
import com.lhb.studentmanager.model.Student;
import com.lhb.studentmanager.server.StudentServer;
import com.lhb.studentmanager.utils.FileUtil;

public class StudentServerImpl implements StudentServer {
	private StudentDao studentDao = StudentDaoImpl.getInstance();

	private static StudentServerImpl studentServer = null;

	public static StudentServerImpl getInstance() {
		if (studentServer == null) {
			studentServer = new StudentServerImpl();
		}
		return studentServer;
	}

	private StudentServerImpl() {

	}

	/**
	 * 添加学生
	 */
	@Override
	public boolean addStudent(Student student, File headerImg, String headerImgFileName, String savedir) {
		
		// 判断学号是否存在，存在返回false
		if (studentDao.findStudentByNumber(student.getNumber()).get(0) != null) {
			return false;
		}		
		String headerImgUrl = "";
		// 判断是否上传头像，是上传头像，执行上传操作，并修改头像url
		if (headerImg != null) {
			headerImgUrl = "/upload/" + headerImgFileName;
				File saveFile = new File(savedir, headerImgFileName);
				FileUtil.createFile(saveFile);
				FileUtil.copy(headerImg, saveFile);
		
		}

		// 将学生信息添加至数据库
		Student stu = new Student(student.getName(), student.getNumber(), student.getAge(), student.isSex(),
				headerImgUrl);
		return studentDao.addStudent(stu);
	}

	/**
	 * 删除学生
	 */
	@Override
	public boolean deleteStudent(int id, String rootDir) {
		// TODO Auto-generated method stub

		Student student = studentDao.findStudentById(id);
		// 判断删除学生是否存在
		if (student == null) {
			return false;
		}
		File file = new File(rootDir + student.getHeaderImg());
		deleteFile(file);
		
		// 从数据库删除学生信息
		return studentDao.deleteStudent(id);
	}

	/**
	 * 修改学生信息
	 */
	// @Override
	public boolean updateStudent(Student student,String savedir,String headerImgFileName,File headerImg) {
		// 获取需要修改学生数据库信息
		Student stuDB = studentDao.findStudentById(student.getId());
		// 修改学生数据库不存在，返回false
		if (stuDB == null) {
			return false;
		}
		
		if(stuDB.getNumber()!=student.getNumber()){//判断是否修改学号
			if(studentDao.findStudentByNumber(student.getNumber())!=null){//判断修改学号是否存在
				return false;
			}
			
		}
		//原头像路径
		String headerImgUrl=stuDB.getHeaderImg();
		if(headerImg != null){//判断是否上传头像
			File saveFile = new File(savedir, headerImgFileName);
			FileUtil.createFile(saveFile);	
			headerImgUrl = "/upload/" + headerImgFileName;		
			FileUtil.copy(headerImg, saveFile);
		
			File oldfile = new File(savedir, stuDB.getHeaderImg());
			//删除原头像
			deleteFile(oldfile);
			
		}
		//更新数据库数据
		Student stu=new Student(student.getName(), student.getNumber(), student.getAge(), student.isSex(),
				headerImgUrl);
		return studentDao.updateStudent(stu);

	}

	/**
	 * 显示所有学生信息
	 */
	@Override
	public List<Student> showStudent() {
		// TODO Auto-generated method stub
		return studentDao.showStudent();
	}

	
	
	
	
	/**
	 * 通过查询信息查找学生
	 */
	@Override
	public List<Student> findStudent(String message) {
		// TODO Auto-generated method stub
		List<Student> studentList = null;
		try {
			int number = Integer.parseInt(message);
			studentList = studentDao.findStudentByNumber(number);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			studentList = studentDao.findStudentByName(message);
		}
		return studentList;
	}

	/**
	 * 通过查询信息查找学生
	 */
	@Override
	public List<Student> findStudent(int message) {
		// TODO Auto-generated method stub
		List<Student> studentList =studentDao.findStudentByNumber(message);
		return studentList;
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}
	/**
	 * 判定文件是否为文件，是文件执行删除
	 * 
	 * @param file
	 */
	private void deleteFile(File file) {
		if (file.isFile()) {
			try {
				FileUtil.deleteFile(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}


}
