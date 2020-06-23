package web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_basic;
import web.dto.User_detail;
import web.service.face.User_basicService;
import web.service.face.User_detailService;
import web.service.impl.User_basicServiceImpl;
import web.service.impl.User_detailServiceImpl;

@WebServlet("/user/join")
public class UserJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User_detailService user_detailService = new User_detailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/joincheck.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원가입
		user_detailService.joinUser_detail(req);
		
		resp.sendRedirect("/");
	}
}