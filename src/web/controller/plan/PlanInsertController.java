package web.controller.plan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.PlanService;
import web.service.impl.PlanServiceImpl;

/**
 * Servlet implementation class PlanInsertController
 */
@WebServlet("/plan/insert")
public class PlanInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanService planService = new PlanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("insert 확인");
		
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("보낼게");
		
		planService.insertPlan(req);
		
		resp.sendRedirect("/plan/view");
		
	}

}
