package com.lhb.studentmanager.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lhb.studentmanager.model.User;
import com.lhb.studentmanager.server.UserServer;
import com.lhb.studentmanager.serverimpl.UserServerImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>, RequestAware {
	private UserServer userServer = UserServerImpl.getInstance();
	private static Logger log = Logger.getLogger(LoginAction.class);
	private User user = new User();// 手动实例化
	private Map<String, Object> requestMap;

	/**
	 * 增加用户
	 * 
	 * @return
	 */
	public String add() {

		int Id = (int) requestMap.get("id");
		if (Id == 0) {// 添加学生
			if (userServer.addUser(user)) {
				return SUCCESS;
			}
			requestMap.put("error", "添加学生失败");
			return INPUT;
		} else {// 修改学生
			if (userServer.updateUser(user)) {
				return SUCCESS;
			}
			requestMap.put("error", "修改学生失败");
			requestMap.put("user", user);
			return INPUT;
		}
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {

		int Id = (int) requestMap.get("id");

		if (userServer.deleteUser(Id)) {
			return SUCCESS;
		}
		requestMap.put("error", "删除失败");
		return "delete";
	}

	/**
	 * 修改用户
	 * 
	 * @return
	 */
	public String update() {
		int Id = (int) requestMap.get("id");
		User u = userServer.getUser(Id);
		requestMap.put("user", u);
		return INPUT;

	}

	/**
	 * 显示用户
	 * 
	 * @return
	 */
	public String show() {
		List<User> userList = new ArrayList<>();
		userList = userServer.getUser();
		requestMap.put("userList", userList);

		return "show";
	}

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.requestMap = request;
	}

}
