package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.Admin;



public interface AdminService {
	
	/**
	 * 로그인 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return Admin - 입력한 로그인 정보
	 */
	public Admin getLoginAdmin(HttpServletRequest req);

	/**
	 * 로그인 처리
	 * 
	 * @param admin - 입력한 로그인 정보
	 * @return true - 인증됨, false - 인증되지 않음
	 */
	public boolean login(Admin admin);

	/**
	 * 유저정보 가져오기
	 * 
	 * @param adminnum- 회원 아이디를 가진 객체
	 * @return Admin - 조회된 회원 정보
	 */
	public Admin info(Admin adminnum);


}
