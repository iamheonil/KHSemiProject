package web.dao.face;

import web.dto.Admin;

public interface AdminDao {
	
	/**
	 * adminnum과 adminpw가 일치하는 회원의 수를 조회
	 * 
	 * @param admin - 조회할 회원(관리자)의 정보
	 * @return int - 1(존재하는 회원), 0(존재하지 않는 회원), -1(에러)
	 */
	public int selectCntAdminByAdminnumAdminpw(Admin adminnum);

	/**
	 * adminnum를 이용해 회원정보 조회
	 * 
	 * @param adminnum - 조회할 회원
	 * @return Admin - 조회된 결과 객체
	 */
	public Admin selectAdminByAdminnum(Admin adminnum);

}
