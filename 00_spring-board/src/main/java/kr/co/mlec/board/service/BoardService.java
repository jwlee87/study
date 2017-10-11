package kr.co.mlec.board.service;

import java.util.List;
import java.util.Map;

import kr.co.mlec.repository.vo.BoardCommentVO;
import kr.co.mlec.repository.vo.BoardVO;
import kr.co.mlec.repository.vo.SearchVO;

public interface BoardService {
	public void write(Map<String, Object> param) throws Exception;
	
	public BoardVO updateForm(int no) throws Exception;
	
	public void update(BoardVO board) throws Exception;	

	public Map<String, Object> list(SearchVO search) throws Exception;
	
	public Map<String, Object> detail(int no) throws Exception;
	
	public void delete(int no) throws Exception;
	
	public List<BoardCommentVO> commentUpdate(BoardCommentVO comment) throws Exception ;
	
	public List<BoardCommentVO> commentRegist(BoardCommentVO comment) throws Exception;
	
	public List<BoardCommentVO> commentList(int no) throws Exception ;
	
	public List<BoardCommentVO> commentDelete(BoardCommentVO comment) throws Exception ;
}
