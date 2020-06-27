package web.controller.plan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Plan;
import web.service.face.PlanService;
import web.service.impl.PlanServiceImpl;

/**
 * Servlet implementation class PlanDeleteController
 */
@WebServlet("/plan/delete")
public class PlanDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanService planService = new PlanServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Plan plan = new Plan();
		
		req.getParameter("plan_name");
		
		plan.setPlan_num(Integer.parseInt(req.getParameter("plan_num")));
		
		planService.deletePlan(plan);		
		
		resp.sendRedirect("/plan/view");
	}
	
	
	
}
