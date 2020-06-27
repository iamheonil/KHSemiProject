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
 * Servlet implementation class AdminDayoffDeleteController
 */
@WebServlet("/admin/dayoff/delete")
public class AdminDayoffDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DayoffService dayoffService = new DayoffServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Dayoff dayoff = dayoffService.getDaynum(req);
		
		dayoffService.delete(req);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/admin/dayoff/delete");
		
	}
	
	
	

}
