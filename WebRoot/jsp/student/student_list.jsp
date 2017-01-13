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
			<th>头像</th>
			<th>姓名</th>
			<th>学号</th>
			<th>年龄</th>
			<th>性别</th>
			<th colspan="2">操作</th>
		</tr>
		<c:set var="c" value="1"/>
		<c:forEach items="${studentList}" var="stu">
		
		<c:if test="${c=='1'}">
			<c:set var="color" value="#f5f5f5"/>
		</c:if>
		<c:if test="${c=='2'}">
			<c:set var="color" value="#ffffff"/>
			<c:set var="c" value="0"/>
		</c:if>	    
			<tr bgcolor="${color}"><td>
			<c:if test="${empty stu.headerImg}">			
				<img src="../images/y.jpg" width="40px" height="40px"/>
			</c:if>
			<c:if test="${!empty stu.headerImg}">			
				<img src="${stu.headerImg}" width="40px" height="40px"/>
			</c:if></td>
				<td>${stu.name}</td>
				<td>${stu.number}</td>
				<td>${stu.age}</td>
				<td><c:if test="${stu.sex==0}">男</c:if>
					<c:if test="${stu.sex==1}">女</c:if>
				</td>
				<td><a href="<%=request.getContextPath()%>/student_delete.do?id=${stu.id}">删除</a></td>
				
				<td><a href="<%=request.getContextPath()%>/student_update.do?id=${stu.id}">修改</a></td>
			</tr>
			<c:set var="c" value="${c+1}"/>			
		</c:forEach>
	
	</table>

</body>
</html>