package web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	private User_detailService user_detailService = new User_detailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/mypage/userexit.jsp").forward(req, resp);

//		System.out.println(req.getParameter("userid"));
//		System.out.println(req.getParameter("pw"));
//		System.out.println(req.getParameter("pwchk"));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_detail user_Detail = new User_detail();

		try {
			String strId = req.getParameter("userid");
			int parseId = Integer.parseInt(strId);

			System.out.println(parseId);
			System.out.println(req.getParameter("pw"));

			user_Detail.setUserid(parseId);
			user_Detail.setUserpw(req.getParameter("pw"));

			boolean res = false;
			res = user_basicService.userLogin(user_Detail);

			if (res) {
				user_basicService.deleteUser(user_Detail);
				resp.sendRedirect("/");
			} else {
				PrintWriter out = resp.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호가 맞지 않습니다!');");
				out.println("location.href='/user/delete';");
				out.println("</script>");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}