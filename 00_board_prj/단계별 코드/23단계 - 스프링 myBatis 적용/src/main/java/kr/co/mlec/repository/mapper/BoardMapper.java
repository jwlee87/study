package kr.co.mlec.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.repository.vo.BoardCommentVO;
import kr.co.mlec.repository.vo.BoardFileVO;
import kr.co.mlec.repository.vo.BoardVO;
import kr.co.mlec.repository.vo.SearchVO;

@Repository
public class BoardMapper {
	
	@Autowired
	private SqlSessionTemplate sqlMapper;
	
	// 전체 게시글 조회
	public List<BoardVO> selectBoard(SearchVO search) {
		return sqlMapper.selectList("kr.co.mlec.repository.mapper.BoardMapper.selectBoard", search);
	}
	
	// 전체 게시글 조회
	public int selectBoardCount(SearchVO search) {
		return sqlMapper.selectOne("kr.co.mlec.repository.mapper.BoardMapper.selectBoardCount", search);
	}
	
	
	// 글번호에 해당하는 게시물 조회
	public BoardVO selectOneBoard(int no) {
		return sqlMapper.selectOne("kr.co.mlec.repository.mapper.BoardMapper.getBoardOne", no);
	}
	
	// 글등록
	public int insertBoard(BoardVO board) {
		sqlMapper.insert("kr.co.mlec.repository.mapper.BoardMapper.insertBoard", board);
		return board.getNo();
	}
	
	// 글수정
	public boolean updateBoard(BoardVO vo) {
		sqlMapper.update("kr.co.mlec.repository.mapper.BoardMapper.updateBoard", vo);
        return true;
	}
    // 글삭제
	public boolean deleteBoard(int no) {
		sqlMapper.delete("kr.co.mlec.repository.mapper.BoardMapper.deleteBoard", no);
		return true;
	}
	
	/* =================================================== */
	/* 파일 관련                                             */
	/* =================================================== */
	public void insertBoardFile(BoardFileVO boardFile) {
		sqlMapper.insert("kr.co.mlec.repository.mapper.BoardMapper.insertBoardFile", boardFile);
	}
	
	public BoardFileVO selectBoardFileByNo(int no) {
		return sqlMapper.selectOne("kr.co.mlec.repository.mapper.BoardMapper.selectBoardFileByNo", no);
	}
	
	
	/* =================================================== */
	/* 댓글 관련                                             */
	/* =================================================== */
	public void insertBoardComment(BoardCommentVO comment) {
		sqlMapper.insert("kr.co.mlec.repository.mapper.BoardMapper.insertBoardComment", comment);
	}
	public List<BoardCommentVO> selectBoardCommentByNo(int no) {
		return sqlMapper.selectList("kr.co.mlec.repository.mapper.BoardMapper.selectBoardCommentByNo", no);
	}
	public void deleteBoardComment(int commentNo) {
		sqlMapper.delete("kr.co.mlec.repository.mapper.BoardMapper.deleteBoardComment", commentNo);
	}
	public void updateBoardComment(BoardCommentVO comment) {
		sqlMapper.update("kr.co.mlec.repository.mapper.BoardMapper.updateBoardComment", comment);
	}
}














