package ajax.quiz;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;

public class Exam01DAO {
	private static SqlSession sqlMapper;
	
	public Exam01DAO() throws Exception {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
		System.out.println(sqlMapper);
	}
	
	public Exam01VO selectMemberById(String id) throws Exception {
		Exam01VO member = sqlMapper.selectOne(
				"ajax.quiz.Exam01DAO.getMemberInfo", id);
		return member;
	}
}