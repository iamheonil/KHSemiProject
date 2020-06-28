package web.service.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Document;
import web.util.SearchPaging;
import web.util.ad_D_paging;


public interface AdminDocumentService {

	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public ad_D_paging getDocumentPaging(HttpServletRequest req);


	/**
	 * 문서등록대장 전체 조회
	 * 
	 * @param paging - 페이징 객체
	 * @param startDate - 시작 값
	 * @param endDate - 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 문서등록대장 목록 값
	 */
	public ArrayList<Map<String, Object>> getListDocumentAll(ad_D_paging paging, String startDate, String endDate);




	/**
	 * 체크박스로 선택한 게시글 삭제
	 * 
	 * @param names
	 */
	public void deleteDocumentList(String names);

	

}
