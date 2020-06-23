package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Admin;
import web.service.face.AdminService;
import web.service.impl.AdminServiceImpl;



@WebServlet("/admin/login")
public class AdminLoginCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService adminService = new AdminServiceImpl();
	
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/admin/adminlogin.jsp").forward(req, resp);
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 :: 로그인 정보 얻기
		Admin admin = adminService.getLoginAdmin(req);
		
		boolean login = adminService.login(admin);
		
		
		if(login) {
			//로그인 사용자의 정보 얻어오기
			admin = adminService.info(admin);
			
			//세션 정보 저장하기
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
			session.setAttribute("adminnum", admin);
			session.setAttribute("adminpw", admin);

		}
		
		
		//메인 페이지로 리다이렉트
		resp.sendRedirect("/");
		
		//또는 비밀번호를 확인해 주십시오 같은 ajax나 부트스트랩?

				
		
	}

}
