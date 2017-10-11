package kr.co.mlec.login.service;

import kr.co.mlec.repository.vo.MemberVO;

public interface LoginService {
	public MemberVO login(String id) throws Exception;
}
