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
import web.dto.Comment_comment;
import web.service.face.BoardService;
import web.util.B_Paging;

public class BoardServiceImpl implements BoardService{

	//Dao 객체 생성
	private BoardDao boardDao = new BoardDaoImpl();
	private Board_commentDao board_commentDao= new Board_commentDaoImpl();
	
	// ------------------------------ 게시판 목록 ------------------------------
	
	
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

	// -------------------------------게시판 페이징 -----------------------------
	
	
	@Override
	public B_Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			
		}
		//Board 테이블의 총 게시글 수 조회
		//검색어
		String search = req.getParameter("search");
		
		
		param = req.getParameter("search2");
		int search2 = 0;
		if( param!=null && !"".equals(param)) {
			search2 = Integer.parseInt(param);
		}
		
		
		int totalCount = boardDao.selectCntAll(search, search2);
		
		//Paging 객체 생성
		B_Paging paging = new B_Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);
		paging.setValue(search2);
		
		return paging;
	}

	@Override
	public B_Paging getNoticePaging(HttpServletRequest req) {
		//전달파라미터 curPage를 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			
		}
		
		String search = req.getParameter("search");
		
		
		param = req.getParameter("search2");
		int search2 = 0;
		if( param!=null && !"".equals(param)) {
			search2 = Integer.parseInt(param);
		}
		
		
		//Board 테이블의 총 게시글 수 조회
		int totalCount = boardDao.selectNoticeCntAll(search, search2);
		
		//Paging 객체 생성
		B_Paging paging = new B_Paging(totalCount, curPage);
		paging.setSearch(search);
		paging.setValue(search2);
		return paging;
		
	}

	
	
	@Override
	public B_Paging getStudyPaging(HttpServletRequest req) {
		
				//전달파라미터 curPage를 파싱
		
				String param = req.getParameter("curPage");
				int curPage = 0;
				if( param!=null && !"".equals(param)) {
					curPage = Integer.parseInt(param);
					
				}
				//Board 테이블의 총 게시글 수 조회
				String search = req.getParameter("search");
				
				param = req.getParameter("search2");
				int search2 = 0;
				if( param!=null && !"".equals(param)) {
					search2 = Integer.parseInt(param);
				}
				
				
				int totalCount = boardDao.selectStudyCntAll(search, search2);
				//Paging 객체 생성
				B_Paging paging = new B_Paging(totalCount, curPage);
				paging.setSearch(search);
				paging.setValue(search2);
				return paging;
	}
	
	@Override
	public B_Paging getFreePaging(HttpServletRequest req) {

		//전달파라미터 curPage를 파싱

			String param = req.getParameter("curPage");
			int curPage = 0;
			if( param!=null && !"".equals(param)) {
				curPage = Integer.parseInt(param);
				
			}
			String search = (String)req.getParameter("search");
			//Board 테이블의 총 게시글 수 조회
			param = req.getParameter("search2");
			
			int search2 = 0;
			if( param!=null && !"".equals(param)) {
				search2 = Integer.parseInt(param);
			}
			
			
			int totalCount = boardDao.selectFreeCntAll(search, search2);
			//Paging 객체 생성
			B_Paging paging = new B_Paging(totalCount, curPage);
			paging.setSearch(search);
			paging.setValue(search2);
			return paging;
			
			
	}


	// -------------------------------------------------------------
	@Override
	public List<Board> list(B_Paging paging) {
		
	
		
		return boardDao.selectAll(paging);
	}
