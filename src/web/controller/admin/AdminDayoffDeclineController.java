package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;

@WebServlet("/admin/dayoff/decline")
public class AdminDayoffDeclineController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DayoffService dayoffService = new DayoffServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String names = req.getParameter("names");

		if (!"".equals(names) && names != null) {
			dayoffService.decline(names);
		}

		// 메인으로 리다이렉트
		resp.sendRedirect("/admin/view");

	}

}
