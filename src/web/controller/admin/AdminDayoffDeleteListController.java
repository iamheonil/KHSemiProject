package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;

/**
 * Servlet implementation class AdminDayoffDeleteListController
 */
@WebServlet("/admin/dayoff/listDelete")
public class AdminDayoffDeleteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private DayoffService dayoffService = new DayoffServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			dayoffService.deleteDayoff(names);
		}
		
		//메인으로 리다이렉트
		resp.sendRedirect("/admin/view");

	}
}
