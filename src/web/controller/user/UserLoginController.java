package web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.User_basic;
import web.dto.User_detail;
import web.service.face.User_basicService;
import web.service.face.User_detailService;
import web.service.impl.User_basicServiceImpl;
import web.service.impl.User_detailServiceImpl;

@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_detailService user_detailService = new User_detailServiceImpl();
	private User_basic user_basic = new User_basic();
	private User_detail user_detail = new User_detail();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/login [GET] 하이");
		
		// 로그인화면 forward
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/login [POST]");
		
		
		HttpSession session = req.getSession();
		
		user_detail = user_detailService.getUser_detail(req);
		
		// req정보에 있는 userid 값 user_basic객체로 넣기
		user_basic.setUserid(user_detail.getUserid());
		
		// 아이디로 한명의 값 받아오기
		user_basic = user_basicService.selectAllByUserid(user_basic);
		
		// 유저 로그인 - 반환값 boolean
		boolean res = false;
		res = user_basicService.userLogin(user_detail);
		
		// user photo 가져오기
		user_detail = user_detailService.getUser_detailById(req);
		
		if(res) {
			System.out.println("로그인성공");
			
			// 로그인정보, 사번, 이름, 직급, 부서 세션으로 등록
			session.setAttribute("login", true);
			session.setAttribute("userid", user_basic.getUserid());
			session.setAttribute("username", user_basic.getUsername());
			session.setAttribute("userrank", user_basic.getUserrank());
			session.setAttribute("userdept", user_basic.getDept());
			session.setAttribute("userphoto", user_detail.getUserphoto_rename());
			
			resp.sendRedirect("/document/dolist");
		} else {
			resp.setContentType("text/html; charset=utf-8");

			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 비밀번호가 맞지 않습니다!');");
			out.println("location.href='/user/login';");
			out.println("</script>");
		}
		
	}
}