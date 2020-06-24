package web.service.impl;

import java.util.List;

import web.dao.face.PlanDao;
import web.dao.impl.PlanDaoImpl;
import web.dto.Plan;
import web.service.face.PlanService;

public class PlanServiceImpl implements PlanService {

	private PlanDao planDao = new PlanDaoImpl();
	
	@Override
	public List<Plan> getPlan() {
		
		return planDao.dbPlan();
	}
	
	

}
