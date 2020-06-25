package web.service.face;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import web.dto.Board;
import web.dto.Board_comment;
import web.util.B_Paging;

public interface BoardService {

	/**
	 * 게시판 리스트 전체 조회
	 * 
	 * @return List<Board>  - 조회된 결과
	 */
	
	public List<Board> list();
	
	/**
	 * 게시판 공지사항만 조회
	 * 
	 * @return List<Board>
	 */
	
	public List<Board> nList();

	/**
	 * 게시판 사내게시판만 조회
	 * 
	 * @return List<Board>
	 */
	public List<Board> fList();
	
	/**
	 * 게시판 스터디게시판만 조회
	 * 
	 * @return List<Board>
	 */
	public List<Board> sList();
	
	/**
	 * 페이징 처리하여 보여질 게시글 목록만 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board>
	 */
	
	public List<Board> list(B_Paging paging);

	

	/**
	 * 페이징 처리로 보여질 게시글목록만 조회
	 * 
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board>
	 */
	
	public List<Board> nList(B_Paging paging);

	/**
	 * 
	 * 페이징 처리로 보여질 게시글목록만 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board>
	 */
	public List<Board> fList(B_Paging paging);
	
	/**
	 *  페이징 처리로 보여질 게시글목록만 조회
	 *
	 *
	 * @param paging - 페이징 정보 객체
	 * @return List<Board>
	 */
	public List<Board> sList(B_Paging paging);
	
	// ------------------------------------------------------------------------------
	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	
	public B_Paging getPaging(HttpServletRequest req);
	
	
	
	/**
	 * 
	 * 게시글 번호 조회
	 * 
	 * @param req 요청
	 * @return Boardno 조회된 결과
	 */
	public Board getBoardno(HttpServletRequest req);

	/**
	 * 게시글 번호를 통해 게시글 상세조회
	 * 
	 * @param boardnum
	 * @return board
	 */
	public Board view(Board boardnum);

	/**
	 * userid를 이용한 이름 조회
	 * 
	 * @param viewBoard - 조회할 게시글 정보
	 * @return String - 게시글 작성자의 이름
	 */
	
	public String getName(Board viewBoard);

	/**
	 * 게시글 작성
	 * 
	 * @param req - 요청정보 객체(게시글 내용)
	 */
	public void boardInsert(HttpServletRequest req);

	/**
	 * 해당 boardnum의 게시글 삭제
	 * 
	 * @param board
	 */
	
	public void boardDelete(Board board);

	/**
	 * 
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void updateBoard(HttpServletRequest req);

	/**
	 * 댓글 리스트
	 * 
	 * @param board -댓글이 조회될 게시글
	 * @return List - 댓글 리스트
	 */
	public List<Board_comment> getCommentList(Board board);

	/**
	 * 
	 * 댓글 전달파라미터 꺼내기
	 * 
	 */
	
	
	public Board_comment getComment(HttpServletRequest req);

	/**
	 * 댓글 입력
	 * 
	 * @param comment - 삽입될 댓글
	 */
	
	public void insertComment(Board_comment comment);

	
	/**
	 * 댓글 삭제
	 * 
	 * @param comment - 삭제할 댓글
	 * @return boolean - 삭제 성공 여부
	 */
	public boolean deleteComment(Board_comment comment);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	
	public B_Paging getNoticePaging(HttpServletRequest req);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public B_Paging getStudyPaging(HttpServletRequest req);

	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	
	public B_Paging getFreePaging(HttpServletRequest req);

}
