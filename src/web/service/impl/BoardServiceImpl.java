package web.service.impl;

import java.io.UnsupportedEncodingException;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.BoardDao;
import web.dao.face.Board_commentDao;
import web.dao.impl.BoardDaoImpl;
import web.dao.impl.Board_commentDaoImpl;
import web.dto.Board;
import web.dto.Board_comment;
import web.service.face.BoardService;
import web.util.B_Paging;

public class BoardServiceImpl implements BoardService{

	//Dao 객체 생성
	private BoardDao boardDao = new BoardDaoImpl();
	private Board_commentDao board_commentDao= new Board_commentDaoImpl();
	
	
	@Override
	public List<Board> list() {
		
		//DAO selectAll로 조회 후 반환
		return boardDao.selectAll();
	}
	
	@Override
	public List<Board> nList() {
		return boardDao.selectNotice();
	}

	@Override
	public List<Board> fList() {
		return boardDao.selectFree();
	}
	
	@Override
	public List<Board> sList() {
		return boardDao.selectStudy();
	}

	@Override
	public B_Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			
		}
		//Board 테이블의 총 게시글 수 조회
		
		int totalCount = boardDao.selectCntAll();
		
		//Paging 객체 생성
		B_Paging paging = new B_Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public List<Board> list(B_Paging paging) {
		
	
		
		return boardDao.selectAll(paging);
	}

	@Override
	public Board getBoardno(HttpServletRequest req) {
		
//		board객체 생성
		Board boardno = new Board();
		
		// b_num 가져오기
		String param = req.getParameter("b_num");
		if(param!=null && !"".equals(param)) {
			
			boardno.setB_num(Integer.parseInt(param));
		}
		return boardno;
	}

	@Override
	public Board view(Board boardnum) {
		
		Board board = boardDao.selectBoardByBoardno(boardnum);
		if(board != null) {
			//게시글 조회수 증가
			boardDao.updateHit(boardnum);
			
		}
		
		return board;
	}

	@Override
	public String getName(Board viewBoard) {
		return boardDao.selectNameByUserid(viewBoard);
	}

	@Override
	public void boardInsert(HttpServletRequest req) {
		
		Board board = new Board();
		
		//게시글 작성자 id입력
		board.setUserid((int)req.getSession().getAttribute("userid"));
		
		//게시글 번호 생성 - Dao이용
		int boardnum = boardDao.selectBoardno();
		
		if(board != null) {
			
			//게시글 번호 입력
			board.setB_num(boardnum);
			
			//게시글 삽입
			boardDao.insertBoard(board);
		}
		
		
	}

	@Override
	public void boardDelete(Board board) {
		
		boardDao.deleteBoard(board);
	}

	@Override
	public void updateBoard(HttpServletRequest req) {
		
		Board board = null;
		
		board = new Board();
		
		if(board != null) {
				boardDao.boardUpdate(board);
		}
		
	}

	@Override
	public List<Board_comment> getCommentList(Board board) {
		
		return board_commentDao.selectComment(board);
	}

	@Override
	public Board_comment getComment(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String b_num = (String)req.getParameter("b_num");
		String userid = (String)req.getParameter("userid");
		String c_content = (String)req.getParameter("content");
		
		Board_comment comment = new Board_comment();
		
		comment.setB_num(Integer.parseInt("b_num"));
		comment.setUserid(Integer.parseInt("userid"));
		comment.setC_content(c_content);
		
		return comment;
	}

	@Override
	public void insertComment(Board_comment comment) {
		board_commentDao.insertComment(comment);
	}

	@Override
	public boolean deleteComment(Board_comment comment) {
		board_commentDao.deleteComment(comment);
		
		if( board_commentDao.countComment(comment) > 0) {
			
			return false;
		}else {
			return true;
		}
		
	}




}
