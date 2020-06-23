package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.Board_comment;

public interface Board_commentDao {

	/**
	 * 코멘트 조회 - 코멘트 번호를 조회
	 * 
	 * @param board - 댓글이 조회될 게시글
	 * @return List - 조회된 댓글 리스트
	 */
	
	
	public List<Board_comment> selectComment(Board board);

	/**
	 * 코멘트 INSERT
	 * 
	 * @param comment - 삽입될 댓글
	 */
	public void insertComment(Board_comment comment);

	/**
	 * 댓글 삭제 
	 *
	 * @param comment - 삭제할 댓글
	 */
	
	public void deleteComment(Board_comment comment);

	/**
	 * 댓글 카운트  - 댓글 존재 여부 확인
	 * 
	 * @param comment - 존재 여부 체크 대상 댓글
	 * @return int  - 댓글 수
	 */
	
	public int countComment(Board_comment comment); 

}
