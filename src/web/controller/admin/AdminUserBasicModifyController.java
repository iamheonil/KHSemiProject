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
 * Servlet implementation class AdminUserModifyController
 */
@WebServlet("/admin/userbasic/modify")
public class AdminUserBasicModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_basic user_basic = new User_basic();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		user_basic = user_basicService.getUser_basic(req);
		user_basic = user_basicService.selectByUserid(user_basic);
		
		System.out.println("usermodify - basic :" + user_basic);
		
		req.setAttribute("user_basic", user_basic);

		// view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/userbasic/modify.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//회원정보 변경
		user_basicService.modifyUser_basic(req);
		

		//변경 후 관리자 메인 페이지로
		resp.sendRedirect("/admin/view");
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
