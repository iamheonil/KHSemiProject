package web.controller.plan;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Plan;
import web.service.face.PlanService;
import web.service.impl.PlanServiceImpl;

/**
 * Servlet implementation class PlanViewController
 */
@WebServlet("/plan/view")
public class PlanViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlanService planService = new PlanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 디비에서 정보 가져오기
		List<Plan> allPlan = planService.getPlan();
		
		System.out.println(allPlan);
		
		// 가져온 정보 뷰단으로 보내주기
		req.setAttribute("allPlan", allPlan);
		
		// 포워딩 작업
		req.getRequestDispatcher("/WEB-INF/views/plan/view.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("넘어 왔어!!");
		
	}

}
