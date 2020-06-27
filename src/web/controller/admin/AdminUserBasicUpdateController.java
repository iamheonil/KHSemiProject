package web.controller.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import web.service.face.User_basicService;
import web.service.impl.User_basicServiceImpl;

/**
 * Servlet implementation class AdminUserBasicUpdateController
 */
@WebServlet("/admin/userbasic/update")
public class AdminUserBasicUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User_basicService user_basicService = new User_basicServiceImpl();

}
