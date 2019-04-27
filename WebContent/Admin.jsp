<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>试题发布页面</title>
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
<!-- 项目发布页的内容，包含有题目，选项，答案，内容部分可以使用练习页的内容；文本-->
<!-- 文本域，选项，选项结果 -->
	<h1 align="center">练习题发布页</h1>
	<div id="select">
		<span style="color: red;float: center;font-weight:900">${msg}</span>
		<form action="<c:url value='/UserServlet?method=examOpen&id=${id} '/>" method="post">
			<input type="submit" style="float: right;" value="试题发布">
		</form>
		<h2>一.单选题(共10题，每题10分)</h2>
		<div id="s_1">
			<form action="<c:url value='/UserServlet?method=examRelease'/>" method="post">
	 			<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_1"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_1" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="11" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_1" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="12" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_1" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="13" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_1" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="14" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_2"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_2" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="21" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_2" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="22" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_2" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="23" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_2" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="24" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_3"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_3" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="31" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_3" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="32" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_3" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="33" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_3" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="34" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_4"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_4" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="41" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_4" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="42" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_4" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="43" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_4" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="44" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_5"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_5" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="51" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_5" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="52" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_5" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="53" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_5" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="54" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_6"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_6" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="61" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_6" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="62" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_6" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="63" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_6" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="64" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_7"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_7" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="71" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_7" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="72" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_7" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="73" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_7" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="74" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_8"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_8" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="81" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_8" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="82" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_8" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="83" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_8" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="84" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_9"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_9" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="91" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_9" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="92" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_9" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="93" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_9" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="94" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<div style="line-height: 35px; font-size: 20px;padding-right:15px;">  
				<textarea rows="5" cols="100" name="title_10"></textarea>
				</div>
				<ul id="s_2" style="padding-left:10px;">
                 	<li>
                		<input type="radio" name="answer_10" value="A"/>&nbsp;&nbsp;A
                		<input type="text" name="101" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_10" value="B"/>&nbsp;&nbsp;B
                		<input type="text" name="102" style="padding-left:10px;word-break: break-all;"/>						
              		</li>
              		<li>
                		<input type="radio" name="answer_10" value="C"/>&nbsp;&nbsp;C
                		<input type="text" name="103" style="padding-left:10px;word-break: break-all;"/>
              		</li>
              		<li>
                		<input type="radio" name="answer_10" value="D"/>&nbsp;&nbsp;D
                		<input type="text" name="104" style="padding-left:10px;word-break: break-all;"/>					
              		</li>
            	</ul>
            	<input type="submit" value="提交试题到数据库">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重新编写">
	 		</form>
		</div>
	</div>
</body>
</html>