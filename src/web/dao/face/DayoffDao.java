package web.dao.face;


import java.util.List;

import web.dto.Dayoff;
import web.util.ad_Day_Paging;


public interface DayoffDao {

	/**
	 * 게시글 전체 목록 조회
	 * 
	 * @return List - 조회된 게시글 목록
	 */
	public List<Dayoff> selectAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param Paging - 페이징 정보
	 * @return List - 조회된 게시글 목록
	 */
	public List<Dayoff> selectAll(ad_Day_Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @return int - 총 게시글 수
	 */
	public int selectCntAll();

	/**
	 * 다음 게시글 번호 반환
	 *  게시글 테이블과 첨부파일 테이블에 입력될 게시글번호를
	 * 시퀀스를 통해 추출한다
	 * 
	 * @return - 다음 게시글 번호
	 */
	public int selectDaynum();
	
	/**
	 * 휴가 신청서 작성
	 * @param dayoff - 삽입될 휴가 신청서 내용
	 */
	public void insert(Dayoff dayoff);
	
	/**
	 * 휴가 승인
	 * @param dresult - 휴가 승인 여부 정보 객체
	 */
	public void acceptDresult(Dayoff dayoff);
	
	/**
	 * 휴가 거절
	 * @param dayoff
	 */
	public void declineDresult(Dayoff dayoff);
	
	
	/**
	 * 
	 * @param req
	 */
	public void deleteDayoff(Dayoff dayoff);



	/**
	 * 리스트에서 게시글 삭제하기
	 * 
	 * @param names - 삭제한 게시글 번호 목록들 문자열
	 */
	public void deleteDayoffList(String names);

	
}
