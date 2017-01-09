<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>

</head>
<body>
	<div>
		<form action="./student_add.do" method="POST"  enctype="multipart/form-data">
		<input type="hidden" name ="id" value="${student.id}">
			<table>
				<tr>
					<td>姓名</td>
					<td>
						<input type="text" name="name" placeholder="请输入姓名" id="stName" value="${student.name}" onblur="return check()"/>
						<span id="stNamemsg" style="color:red;font-size:10px"></span>
					</td>
				</tr>
				<tr>
					<td>学号</td>
					<td>
						<input type="text" name="number" placeholder="请输入学号" id="stNumber" value="${student.number}" onblur="return check()"/>
						<span id="stNumbermsg" style="color:red;font-size:10px"></span>
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>
						<input type="text" name="age" placeholder="请输入年龄" id="stAge" value="${student.age}" onblur="return check()"/>
						<span id="stAgemsg" style="color:red;font-size:10px"></span>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<c:if test="${student.sex==true || empty student.sex}">
								<input type="radio" name="sex" id="stSex" value="1" checked/>男
								<input type="radio" name="sex" id="stSex" value="0"/>女
						</c:if>
						<c:if test="${student.sex==false}">
								<input type="radio" name="sex" id="stSex" value="1" />男
								<input type="radio" name="sex" id="stSex" value="0" checked/>女
						</c:if>
					</td>
				</tr>
				<tr>
					<td>头像</td>
					<td>
						<input type="file" name="headerImg" />
						<span id="headerImgmsg" style="color:red;font-size:10px"></span>
					</td>
				</tr>			
			</table>	
			<span id="stNamemsg" style="color:red;font-size:10px">${error}</span><br><br>	
			<input type="submit" value="提交"/>
		</form>
	</div>
</body>
</html>