//	@Override
//	public List<Board> list(int category, B_Paging paging) {
//		
//		
//		
//		return boardDao.selectAll(category, paging);
//	}

	@Override
	public List<Board> nList(B_Paging paging) {
		
		return boardDao.selectNotice(paging);
	}

	@Override
	public List<Board> fList(B_Paging paging) {
		
		return boardDao.selectFree(paging);
	}

	@Override
	public List<Board> sList(B_Paging paging) {
		
		return boardDao.selectStudy(paging);
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
//		System.out.println("게시글번호 확인!" + boardno);
		return boardno;
	}
	
	@Override
	public Board_comment getCommentno(HttpServletRequest req) {
		
		Board_comment commentno = new Board_comment();
		
		// c_num 가져오기
		String param = req.getParameter("c_num");
		if(param!=null && !"".equals(param)) {
			
			commentno.setC_num(Integer.parseInt(param));
		}
//		System.out.println("ServiceImpl 댓글번호 확인!" + commentno);
		return commentno;
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
//
//	@Override
//	public Board_comment viewComment(Board_comment commentnum) {
//		
//		Board_comment comment = board_commentDao.selectCommentByCommentno(commentnum);
//		
//		return comment;
//	}
	
	
	
	@Override
	public String getName(Board viewBoard) {
		return boardDao.selectNameByUserid(viewBoard);
	}

	@Override
	public void boardInsert(HttpServletRequest req) {
		
		Board board = new Board();
		
		board.setCategory(req.getParameter("category"));
		board.setB_title(req.getParameter("title"));
		board.setB_content(req.getParameter("content"));
		
		//게시글 작성자 id입력
		board.setUserid((int)req.getSession().getAttribute("userid"));
		board.setUserrank((String)req.getSession().getAttribute("userrank"));
		board.setUsername((String)req.getSession().getAttribute("username"));
		board.setDept((String)req.getSession().getAttribute("userdept"));
//		//게시글 번호 생성 - Dao이용
		int boardnum = boardDao.selectBoardno();
		
		if(board.getB_title()==null||"".equals(board.getB_title())) {
			
			board.setB_title("(제목없음)");
		}
		
		if(board != null) {
			
		board.setB_num(boardnum);
			
		boardDao.insertBoard(board);
		
		}
		
	}

	@Override
	public void boardDelete(Board board) {
		
		boardDao.deleteBoard(board);
	}

	@Override
	public void updateBoard(HttpServletRequest req) {
		
		Board board = new Board();
		
		board.setCategory(req.getParameter("category"));
		board.setB_title(req.getParameter("title"));
		board.setB_content(req.getParameter("content"));
	
		String b_num = (String)req.getParameter("b_num");
		board.setB_num(Integer.parseInt(b_num));
		//게시글 작성자 id입력
				board.setUserid((int)req.getSession().getAttribute("userid"));
				board.setUserrank((String)req.getSession().getAttribute("userrank"));
				board.setUsername((String)req.getSession().getAttribute("username"));
				board.setDept((String)req.getSession().getAttribute("userdept"));
		
//				int boardno = boardDao.selectBoardno();
//				board.setB_num(boardno);
				
				boardDao.boardUpdate(board);
		
//		System.out.println(board);
	}

	@Override
	public List<Board_comment> getCommentList(Board board) {
		
		return board_commentDao.selectComment(board);
	}
	

//	@Override
//	public List<Comment_comment> getC_CommentList(Board_comment comment) {
//		
//		
//		return board_commentDao.selectC_Comment(comment);
//	}
//	@Override
//	public List<Comment_comment> getC_CommentList(Board_comment comment) {
//		
//		
//		return board_commentDao.selectC_Comment(comment);
//	}

	
	@Override
	public Board_comment getComment(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String b_num = (String)req.getParameter("b_num");
		
		
		Board_comment comment = new Board_comment();
		
		comment.setB_num(Integer.parseInt(b_num));
		comment.setUserid((int)req.getSession().getAttribute("userid"));
		comment.setUsername((String)req.getSession().getAttribute("username"));
		comment.setC_content(req.getParameter("content"));
		comment.setDept((String)req.getSession().getAttribute("userdept"));
		comment.setUserrank((String)req.getSession().getAttribute("userrank"));
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

	@Override
	public void updateCoCnt(int b_num) {
		boardDao.updateCoCnt(b_num);
	}






//	@Override
//	public List<Board> selectbo(int category, String keyword) {
//		
//		ArrayList<Board>
//		
//		return null;
//	}

	




}
