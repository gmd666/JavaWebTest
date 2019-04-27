package answer.service;

import answer.dao.AnswerDao;
import answer.domain.Answer;

public class AnswerService {
	private AnswerDao answerDao = new AnswerDao();
	
	/**
	 *��������
	 * @param answer
	 */
	public void upAnswer(Answer answer) {
		answerDao.addAnswer(answer);
	}
	/**
	 * ����id����ȡ�𰸣�
	 * @param id
	 * @return
	 */
	public String findById(String id) {
		return answerDao.findById(id);
	}
}
