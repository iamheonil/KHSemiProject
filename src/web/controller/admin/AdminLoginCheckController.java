package web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

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
	private Admin admin = new Admin();
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/login/login_admin.jsp").forward(req, resp);
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 입력한 로그인 정보 admin 객체에 저장
		admin = adminService.getLoginAdmin(req);
		
		System.out.println("admin 정보 " + admin);
		
		// 관리자 로그인 - 반환값 boolean
		boolean res = false;
		res = adminService.login(admin);
		
		if(res) {
			System.out.println("로그인성공");
			
			// 사번, 이름, 직급, 부서 세션으로 등록
			session.setAttribute("login", true);
			session.setAttribute("adminid", admin.getAdminid());
			
			resp.sendRedirect("/admin/view");
		} else {
			resp.setContentType("text/html; charset=utf-8");

			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 비밀번호가 맞지 않습니다!');");
			out.println("location.href='/admin/login';");
			out.println("</script>");
		}
		
		
				
		
	}

}
