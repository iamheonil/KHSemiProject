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
		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			user_basicService.deleteUserList(names);
		}

		
		//목록으로 리다이렉트
		resp.sendRedirect("/admin/userbasic/list");
	}

}
