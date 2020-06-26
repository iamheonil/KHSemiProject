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
	
	
	
	
}
