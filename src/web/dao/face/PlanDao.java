package web.dao.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Plan;

public interface PlanDao {
	
	/**
	 * DB에 들어가 있는 Plan을 가져옵니다.
	 * 
	 * @return
	 */
	public List<Plan> dbPlan(HttpServletRequest req);
	
	
	/**
	 * Service 에서 넘어온 일정 정보 처리
	 * 
	 * @param req - 아이디 정보
	 * @param plan - 삽입될 일정 내용
	 */
	public void dbInsert(HttpServletRequest req, Plan plan);

}
