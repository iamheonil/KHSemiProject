package web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_detail;
import web.service.face.User_detailService;
import web.service.impl.User_detailServiceImpl;

@WebServlet("/user/modify/detail")
public class User_detailModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_detailService user_detailService = new User_detailServiceImpl();
	private User_detail user_detail = new User_detail();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		user_detail = user_detailService.getUser_detailById(req);
		
		req.setAttribute("user_detail", user_detail);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/mypage.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}