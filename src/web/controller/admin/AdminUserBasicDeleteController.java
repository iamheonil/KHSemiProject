package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_basic;
import web.service.face.User_basicService;
import web.service.impl.User_basicServiceImpl;

/**
 * Servlet implementation class AdminUserBasicDeleteController
 */
@WebServlet("/admin/userbasic/delete")
public class AdminUserBasicDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User_basicService user_basicService = new User_basicServiceImpl();
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User_basic userBasic = user_basicService.getUser_basic(req);
		
		user_basicService.deleteUser(userBasic);
		
		resp.sendRedirect("/admin/userbasic/list");
	}

}
