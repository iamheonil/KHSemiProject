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
 * Servlet implementation class PlanModifyController
 */
@WebServlet("/plan/modify")
public class PlanModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanService planService = new PlanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Post 확인");
		
		Plan plan = new Plan();
		
		plan.setPlan_num(Integer.parseInt(req.getParameter("plan_num")));
		plan.setPlan_name(req.getParameter("plan_name"));
		plan.setPtime_start(req.getParameter("ptime_start"));
		plan.setPtime_end(req.getParameter("ptime_end"));
		
//		System.out.println(Integer.parseInt(req.getParameter("plan_num")));
//		System.out.println(req.getParameter("plan_name"));
//		System.out.println(req.getParameter("ptime_start"));
//		System.out.println(req.getParameter("ptime_end"));
		
		planService.modifyPlan(req, plan);
		
		resp.sendRedirect("/plan/view");
		
	}

}
