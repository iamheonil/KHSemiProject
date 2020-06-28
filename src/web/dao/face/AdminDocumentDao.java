package web.dao.face;

import java.util.ArrayList;
import java.util.Map;

import web.util.ad_D_paging;


public interface AdminDocumentDao {

	/**
	 * 문서등록대장 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param startDate - 검색날짜 시작 값
	 * @param endDate - 검색날짜 종료 값
	 * @return int - 조회된 개수
	 */
	public int selectDocumentSearchCntAll(String search, String startDate, String endDate);
	
	
	/**
	 * 문서등록대장 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @param startDate - 검색날짜 시작 값
	 * @param endDate - 검색날짜 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 문서등록대장 값
	 */
	public ArrayList<Map<String, Object>> selectDocumentAll(ad_D_paging paging, String startDate, String endDate);


	/**
	 * 문서 선택 삭제
	 * @param names
	 */
	public void deleteDocumentList(String names);
	
	
	/**
	 * 체크박스로 삭제하기
	 * @param names
	 */
	public void deleteDocList(String names);

	


}
