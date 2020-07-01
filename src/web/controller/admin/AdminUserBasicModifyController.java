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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//전달파라미터 얻기 - userid
		User_basic userid = user_basicService.getUser_basic(req);
		System.out.println("userid : " + userid);
		
		//상세보기 결과 조회
		User_basic modiUser = user_basicService.modifyUser_basic(userid);
		req.setAttribute("modiUser", modiUser);
		
		//조회결과 MODEL값 전달
		req.setAttribute("userid", userid);

		// view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/userbasic/modify.jsp").forward(req, resp);

		
		
	}

}
