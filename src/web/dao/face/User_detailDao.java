package web.dao.face;

import java.util.List;

import web.dto.User_basic;
import web.dto.User_detail;

public interface User_detailDao {

	/**
	 * 로그인 - id,pw정보조회
	 * 
	 * @param user_detail - 조회할 id,pw 정보
	 * @return int - 결과값
	 * 			0 - 불일치
	 * 			1 - 일치
	 */
	public int selectCntByuserIdPw(User_detail user_detail);
	
	
	/**
	 * 회원가입
	 * 
	 * @param user_detail - 가입할 정보
	 */
	public void insertUser_detail(User_detail user_detail);
	
	
	/**
	 * 회원 상세정보 변경
	 * 
	 * @param user_detail - 변경할 상세정보
	 */
	public void updateUser_detail(User_detail user_detail);
	
	
	/**
	 * 회원 상세정보 삭제(관리자)
	 * 
	 * @param user_basic - 삭제할 상세정보
	 */
	public void deleteUser_detail(User_detail user_detail);
	
	
	/**
	 * 회원 상세정보 조회(관리자)
	 * 
	 * @return List<User_detail> - 조회된 정보
	 */
	public List<User_detail> selectUser_detail();


	/**
	 * 임시비밀번호 저장
	 * 
	 * @param password - 임시비밀번호
	 */
	public void updatePassword(User_detail user_detail);
}