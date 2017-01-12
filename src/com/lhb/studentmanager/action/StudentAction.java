package com.lhb.studentmanager.action;

import java.io.File;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.lhb.studentmanager.model.Student;

import com.lhb.studentmanager.server.StudentServer;
import com.lhb.studentmanager.serverimpl.StudentServerImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student>, RequestAware {
	private static Logger log = Logger.getLogger(LoginAction.class);
	private StudentServer studentServer = StudentServerImpl.getInstance();

	private Student studentModel = new Student();
	private Map<String, Object> requestMap;

	private String savedir;
	private File headerImg; // 上传文件内容保存到此临时文件中,变量名同表单相应name
	private String headerImgFileName;// 变量名为：表单相应name+FileName

	public StudentAction() {
		// 获取应用上下文路径
		savedir = ServletActionContext.getServletContext().getRealPath("/upload");
	}

	/**
	 * 添加学生
	 * 
	 * @return
	 */
	public String add() {
		if (studentModel.getId() == 0) {
			if (studentServer.addStudent(studentModel, headerImg, headerImgFileName, savedir))
				return SUCCESS;
			requestMap.put("error", "添加学生失败！");
			return INPUT;
		} else {
			int id = (int) requestMap.get("id");
			if (studentServer.updateStudent(studentModel, savedir, headerImgFileName, headerImg))
				return SUCCESS;
			requestMap.put("error", "修改学生失败！");
			requestMap.put("student", studentModel);
			return INPUT;
		}
	}

	/**
	 * 删除学生
	 * 
	 * @return
	 */
	public String delete() {
		int id = (int) requestMap.get("id");
		if (studentServer.deleteStudent(id, savedir))
			return SUCCESS;
		requestMap.put("error", "删除学生失败！");
		return "show";
	}

	/**
	 * 修改学生信息
	 * 
	 * @return
	 */
	public String update() {
		int id = (int) requestMap.get("id");
		Student stu = studentServer.findStudentById(id);
		requestMap.put("student", stu);
		return INPUT;
	}

	/**
	 * 显示所有学生
	 * 
	 * @return
	 */
	public String show() {
		List<Student> studentList = studentServer.getStudent();
		for(Student student:studentList){
			System.out.println(student);	
		}
		
		requestMap.put("studentList", studentList);

		return "show";
	}

	/**
	 * 查找学生
	 * 
	 * @return
	 */
	public String find() {
		String findMessage = (String) requestMap.get("findMessage");
		List<Student> studentList = studentServer.findStudent(findMessage);
		if (studentList != null) {
			requestMap.put("studentList", studentList);
			return "show";
		}
		requestMap.put("error", "查找学生失败！");
		return "find";
	}

	public File getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(File headerImg) {
		this.headerImg = headerImg;
	}

	public String getHeaderImgFileName() {
		return headerImgFileName;
	}

	public void setHeaderImgFileName(String headerImgFileName) {
		this.headerImgFileName = headerImgFileName;
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		this.requestMap = requestMap;
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return studentModel;
	}

}
