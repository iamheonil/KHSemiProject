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
	

	/**
	 * 일정을 수정한다
	 * @param req - 수정할 일정의 정보
	 */
	public void modifyPlan(HttpServletRequest req, Plan plan);
	
	
	/**
	 * 일정을 삭제한다
	 * @param plan - 삭제할 일정의 정보
	 */
	public void deletePlan(Plan plan);
	
	
}
