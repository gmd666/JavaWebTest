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
	/**һ������Ա��½
	 * ��¼���ܣ�
	 * ��֤�û����������Ƿ���ȷ��
	 * ���浽errors,ת����AdminLogin.jsp��
	 * ������ȷ��
	 * ת����Admin.jsp��
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<String,String> errors = new HashMap<String, String>();
			
			String username = request.getParameter("username");
			if(username == null || username.trim().isEmpty()) {
				errors.put("username", "�û�������Ϊ��");
			}else if(!username.equals("gmd")) {
				errors.put("username", "�û�������ȷ");
			}
			
			String password = request.getParameter("password");
			if(password==null || password.trim().isEmpty()) {
				errors.put("password", "���벻��Ϊ��");
			}else if(!password.equals("123456")) {
				errors.put("password", "�������");
			}
			
			if(errors.size()>0) {
				request.setAttribute("errors", errors);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				return "f:/AdminLogin.jsp";
			}
			
		return "f:/Admin.jsp";
	}
	/**�������ⷢ����
	 * 1.�����д��ͷ�����
	 * 1.1��źʹ�д�����ݿ⣻
	 * 1.2��Ŀ��ѡ��д�����ݿ⣻
	 * 1.3����Ŀ��ѡ��浽���ݿ���ȥ��
	 * 2.�������ݿ⡣exam_content
	 * 2.1���ò�����
	 * 2.2����ѡ�������
	 * 3.������һ����Ŀ�ࣻtitle
	 * 3.1�����ĸ���������Ŀ��A,B,C,D;
	 * 
	 */
	public String examRelease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.���ɿ��Ա�ţ�
		 * 2.���ɿ��Դ𰸣�
		 * ��װ�����ݿ⣻
		 */
		Answer answer = new Answer();
		String id = CommonUtils.uuid();//�������Ե�id;
		
		answer.setId(id);
		String allAnswer = findAllAnswer(request);//�õ�ȫ�����Դ𰸣�
		
		//��������������Ŀ�Ƿ���ϱ�׼
		if(allAnswer.length()!=length) {
			//System.out.println(allAnswer.length()+" "+length);
			request.setAttribute("msg", "����������Ŀ���������������·�����");
			return "f:/Admin.jsp";
		}
		try {
			answer.setAnswer(allAnswer);
			answerService.upAnswer(answer);
		} catch (Exception e) {
			request.setAttribute("msg", "������δ����ɹ���������ӣ�");
			return "f:/Admin.jsp";
		}
		/*
		 * ��Ŀ��ѡ�����ݷ��͵����ݿ⣻
		 * 1.ʹ��ѭ����ȡ��ҳ������ݡ�
		 * 2.����service������
		 * 3.ÿ����Ŀ��ʹ�ÿ��Ե�id;
		 */
		try {
			ArrayList<Exam> examlist = findAllText(request,id);
			examService.addExam(examlist);
		} catch (Exception e) {
			request.setAttribute("msg", "��Ŀ����δ����ɹ���������ӣ�");
			return "f:/Admin.jsp";
		}
		
		request.setAttribute("msg", "����ɹ�����ǰ������ҳ����߼����������");
		request.setAttribute("id", id);
		return "f:/Admin.jsp";
	}
	/**
	 * ��ȡ�����ı����ݣ�
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
			exam.setTitle(request.getParameter(index.toString()));//��ȡ��Ŀ��
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
	 * ��ȡ���д𰸣�
	 * ����һ��stringbuffer���ͣ�����ѭ�����ϸı������
	 * @return
	 */
	public String findAllAnswer(HttpServletRequest request) {
		StringBuffer allAnswer = new StringBuffer();
		
		//ѭ���ı��������ȡ�����
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
	 *��ȡ���ݿ��е����⵽��ϰҳ��
	 *���ݿ���ϰ�����б����ʽ���͵�jsp
	 *
	 */
	public String examOpen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * ��ȡ����id;
		 * ͨ��idģ����ѯ
		 * ����Ϊlist�����浽jsp;
		 */
		String id = request.getParameter("id");
		
		try {
			List<Exam> examList = (List<Exam>) examService.select(id);
			request.setAttribute("examList", examList);
			request.setAttribute("id", id);
			return "f:/Practice.jsp";
		} catch (Exception e) {
			request.setAttribute("msg","�����ȡʧ�ܣ�");
			return "f:/Practice.jsp";
		}
		
	}
	/**
	 * �Ӵ���ҳ���ȡ���еĴ�����,ͨ��id��ȡ���Դ����ݣ�
	 * ͨ���������ݵĶԱȵõ���ȷ�Ľ����һ�λ�ȡ���еĴ𰸣�
	 * ʹ��ѭ�������д𰸵ıȶԣ�
	 * 1.��ȡҳ�����ݵĴ𰸣�
	 * 1.1���jspҳ��������ύ���⣻
	 * 1.2����id��ȡ�ύ�Ľ��,����
	 * 2.����id��ȡ���ο��ԵĴ𰸣�
	 * ��ȡid����id�õ������еı�׼�𰸣�
	 * 
	 * 3.����map���ϣ�ѭ���Աȴ𰸣�����������
	 * ���ݵõ��Ĵ𰸺ͶԱȵĽ������ÿ����Ľ������idΪ�����б���
	 * ���ÿһ�εĿ��Զ�Ҫ��ר�ŵ�ͳ���ܷ�
	 * 3.1���Բ�������jsp�������ж����,�ж�error�Ƿ�Ϊ�ա�
	 * 3.2�����Ϊ�ս�����ʾ���������
	 */
	public String judgeAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String examAnswer;
		int num=0;//�ܷ֣�
		//��ȡ�û����Դ𰸣�
		String userAllAnswer = findUserAnswer(request);
		//��ȡ���ݿ��׼�𰸣�
		String id  = request.getParameter("id");
		try {
			examAnswer = answerService.findById(id);
		} catch (Exception e) {
			request.setAttribute("msg", "��ȡ��ʧ��!");
			return "f:/Practice.jsp";
		}
		//�Աȴ𰸣�����������errors���ϣ�
		Map<String,User> resultMap = new HashMap<String, User>();
		for(int i=0;i<length;i++) {
			StringBuffer key = new StringBuffer(id);
			User user = new User();
			
			key.append("_").append(i);
			if(examAnswer.charAt(i)==userAllAnswer.charAt(i)) {
				user.setTrueAnswer(examAnswer.charAt(i));
				user.setYourAnswer(userAllAnswer.charAt(i));
				user.setResult("��");
				resultMap.put(key.toString(), user);
				num+=10;
			}else {
				user.setTrueAnswer(examAnswer.charAt(i));
				user.setYourAnswer(userAllAnswer.charAt(i));
				user.setResult("��");
				resultMap.put(key.toString(), user);
			}
		}
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("num", num);
		return examOpen(request, response);
	}
	/**
	 * ѭ����ȡ�û��Ĵ𰸣�
	 * ����id;
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
