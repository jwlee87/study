package kr.co.mlec.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.repository.vo.MemberVO;

@Repository
public class LoginMapper {
	
	@Autowired
	private SqlSessionTemplate sqlMapper;
	
	public MemberVO getMemberInfo(String id) {
		System.out.println("sqlMapper : " + sqlMapper);
		//회원
		MemberVO member = sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.LoginMapper.getPass", id);
		return member;
	}

}
