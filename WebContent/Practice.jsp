<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>答题页面</title>
<style type="text/css">
	#select{
	margin: 0 auto;
	width: 80%;
	height:1700px;
	/* border: solid red; */
	}
	#s_1{
	padding: 10px 0;
    border-top: solid 1px #CCC;
	}
	#s_2{
	height: 162px;
	list-style: none;
	}
</style>
</head>
<body>
<!--foreach循环  -->
	<h1 align="center">练习题</h1>
	<span style="color: red;float: center;font-weight:900">${msg}</span>
	<div id="select">
		<input  type="button" style="float: right;" value="管理员入口" onclick="location.href='AdminLogin.jsp'"/>
		<h2>一.单选题(共10题，每题10分)</h2>
		<div id="s_1">
			<c:choose>
				<c:when test="${empty resultMap}">
					<form action="<c:url value='/UserServlet?method=judgeAnswer&id=${id }'/>" method="post">
						<c:forEach items="${examList}" var="exam">
							<div style="line-height: 35px; font-size: 14px;padding-right:15px;">  
								${exam.title}
							</div>
							<ul id="s_2" style="padding-left:10px;">
			                 	<li>
			                		<input type="radio" name="${exam.id} " value="A"/>&nbsp;&nbsp;A
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseA}</a>
			              		</li>
			              		<li>
			                		<input type="radio" name="${exam.id}" value="B"/>&nbsp;&nbsp;B
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseB}</a>							
			              		</li>
			              		<li>
			                		<input type="radio" name="${exam.id}" value="C"/>&nbsp;&nbsp;C
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseC}</a>
			              		</li>
			              		<li>
			                		<input type="radio" name="${exam.id}" value="D"/>&nbsp;&nbsp;D
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseD}</a>						
			              		</li>
			            	</ul>
						</c:forEach>
						<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重写">
		 			</form>
				</c:when>
				<c:otherwise>
					<c:forEach items="${examList}" var="exam">
							<div style="line-height: 35px; font-size: 14px;padding-right:15px;">  
								${exam.title}
							</div>
							<ul id="s_2" style="padding-left:10px;">
			                 	<li>
			                		<input type="hidden" name="${exam.id} " value="A"/>&nbsp;&nbsp;A
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseA}</a>
			              		</li>
			              		<li>
			                		<input type="hidden" name="${exam.id}" value="B"/>&nbsp;&nbsp;B
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseB}</a>							
			              		</li>
			              		<li>
			                		<input type="hidden" name="${exam.id}" value="C"/>&nbsp;&nbsp;C
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseC}</a>
			              		</li>
			              		<li>
			                		<input type="hidden" name="${exam.id}" value="D"/>&nbsp;&nbsp;D
			                		<a style="padding-left:10px;word-break: break-all;">${exam.chooseD}</a>						
			              		</li>
			              		<br/>
			              		这道题您做<span style="color: red;font-weight:900">${resultMap[exam.id].result}</span>了！<br/>
			            		您选择的是：<span style="color: red;font-weight:900">${resultMap[exam.id].yourAnswer}</span><br/>
								正确答案是：<span style="color: red;font-weight:900">${resultMap[exam.id].trueAnswer}</span>
			            	</ul>
						</c:forEach>
						<br/>
					<span style="color: red;font-weight:900">您的总分为:${num}分</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>