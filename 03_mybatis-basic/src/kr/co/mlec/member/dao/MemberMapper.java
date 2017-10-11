package kr.co.mlec.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.member.vo.MemberVO;
import kr.co.mlec.member.vo.SearchVO;

public class MemberMapper {

	private static SqlSession sqlMapper;
	
	public MemberMapper() throws Exception {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
		System.out.println(sqlMapper);
//		test01();  // 결과값이 하나의 행이 반환
//		test02();  // 결과값이 여러개의 행이 반환
//		insertMember();
//		updateMember();
//		deleteMember();
//		selectForeach();
		dynamicSelect();
	}
	
	public void test01() throws Exception {
		/*
		MemberVO member = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberInfo1", "member-1");
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());
		
		MemberVO param = new MemberVO();
		param.setName("sbc");
		param.setEmail("sbc@yahoo.co.kr");
		
		MemberVO member = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberInfo2", param);
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());		
		
		String id = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberInfo3", "jsp");
		System.out.println("회원 아이디 : " + id);
		 */
		int count = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberInfo4");
		System.out.println("전체 회원수 : " + count);
				
	}

	private void test02() throws Exception {
		List<MemberVO> list = sqlMapper.selectList(
//				"kr.co.mlec.member.dao.MemberMapper.getMemberList1");
				"kr.co.mlec.member.dao.MemberMapper.getMemberList2");
		for (MemberVO member : list) {
			System.out.println(
					member.getId() + ", " + 
					member.getName() + ", " + 
					member.getEmail() + ", " + 
					member.getAddr() + ", " +
					member.getJoinDate()
			);
		}
	}

	private void insertMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("member-5");
		member.setName("me");
		member.setAddr("Seoul");
		member.setEmail("me@yahoo.co.kr");
		sqlMapper.insert(
				"kr.co.mlec.member.dao.MemberMapper.insertMember", member);
		sqlMapper.commit();
		System.out.println("행이 추가되었습니다.");
		// 입력된 내용 확인
		test02();
	}
	
	private void updateMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("member-5");
		member.setAddr("pusan");
		sqlMapper.update(
				"kr.co.mlec.member.dao.MemberMapper.updateMember", member);
		sqlMapper.commit();
		System.out.println("행이 변경되었습니다.");
	}
	
	private void deleteMember() throws Exception {
		sqlMapper.delete(
				"kr.co.mlec.member.dao.MemberMapper.deleteMember", "member-5");
		sqlMapper.commit();
		System.out.println("삭제되었습니다");
	}
	
	private void selectForeach() throws Exception {
		MemberVO param = new MemberVO();
		param.setName("sbc");
		param.setAddrs(new String[] {"seoul", "pusan"});
		List<MemberVO> list = sqlMapper.selectList(
			"kr.co.mlec.member.dao.MemberMapper.getMemberIteratorList", param	
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
	}
	
	private void dynamicSelect( ) throws Exception {
		SearchVO param = new SearchVO();
		param.setSearchType("id");
		param.setSearchWord("mem");
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.getMemberDynamicList2", param
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		
		
		
		/*
		MemberVO param = new MemberVO();
		param.setId("mem");
//		param.setName("sbc");

		List<MemberVO> list = sqlMapper.selectList(
			"kr.co.mlec.member.dao.MemberMapper.getMemberDynamicList1", param
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		*/
		
		/*
		MemberVO param = new MemberVO();
		param.setName("s");
		param.setEmail("yahoo");
		
		List<MemberVO> list = sqlMapper.selectList(
			"kr.co.mlec.member.dao.MemberMapper.getMemberIncludeList", param
		);

		int count = sqlMapper.selectOne(
			"kr.co.mlec.member.dao.MemberMapper.getMemberIncludeListCount", param
		);
		
		System.out.println("전체 : " + count + "명");
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		*/
	}

	public static void main(String[] args) {
		try {
			new MemberMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









