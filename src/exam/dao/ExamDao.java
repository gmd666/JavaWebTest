package exam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.itcast.jdbc.TxQueryRunner;
import exam.domain.Exam;

public class ExamDao {
	private QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 添加考试题目；
	 * @param exam
	 */
	public void addExam(ArrayList<Exam> examlist) {
		String sql = "insert into exam values(?,?,?,?,?,?)";
		try {
			Object [][] params = new Object[examlist.size()][];
			for(int i=0;i<examlist.size();i++) {
				Exam exam = examlist.get(i);
				params [i] = new Object[] {exam.getId(),exam.getTitle(),exam.getChooseA(),exam.getChooseB(),exam.getChooseC(),exam.getChooseD()};
			}
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	/**
	 * 根据id进行模糊查询；
	 * @param id
	 * @return
	 */
	public List<Exam> select(String id) {
		
		String sql = "select * from exam where id like ?";
		String index = "%"+id+"%";
		try {
			List list=(List)qr.query(sql, new BeanListHandler<Exam>(Exam.class),index);
			return list;
		} catch (SQLException e) {
			System.out.println("数据库异常！");
			throw new RuntimeException(e);
		}
	}
}
