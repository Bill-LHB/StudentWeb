package com.lhb.studentmanager.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lhb.studentmanager.model.User;
import com.lhb.studentmanager.server.UserServer;
import com.lhb.studentmanager.serverimpl.UserServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>, RequestAware, SessionAware {
	private UserServer userServer = UserServerImpl.getInstance();
	private static Logger log = Logger.getLogger(LoginAction.class);
	private User user = new User();// 手动实例化
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		
		return INPUT;
	}

	
	public String inLogin(){
		if (!userServer.isUser(user.getUserName(), user.getPassword())) {
			requestMap.put("login_error", "用户名或密码不正确!");
			return INPUT;
		}
		User u = userServer.getUser(user.getUserName());
		sessionMap.put("thisUser", u);
		return SUCCESS;

	}
	
	
	public String outLogin(){
		requestMap.put("login_error", "");
		sessionMap.put("thisUser", "");
		return INPUT;
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.requestMap = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap = session;
	}
}
