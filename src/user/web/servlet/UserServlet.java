package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import answer.domain.Answer;
import answer.service.AnswerService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import exam.domain.Exam;
import exam.service.ExamService;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import user.domain.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private AnswerService answerService = new AnswerService();
	private ExamService examService = new ExamService();
	private int length = 0;
	/**一。管理员登陆
	 * 登录功能；
	 * 验证用户名和密码是否正确；
	 * 保存到errors,转发到AdminLogin.jsp；
	 * 输入正确；
	 * 转发到Admin.jsp；
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<String,String> errors = new HashMap<String, String>();
			
			String username = request.getParameter("username");
			if(username == null || username.trim().isEmpty()) {
				errors.put("username", "用户名不能为空");
			}else if(!username.equals("gmd")) {
				errors.put("username", "用户名不正确");
			}
			
			String password = request.getParameter("password");
			if(password==null || password.trim().isEmpty()) {
				errors.put("password", "密码不能为空");
			}else if(!password.equals("123456")) {
				errors.put("password", "密码错误");
			}
			
			if(errors.size()>0) {
				request.setAttribute("errors", errors);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				return "f:/AdminLogin.jsp";
			}
			
		return "f:/Admin.jsp";
	}
	/**二。试题发布；
	 * 1.试题的写入和发布；
	 * 1.1题号和答案写入数据库；
	 * 1.2题目和选项写入数据库；
	 * 1.3将题目和选项储存到数据库中去；
	 * 2.创建数据库。exam_content
	 * 2.1设置参数；
	 * 2.2设置选项的名称
	 * 3.创建以一个题目类；title
	 * 3.1设置四个参数，题目，A,B,C,D;
	 * 
	 */
	public String examRelease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.生成考试编号；
		 * 2.生成考试答案；
		 * 封装到数据库；
		 */
		Answer answer = new Answer();
		String id = CommonUtils.uuid();//本场考试的id;
		
		answer.setId(id);
		String allAnswer = findAllAnswer(request);//得到全部考试答案；
		
		//检验试题数答案数目是否符合标准
		if(allAnswer.length()!=length) {
			//System.out.println(allAnswer.length()+" "+length);
			request.setAttribute("msg", "答案数量与题目数量不符，请重新发布！");
			return "f:/Admin.jsp";
		}
		try {
			answer.setAnswer(allAnswer);
			answerService.upAnswer(answer);
		} catch (Exception e) {
			request.setAttribute("msg", "答案数据未保存成功请重新添加！");
			return "f:/Admin.jsp";
		}
		/*
		 * 题目和选项内容发送到数据库；
		 * 1.使用循环获取，页面的内容。
		 * 2.调用service方法；
		 * 3.每个题目都使用考试的id;
		 */
		try {
			ArrayList<Exam> examlist = findAllText(request,id);
			examService.addExam(examlist);
		} catch (Exception e) {
			request.setAttribute("msg", "题目数据未保存成功请重新添加！");
			return "f:/Admin.jsp";
		}
		
		request.setAttribute("msg", "保存成功！请前往发布页面或者继续添加试题");
		request.setAttribute("id", id);
		return "f:/Admin.jsp";
	}
	/**
	 * 获取所有文本内容；
	 * @param request
	 * @param id 
	 * @return
	 */
	private ArrayList<Exam> findAllText(HttpServletRequest request, String id) {
		ArrayList<Exam> examList = new ArrayList<Exam>();
		for (int i = 1; i <=length; i++) {
			Exam exam = new Exam();
			StringBuffer index = new StringBuffer("title_");
			StringBuffer Tid = new StringBuffer(id);
			index.append(i);
			Tid.append("_").append(i-1);
			exam.setId(Tid.toString());
			exam.setTitle(request.getParameter(index.toString()));//获取题目；
			int num = i*10+1;
			exam.setChooseA(request.getParameter(Integer.toString(num++)));
			exam.setChooseB(request.getParameter(Integer.toString(num++)));
			exam.setChooseC(request.getParameter(Integer.toString(num++)));
			exam.setChooseD(request.getParameter(Integer.toString(num++)));
			examList.add(exam);
		}
		return examList;
	}
	/**
	 * 获取所有答案；
	 * 定义一个stringbuffer类型，利用循环不断改变参数；
	 * @return
	 */
	public String findAllAnswer(HttpServletRequest request) {
		StringBuffer allAnswer = new StringBuffer();
		
		//循环改变参数并获取结果；
		for(int i=1;i<=10;i++) {
			StringBuffer index = new StringBuffer("answer_");
			index.append(i);
			String answer = request.getParameter(index.toString());
			if(answer==null || answer.trim().isEmpty()) {
				length=i-1;
				break;
			} else allAnswer.append(answer);
		}
		return allAnswer.toString();
	}
	/**
	 *获取数据库中的试题到练习页面
	 *数据库练习题以列表的形式发送到jsp
	 *
	 */
	public String examOpen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 获取考试id;
		 * 通过id模糊查询
		 * 返回为list，保存到jsp;
		 */
		String id = request.getParameter("id");
		
		try {
			List<Exam> examList = (List<Exam>) examService.select(id);
			request.setAttribute("examList", examList);
			request.setAttribute("id", id);
			return "f:/Practice.jsp";
		} catch (Exception e) {
			request.setAttribute("msg","试题获取失败！");
			return "f:/Practice.jsp";
		}
		
	}
	/**
	 * 从答题页面获取所有的答案数据,通过id获取考试答案数据；
	 * 通过两份数据的对比得到正确的结果；一次获取所有的答案；
	 * 使用循环来进行答案的比对；
	 * 1.获取页面数据的答案；
	 * 1.1解决jsp页面的数据提交问题；
	 * 1.2根据id获取提交的结果,传送
	 * 2.根据id获取本次考试的答案；
	 * 获取id根据id得到数据中的标准答案；
	 * 
	 * 3.创建map集合，循环对比答案，并保存结果；
	 * 根据得到的答案和对比的结果，对每道题的结果都以id为键进行保存
	 * 针对每一次的考试都要有专门的统计总分
	 * 3.1回显操作；在jsp中增加判断语句,判断error是否为空。
	 * 3.2如果不为空进行显示结果操作；
	 */
	public String judgeAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String examAnswer;
		int num=0;//总分；
		//获取用户考试答案；
		String userAllAnswer = findUserAnswer(request);
		//获取数据库标准答案；
		String id  = request.getParameter("id");
		try {
			examAnswer = answerService.findById(id);
		} catch (Exception e) {
			request.setAttribute("msg", "获取答案失败!");
			return "f:/Practice.jsp";
		}
		//对比答案；将结果保存道errors集合；
		Map<String,User> resultMap = new HashMap<String, User>();
		for(int i=0;i<length;i++) {
			StringBuffer key = new StringBuffer(id);
			User user = new User();
			
			key.append("_").append(i);
			if(examAnswer.charAt(i)==userAllAnswer.charAt(i)) {
				user.setTrueAnswer(examAnswer.charAt(i));
				user.setYourAnswer(userAllAnswer.charAt(i));
				user.setResult("对");
				resultMap.put(key.toString(), user);
				num+=10;
			}else {
				user.setTrueAnswer(examAnswer.charAt(i));
				user.setYourAnswer(userAllAnswer.charAt(i));
				user.setResult("错");
				resultMap.put(key.toString(), user);
			}
		}
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("num", num);
		return examOpen(request, response);
	}
	/**
	 * 循环获取用户的答案；
	 * 根据id;
	 * @param request
	 * @return
	 */
	private String findUserAnswer(HttpServletRequest request) {
		String sId = request.getParameter("id");
		StringBuffer userAnswer = new StringBuffer();
		for(int i=0;i<length;i++) {
			StringBuffer index = new StringBuffer(sId);
			index.append("_").append(i);
			userAnswer.append(request.getParameter(index.toString()));
		}
		return userAnswer.toString();
	}
}
