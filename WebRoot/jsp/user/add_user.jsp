<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>

</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/user_add.do" method="POST">
			<input type="hidden" name="id" value="${user.id}" />
			<table>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="userName" placeholder="请输入用户名"
						id="stName" onblur="return check()" value="${user.userName}" /> <span
						id="stNamemsg" style="color: red; font-size: 10px"></span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" placeholder="请输入密码"
						id="stNumber" onblur="return check()" value="${user.password}" />
						<span id="stNumbermsg" style="color: red; font-size: 10px"></span></td>
				</tr>
				<tr>
					<td>权限</td>
					<td><select name="rank">
							<option value="1"
								<c:if test="${user.rank== 1||empty user.rank}"> selected='selected' </c:if>>				 
								一级管理员
							</option>
							<option value="2"
								<c:if test='${user.rank== 2}'>   selected='selected' </c:if>>
								二级管理员</option>
							<option value="3"
								<c:if test='${user.rank== 3}' > selected='selected' </c:if>>
								三级管理员</option>
							<option value="4"
								<c:if test='${user.rank== 4}'> selected='selected' </c:if>>
								四级管理员</option> 	
					</select></td>
				</tr>
				<tr>
					<td><span id="stNamemsg" style="color: red; font-size: 10px">${error}</span></td>
			
					<td><input type="submit" value="提交" /></td>
				</tr>
			</table>
			
		</form>
	</div>

</body>
</html>