package web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.User_basicService;
import web.service.impl.User_basicServiceImpl;

/**
 * Servlet implementation class AdminUserModifyController
 */
@WebServlet("/admin/userbasic/modify")
public class AdminUserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private User_basicService user_basicService = new User_basicServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// view 지정
		req.getRequestDispatcher("WEB-INF/views/admin/userbasic/modify.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		user_basicService.modifyUser_basic(req);
		
		resp.sendRedirect("/admin/view");
		
	}

}