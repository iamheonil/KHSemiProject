package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.User_basic;

public interface User_basicService {

	/**
	 * 사번 추가(관리자)
	 * 
	 */
	public void insertUser_basic(User_basic user_basic);
	
	
	/**
	 * 사번 체크
	 * 
	 * @param user_basic - 체크할 사번
	 * @return int - 결과값
	 * 			0 - 불일치
	 * 			1 - 일치
	 */
	public int user_basicCheck(User_basic user_basic);
	
	
	/**
	 * 유저 로그인
	 * 
	 * @param req - 로그인 파라미터정보값
	 * @return boolean - 결과값
	 * 			false - 불일치
	 * 			true - 일치
	 */
	public boolean userLogin(HttpServletRequest req);
	
	
	/**
	 * 아이디 찾기
	 * 
	 * @param user_basic - 조회할 정보
	 * @return User_basic - 아이디 찾기 결과값
	 */
	public User_basic findId(User_basic user_basic);
	
	
	/**
	 * 전달파라미터 user_basic 정보값 얻어오기
	 * 
	 * @param req - 요청객체정보
	 * @return User_basic - User_basic 객체정보
	 */
	public User_basic getUser_basic(HttpServletRequest req);
	
	
	/**
	 * 회원정보 수정(관리자)
	 * 
	 * @param user_basic - 수정할 정보
	 */
	public void modifyUser_basic(User_basic user_basic);

	
	/**
	 * 회원탈퇴, 삭제
	 * 
	 */
	public void deleteUser(User_basic user_basic);
	
	
	/**
	 * 회원정보조회(관리자)
	 * 
	 * @return List<User_basic> - 조회된 회원정보
	 */
	
	public List<User_basic> selectUser_basic();
	
}