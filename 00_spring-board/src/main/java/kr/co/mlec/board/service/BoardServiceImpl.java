package kr.co.mlec.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.repository.mapper.BoardMapper;
import kr.co.mlec.repository.vo.BoardCommentVO;
import kr.co.mlec.repository.vo.BoardFileVO;
import kr.co.mlec.repository.vo.BoardVO;
import kr.co.mlec.repository.vo.PageResultVO;
import kr.co.mlec.repository.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper dao;
	
	@Override
	public void write(Map<String, Object> param) throws Exception {
		BoardVO board = (BoardVO)param.get("board");
		dao.insertBoard(board);
		BoardFileVO boardFile = (BoardFileVO)param.get("boardFile");
		if (boardFile != null) {
			boardFile.setNo(board.getNo());
			dao.insertBoardFile(boardFile);
		}
	}

	@Override
	public BoardVO updateForm(int no) throws Exception {
		return dao.selectOneBoard(no);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		dao.updateBoard(board);
	}

	@Override
	public Map<String, Object> list(SearchVO search) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("list", dao.selectBoard(search));
		result.put("pageResult", new PageResultVO(search.getPageNo(), dao.selectBoardCount(search)));
		return result;
	}

	@Override
	public Map<String, Object> detail(int no) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("boardVO", dao.selectOneBoard(no));
		result.put("file", dao.selectBoardFileByNo(no));
		return result;
	}

	@Override
	public void delete(int no) throws Exception {
		dao.deleteBoard(no);
	}

	@Override
	public List<BoardCommentVO> commentUpdate(BoardCommentVO comment) throws Exception {
		dao.updateBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}

	@Override
	public List<BoardCommentVO> commentRegist(BoardCommentVO comment) throws Exception {
		dao.insertBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}

	@Override
	public List<BoardCommentVO> commentList(int no) throws Exception {
		return dao.selectBoardCommentByNo(no);
	}

	@Override
	public List<BoardCommentVO> commentDelete(BoardCommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getCommentNo());
		return dao.selectBoardCommentByNo(comment.getNo());
	}

}
