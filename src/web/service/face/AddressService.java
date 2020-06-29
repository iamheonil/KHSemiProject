package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.User_basic_detail;
import web.dto.User_detail;
import web.util.ad_Paging;

public interface AddressService {

	/**
	 * 전체조회
	 * 
	 * @return List<User_detail> - 전체조회 결과 리스트
	 */
	public List<User_detail> getList();

	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - curPage정보를 담고 있는 요청정보 객체
	 * @return Paging - 페이징 계산이 완료된 결과 객체
	 */
	public ad_Paging getPaging(HttpServletRequest req);

	/**
	 * 페이징 객체 생성
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<User_detail> - 조회된 게시글 목록
	 */
	public List<User_basic_detail> getList(ad_Paging paging);











	
	
}
