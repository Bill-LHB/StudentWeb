package com.lhb.studentmanager.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	public HttpServletRequest request;
	public HttpServletResponse response;
	public HttpSession session;
	public ServletContext application;

	public BasicAction() {
		// TODO Auto-generated constructor stub
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
		application = request.getServletContext();
		// .........
	}
}
