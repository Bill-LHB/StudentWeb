<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<body>
	<table width="100%" border="0" 
		bgcolor="#cccccc">
		<tr>
			<th>用户名</th>
			<th>密码</th>
			<th>权限</th>
			<td colspan="2">操作</td>
		</tr>
		<c:set var="c" value="1"/>
		<c:forEach items="${userList}" var="user">
			<c:if test="${c=='1'}">
				<c:set var="color" value="#f5f5f5"/>
			</c:if>
			<c:if test="${c=='2'}">
				<c:set var="color" value="#ffffff"/>
				<c:set var="c" value="0"/>
			</c:if>	    
			<tr bgcolor="${color}">
				<td>${user.userName}</td>
				<td>${user.password}</td>				
				<c:choose>
					<c:when test="${user.rank==1}">
						 <td>一级管理员</td>
					</c:when>
					<c:when test="${user.rank==2}">
						 <td>二级管理员</td>
					</c:when>
						<c:when test="${user.rank==3}">
						<td>三级管理员</td>
					</c:when>		  
					    <c:otherwise>
					    <td>四级管理员</td>
					    </c:otherwise>
					</c:choose>
					<td><a href="<%=request.getContextPath()%>/user_delete.do?id=${user.id}">删除</a></td>
					
					<td><a href="<%=request.getContextPath()%>/user_update.do?id=${user.id}">修改</a></td>
				</tr>
			<c:set var="c" value="${c+1}"/>			
		</c:forEach>
	
	</table>

</body>
</html>