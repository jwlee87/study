package kr.co.mlec.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.repository.mapper.LoginMapper;
import kr.co.mlec.repository.vo.MemberVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper dao;
	
	@Override
	public MemberVO login(String id) throws Exception {
		return dao.getMemberInfo(id);
	}

}
