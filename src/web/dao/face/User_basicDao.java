package web.dao.face;

import java.util.List;

import web.dto.User_basic;
import web.dto.User_detail;

public interface User_basicDao {
	
	/**
	 * 기본정보 추가(관리자)
	 * 
	 * @param user_basic - 추가할 기본정보
	 */
	public void insertUser_basic(User_basic user_basic);
	
	
	/**
	 * 사번만 체크
	 * 
	 * @param user_basic - 체크할 정보
	 * @return int - 결과값
	 * 			0 - 불일치
	 * 			1 - 일치
	 */
	public int selectCntUserByIdName(User_basic user_basic);
	
	
	/**
	 * id로 회원1명 정보찾기
	 * 
	 * @param user_basic - 조회할 id
	 * @return User_basic - 조회된 User_basic
	 */
	public User_basic selectById(User_basic user_basic);
	
	/**
	 * 사번 생성 시 basicnum 받아옴
	 * @return int - 생성할 유저의 basicnum
	 */
	public int nextBasicnum();
	
	
	/**
	 * 아이디찾기
	 * 
	 * @return User_basic - 아이디 반환
	 */
	public User_basic selectCntFindId(User_basic user_basic);
	
	
	/**
	 * 회원 기본정보 변경(관리자)
	 * 
	 * @param user_basic - 변경할 기본정보
	 * @return 
	 */
	public User_basic updateUser_basic(User_basic user_basic);
	
	
	/**
	 * 회원 기본정보 삭제(회원용)
	 * 
	 * @param user_detail - 삭제할 기본정보
	 */
	public void deleteUser_basic(User_detail user_detail);
	
	
	/**
	 * 회원 기본정보 조회(관리자)
	 * 
	 * @return List<User_basic> - 조회된 정보
	 */
	public List<User_basic> selectUser_basic(String search);
	
	/**
	 * 회원 리스트 삭제
	 * 
	 * @param names - 삭제한 유저 사번
	 */
	public void deleteUser_DetailList(User_detail user_detail);
}