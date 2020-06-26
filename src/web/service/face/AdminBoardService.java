package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Board;
import web.util.ad_B_Paging;

public interface AdminBoardService {

	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public ad_B_Paging getPaging(HttpServletRequest req);

	/**
	 * 페이징 처리로 보여질 게시글목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board>
	 */
	public List<Board> list(ad_B_Paging paging);

	/**
	 * 페이징 처리로 보여질 게시글목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> 
	 */
	public List<Board> nlist(ad_B_Paging paging);


	/**
	 * 체크박스로 선택한 게시글 삭제
	 * 
	 * @param names
	 */
	public void deleteBoardList(String names);

	

}
