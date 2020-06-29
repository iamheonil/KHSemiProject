package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.util.ad_B_Paging;

public interface AdminBoardDao {

	/**
	 * 총 게시글 수 조회
	 * 
	 * @return - 전체 게시글 수
	 */
	public int selectCntAll();
	public int selectCntAll(String search);

	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 조회된 게시글 목록
	 */
	public List<Board> selectAll(ad_B_Paging paging);

	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 조회된 게시글 목록
	 */
	public List<Board> selectNotice(ad_B_Paging paging);


	/**
	 * 체크박스로 삭제하기
	 * 
	 * @param names
	 */
	public void deleteList(String names);

}
