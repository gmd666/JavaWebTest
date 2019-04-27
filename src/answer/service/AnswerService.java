package answer.service;

import answer.dao.AnswerDao;
import answer.domain.Answer;

public class AnswerService {
	private AnswerDao answerDao = new AnswerDao();
	
	/**
	 *插入数据
	 * @param answer
	 */
	public void upAnswer(Answer answer) {
		answerDao.addAnswer(answer);
	}
	/**
	 * 根据id来获取答案；
	 * @param id
	 * @return
	 */
	public String findById(String id) {
		return answerDao.findById(id);
	}
}
