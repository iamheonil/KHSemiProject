package web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_detail;
import web.service.face.User_basicService;
import web.service.impl.User_basicServiceImpl;


@WebServlet("/admin/userdetail/delete")
public class AdminUserDetailDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User_basicService user_basicService = new User_basicServiceImpl();
       
	
	
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		req.getRequestDispatcher("/WEB-INF/views/admin/userdetail/list.jsp").forward(req, resp);
		
	}




	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User_detail user_Detail = new User_detail();

		String strId = req.getParameter("userid");
		int parseId = Integer.parseInt(strId);

		user_Detail.setUserid(parseId);
		
		user_basicService.deleteUserList(user_Detail);

		//목록으로 리다이렉트
		resp.sendRedirect("/admin/view");
	}

	
	
}
