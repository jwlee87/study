package kr.co.mlec.repository.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.vo.MemberVO;

@Repository
public class LoginMapper {
	private SqlSession sqlMapper;
	public LoginMapper() {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}
	public MemberVO getMemberInfo(String id) {
		System.out.println("sqlMapper : " + sqlMapper);
		//회원
		MemberVO member = sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.LoginMapper.getPass", id);

		return member;
	}

}
