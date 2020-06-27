package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Dayoff;
import web.util.Paging;

public interface DayoffService {
	

	/**
	 * 휴가 신청글 전체 조회
	 * 
	 * @return List<Dayoff> - 휴가신청글 전체 조회 결과 리스트
	 */
	public List<Dayoff> getList();

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청정보를 활용하여 curPage를 구하고
	 * Board 테이블과 curPage 값을 이용한 Paging 객체를 생성하여 반환한다
	 * 
	 * @param req - curPage정보를 담고 있는 요청정보 객체
	 * @return Paging - 페이징 계산이 완료된 결과 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 페이징 처리하여 보여질 게시글 목록만 조회하기
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Dayoff> - 조회된 게시글 목록
	 */
	public List<Dayoff> getList(Paging paging);
	
	
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
	 * 휴가 승인 여부
	 * @param req - 요청정보객체
	 * @retuen Dayoff - 전달 파라미터 dreason을 포함한 객체
	 */
	public void update(HttpServletRequest req);
	
	/**
	 * 휴가 신청서 작성
	 * @param req - 요청 정보 객체
	 * @return Dayoff - 작성한 휴가 신청서
	 */
	public void insert(HttpServletRequest req);

	
	/**
	 * 휴가 신청서 조회
	 * @param req
	 * @return
	 */
	public Dayoff view(HttpServletRequest req);

	
	/**
	 * 휴가 신청서 삭제
	 * @param req
	 */
	public void delete(HttpServletRequest req);
	
	
}
