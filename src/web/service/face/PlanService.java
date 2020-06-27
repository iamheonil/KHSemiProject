package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Plan;

public interface PlanService {
	
	/**
	 * DB에 들어가 있는 Plan들을 조회합니다.
	 * 
	 * @return
	 */
	public List<Plan> getPlan(HttpServletRequest req);
	
	/**
	 * 일정을 작성,
	 * 작성한 일정내역을 DB에 저장한다.
	 * 
	 * @param req - 요청정보 객체(일정 정보)
	 */
	public void insertPlan(HttpServletRequest req);
	
	
}
