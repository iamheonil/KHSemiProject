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
import web.service.face.User_basicService;
import web.service.face.User_detailService;
import web.service.impl.User_basicServiceImpl;
import web.service.impl.User_detailServiceImpl;

@WebServlet("/user/joincheck")
public class UserIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_detailService user_detailService = new User_detailServiceImpl();
	private User_basic user_basic = new User_basic();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/joincheck.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// req정보로 user_basic 정보가져오기
		user_basic = user_basicService.getUser_basic(req);
		
		
		// 사번과 이름이 있는지 체크하기
		if(user_basicService.user_basicCheck(user_basic) > 0) {
			
			// 입력한 사번으로 모델값 등록
			user_basic = user_basicService.selectAllByUserid(user_basic);
			req.setAttribute("userdept", user_basic.getDept());
			req.setAttribute("userrank", user_basic.getUserrank());
			req.setAttribute("username", user_basic.getUsername());
			
			// 회원가입 시 아이디 세션값으로 필요 회원가입하자마자 세션파괴
			session.setAttribute("userid", user_basic.getUserid());
			req.getRequestDispatcher("/WEB-INF/views/login/join.jsp").forward(req, resp);;
		} else {
			
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('등록된 정보가 없습니다.');");
			out.println("location.href='/user/joincheck';");
			out.println("</script>");
		}
	}
}