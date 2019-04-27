<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">欢迎来到管理员登陆界面</h1>
	<form action="<c:url value='/UserServlet'/>" method="post">
		<input type="hidden" name="method" value="login"/>
		<table align="center">
			<tr>
				<td style="text-align: right">客户姓名：</td>
					<td>
						<input type="text" name="username" value="${username }"/>
						<span style="color: red;font-weight:900">${errors.username}</span>
					</td>
			</tr>
			<tr>
				<td style="text-align: right">密码：</td>
					<td>
						<input type="password" name="password" value="${password }"/>
						<span style="color: red;font-weight:900">${errors.password}</span>
					</td>
			</tr>
			<tr>
				<td style="text-align: right">
					<input type="submit" value="登陆">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>