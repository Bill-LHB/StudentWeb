<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找学生</title>
</head>
<body>
	<div>
	<form action="./student_find.do" method="post">
		<table>
			<tr>
				<td>请输出查找学生姓名或学号</td>
				<td>
					<input type="text" name="findMessage" placeholder="请输出查找学生姓名或学号"  />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="查找" />
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>