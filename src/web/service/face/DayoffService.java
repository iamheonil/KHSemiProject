package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Dayoff;
import web.util.Paging;
import web.util.ad_Day_Paging;

public interface DayoffService {
	

	/**
	 * 게시글 목록 조회
	 *  
	 * @return List - 게시글 목록
	 */
	public List<Dayoff> getList();
	
	/**
	 * 페이징 정보를 활용하여 보여질 게시글 목록만 조회
	 *  
	 * @param Paging - 페이징 정보
	 * @return List - 게시글 목록
	 */
	public List<Dayoff> getList(ad_Day_Paging paging);
	
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */
	public ad_Day_Paging getPaging(HttpServletRequest req);
	
	/**
	 * 글 작성자인지 판단하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return boolean - true : 로그인한 사람이 글 작성자
	 */
	public boolean checkId(HttpServletRequest req);
	

	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청정보객체
	 * @return Dayoff - 전달파라미터 daynum을 포함한 객체
	 */
	public Dayoff getDaynum(HttpServletRequest req);
	

	/**
	 * 휴가 승인 
	 * @param req - 요청정보객체
	 * @retuen Dayoff - 전달 파라미터 dreason을 포함한 객체
	 */
	public void accept(HttpServletRequest req);
	
	
	/**
	 * 휴가 반려
	 * @param req
	 */
	public void decline(HttpServletRequest req);
	
	/**
	 * 휴가 신청서 작성
	 * @param req - 요청 정보 객체
	 * @return Dayoff - 작성한 휴가 신청서
	 */
	public void dayoffWrite(HttpServletRequest req);

	
	/**
	 * 휴가 신청서 조회
	 * @param req
	 * @return
	 */
	public Dayoff view(HttpServletRequest req);


	/**
	 * 신청서 삭제
	 * @param dayoff
	 *
	 */
	public void delete(Dayoff dayoff);
	
	
	/**
	 * 신청서 목록 삭제
	 * @param dayoff
	 */
	public void deleteDayoff(String names);

	
}
