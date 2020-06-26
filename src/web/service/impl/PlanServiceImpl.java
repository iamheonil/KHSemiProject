package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.PlanDao;
import web.dao.impl.PlanDaoImpl;
import web.dto.Plan;
import web.service.face.PlanService;

public class PlanServiceImpl implements PlanService {

	private PlanDao planDao = new PlanDaoImpl();
	
	
	/**
	 * DB에 등록되어 있는 일정을 가져옵니다.
	 * 
	 */
	@Override
	public List<Plan> getPlan(HttpServletRequest req) {
		
		return planDao.dbPlan(req);
	}
	

}
