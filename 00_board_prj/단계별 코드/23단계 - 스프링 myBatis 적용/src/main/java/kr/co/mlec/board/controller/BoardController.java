package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.mlec.repository.mapper.BoardMapper;
import kr.co.mlec.repository.vo.BoardCommentVO;
import kr.co.mlec.repository.vo.BoardFileVO;
import kr.co.mlec.repository.vo.BoardVO;
import kr.co.mlec.repository.vo.PageResultVO;
import kr.co.mlec.repository.vo.SearchVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper dao;
	
	@RequestMapping("/board/write.do")
	public String write(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {
		
		ServletContext context = mRequest.getServletContext();
		String path = context.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		BoardVO board = new BoardVO();
		board.setTitle(mRequest.getParameter("title"));
		board.setWriter(mRequest.getParameter("writer"));
		board.setContent(mRequest.getParameter("content"));;
		
		int no = dao.insertBoard(board);
				
		// 게시물 저장 처리 부탁..
		MultipartFile  file = mRequest.getFile("attachFile");
		String oriName = file.getOriginalFilename();
		if (oriName != null && !oriName.equals("")) {
			// 확장자 처리
			String ext = "";
			// 뒤쪽에 있는 . 의 위치 
			int index = oriName.lastIndexOf(".");
			if (index != -1) {
				// 파일명에서 확장자명(.포함)을 추출
				ext = oriName.substring(index);
			}
			
			// 파일 사이즈
			long fileSize = file.getSize();
			System.out.println("파일 사이즈 : " + fileSize);
			
			// 고유한 파일명 만들기	
			String systemName = "mlec-" + UUID.randomUUID().toString() + ext;
			System.out.println("저장할 파일명 : " + systemName);
		
			// 임시저장된 파일을 원하는 경로에 저장
			file.transferTo(new File(savePath + "/" + systemName));
						
			BoardFileVO boardFile = new BoardFileVO();
			boardFile.setNo(no);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			dao.insertBoardFile(boardFile);
		}
		attr.addFlashAttribute("msg", "게시물이 등록되었습니다");
		return "redirect:list.do";
	}

	@RequestMapping("/board/updateForm.do")
	public void updateForm(int no, Model model) throws Exception {
		model.addAttribute("board", dao.selectOneBoard(no));
	}
	
	@RequestMapping("/board/update.do")
	public String update(BoardVO board, RedirectAttributes attr) throws Exception {
		dao.updateBoard(board);

		attr.addFlashAttribute("msg", "게시물이 수정되었습니다");
		return "redirect:list.do";
	}
	
	@RequestMapping("/board/list.do")
	public void list(SearchVO search, Model model) throws Exception {
		model.addAttribute("list", dao.selectBoard(search));
		model.addAttribute("pageResult", new PageResultVO(search.getPageNo(), dao.selectBoardCount(search)));
	}
	
	@RequestMapping("/board/detail.do")
	public void detail(@RequestParam(value="no") int no, Model model) throws Exception {
		model.addAttribute("boardVO", dao.selectOneBoard(no));
		model.addAttribute("file", dao.selectBoardFileByNo(no));
	}
	
	@RequestMapping("/board/delete.do")
	public String delete(int no, RedirectAttributes attr) throws Exception {
		dao.deleteBoard(no);
		
		attr.addFlashAttribute("msg", "게시물이 삭제되었습니다");
		return "redirect:list.do";
	}
	
	@RequestMapping("/board/commentUpdate.do")
	@ResponseBody
	public List<BoardCommentVO> commentUpdate(BoardCommentVO comment) throws Exception {
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		dao.updateBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}
	
	@RequestMapping("/board/commentRegist.do")
	@ResponseBody
	public List<BoardCommentVO> commentRegist(BoardCommentVO comment) throws Exception {
		dao.insertBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}
	
	@RequestMapping("/board/commentList.do")
	@ResponseBody
	public List<BoardCommentVO> commentList(int no, SearchVO search) throws Exception {
		return dao.selectBoardCommentByNo(no);
	}
	
	@RequestMapping("/board/commentDelete.do")
	@ResponseBody
	public List<BoardCommentVO> commentDelete(BoardCommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getCommentNo());
		return dao.selectBoardCommentByNo(comment.getNo());
	}
}




















