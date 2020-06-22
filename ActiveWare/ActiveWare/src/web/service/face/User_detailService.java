package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.User_detail;

public interface User_detailService {
	
	
	
	/**
	 * 전달파라미터 user_detail 정보값 얻어오기
	 * 
	 * @param req - 요청객체 정보
	 * @return User_detail - User_detail 객체정보
	 */
	public User_detail getUser_detail(HttpServletRequest req);
	
	
	/**
	 * 회원가입
	 * 
	 * @param user_detail - 회원가입할 정보
	 */
	public void joinUser_detail(User_detail user_detail);
	
	
	/**
	 * 회원정보 수정
	 * 
	 * @param user_detail - 수정할 정보
	 */
	public void modifyUser_detail(User_detail user_detail);
	
	
}