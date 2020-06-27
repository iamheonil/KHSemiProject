package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Dayoff;
import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;

/**
 * Servlet implementation class AdminDayoffDeclineController
 */
@WebServlet("/admin/dayoff/decline")
public class AdminDayoffDeclineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DayoffService dayoffService = new DayoffServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//휴가 신청서 번호 파싱
		Dayoff viewDayoff = dayoffService.getDaynum(req);
		
		//휴가 신청서 조회
		viewDayoff = dayoffService.view(req);
		
		//휴가 신청서 전달
		req.setAttribute("viewDayoff", viewDayoff);
		
		//view지정
		req.getRequestDispatcher("/WEB-INF/views/admin/dayoff/decline.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		dayoffService.update(req);
		
		resp.sendRedirect("/admin/dayoff/list");
		
	}

}
