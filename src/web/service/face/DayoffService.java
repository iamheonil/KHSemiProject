package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Dayoff;
import web.dto.User_detail;
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
	 * 전달파라미터 dayoff 정보값 얻어오기
	 * @param req - 요청정보 객체
	 * @return Dayoff - 객체 정보
	 */
	public Dayoff getDayoff(HttpServletRequest req);
	
	
	/**
	 * 사번으로 Dayoff 정보 가져오기(로그인 session?)
	 * 
	 * @return Dayoff - 조회한 휴가신청서 정보(리스트?)
	 */
	public List<Dayoff> getDayoffById(int userid);
	

	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청정보객체
	 * @return Dayoff - 전달파라미터 daynum을 포함한 객체
	 */
	public Dayoff getDaynum(HttpServletRequest req);
	

	/**
	 * 휴가 승인 
	 * @param
	 * @retuen Dayoff - 전달 파라미터 dreason을 포함한 객체
	 */
	public void accept(String names);
	
	
	/**
	 * 휴가 반려
	 * @param 
	 */
	public void decline(String names);
	
	/**
	 * 휴가 신청서 작성
	 * @param 
	 * @return Dayoff - 작성한 휴가 신청서
	 */
	public void dayoffWrite(HttpServletRequest req);

	


	/**
	 * 신청서 삭제
	 * @param dayoff
	 *
	 */
	public void delete(Dayoff dayoff);
	
	
	/**
	 * 신청서 목록 삭제
	 * @param da
	 */
	public void deleteDayoff(String names);

	
}
