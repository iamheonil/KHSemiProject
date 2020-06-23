package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.util.Paging;

public interface BoardDao {

	/**
	 * board 목록을 전체를 조회한다
	 * 
	 * 
	 * @return List<Board> - 조회결과
	 */
	
	
	public List<Board> selectAll();
	
	/**
	 * 공지사항만 조회
	 * 
	 * @return List<board> - 조회결과
	 */

	public List<Board> selectNotice();
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @return - 전체 게시글 수
	 */
	
	public int selectCntAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 조회된 게시글 목록
	 */
	
	
	public List<Board> selectAll(Paging paging);

	/**
	 * 
	 * 
	 * 
	 * @param boardnum
	 * @return viewBoard
	 */
	public Board selectBoardByBoardno(Board boardnum);

	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param boardnum - 조회된 게시글 번호를 가진 객체
	 */
	
	public void updateHit(Board boardnum);

	/**
	 * 
	 * id를 이용해 name을 조회
	 * 
	 * @param viewBoard - 조회할 id를 가진 객체
	 * @return String - 작성자의 이름
	 */
	
	public String selectNameByUserid(Board viewBoard);

	/**
	 * 
	 * 첨부파일 조회
	 * 
	 * @param viewBoard - 첨부파일을 조회할 게시글 객체
	 * @return Board - 조회된 첨부파일
	 */
	
	public int selectBoardno();

	/**
	 * inert 와 name으로 새로운 게시글을 insert
	 * 
	 * 
	 * @param boardnum
	 */
	public void insertBoard(Board board);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board
	 */
	public void deleteBoard(Board board);

	/**
	 * 
	 * 게시글 수정
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	public void boardUpdate(Board board);

	
	
	
}