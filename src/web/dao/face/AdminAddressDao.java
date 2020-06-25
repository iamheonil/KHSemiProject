package web.dao.face;

import java.util.List;

import web.dto.User_basic_detail;
import web.dto.User_detail;
import web.util.ad_Paging;

public interface AdminAddressDao {

	/**
	 * User_detail 테이블 전체 조회
	 * 
	 * @return List<User_detail> - user_detail테이블 조회 결과 리스트
	 */
	public List<User_detail> selectAll();

	/**
	 * 총 게시글 수 조회
	 * 
	 * @return
	 */
	public int selectCntAll();

	/**
	 * 페이징 대상 게시글 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<User_detail> - 조회된 목록
	 */
	public List<User_basic_detail> selectAll(ad_Paging paging);

	

}
