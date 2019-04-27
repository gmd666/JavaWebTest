package exam.service;

import java.util.ArrayList;
import java.util.List;

import exam.dao.ExamDao;
import exam.domain.Exam;

public class ExamService {
	private ExamDao examDao = new ExamDao();

	public void addExam(ArrayList<Exam> examlist) {
		examDao.addExam(examlist);
	}

	public List<Exam> select(String id) {
		return examDao.select(id);
	}
	
}
