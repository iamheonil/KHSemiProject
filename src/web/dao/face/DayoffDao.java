package web.dao.face;


import java.util.List;

import web.dto.Dayoff;
import web.util.Paging;

public interface DayoffDao {

	/**
	 * 휴가 게시글 전체 조회 
	 * @return - Dayoff테이블 전체 조회 결과 리스트
	 */
	public List<Dayoff> selectAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Dayoff> - 조회된 게시글 목록
	 */
	public List<Dayoff> selectAll(Paging paging);
	
	
	/**
	 * 스스로 작성한 휴가 내역 조회
	 * @param userid - 조회할 userid를 가진 객체
	 * @return List<Dayoff> - 조회된 게시글 목록
	 */
	public List<Dayoff> selectbyUserId(Dayoff userid);
	

	/**
	 * 총 게시글 수 조회
	 * 
	 * @return
	 */
	public int selectCntAll();
	
	
	/**
	 * 휴가 신청서 작성
	 * @param dayoff - 삽입될 휴가 신청서 내용
	 */
	public void insert(Dayoff dayoff);
	
	/**
	 * 휴가 승인/반려
	 * @param dresult - 휴가 승인 여부 정보 객체
	 */
	public void update(Dayoff dresult);
	
}
