package answer.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import answer.domain.Answer;
import cn.itcast.jdbc.TxQueryRunner;

public class AnswerDao {
	private  QueryRunner qr = new TxQueryRunner();
	
	//添加答案数据
	public void addAnswer(Answer answer) {
			String sql = "insert into examanswer values(?,?)";
			Object [] params = {answer.getId(),answer.getAnswer()};
			try {
				qr.update(sql, params);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}

	public String findById(String id) {
		String sql = "select answer from examanswer where id = ?";
		try {
			Answer examAnswer = qr.query(sql, new BeanHandler<Answer>(Answer.class), id);
			return examAnswer.getAnswer();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	
}
