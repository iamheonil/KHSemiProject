package web.dao.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Plan;
import web.dto.User_basic;

public interface PlanDao {
	
	/**
	 * DB 값 조회를 위해 아이디 정보를 가져옵니다.
	 * @param req - 가져 올 Request 정보
	 * @return - Request 의 ID
	 */

	public User_basic dbGetId(HttpServletRequest req);
	
	/**
	 * DB에 들어가 있는 Plan을 가져옵니다.
	 * 
	 * @return
	 */
	public List<Plan> dbPlan(HttpServletRequest req);

}
