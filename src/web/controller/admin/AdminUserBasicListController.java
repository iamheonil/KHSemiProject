package web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_basic;
import web.service.face.User_basicService;
import web.service.impl.User_basicServiceImpl;


/**
 * Servlet implementation class AdminUserBasicListController
 */
@WebServlet("/admin/userbasic/list")
public class AdminUserBasicListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User_basicService user_basicService = new User_basicServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("userBasicList [DoGet] 확인");
		
		//검색 결과이므로 페이징 넣지 않습니다.
		List<User_basic> list = user_basicService.selectUser_basic(req);
		
		//조회 결과 전달
		req.setAttribute("list", list);
		
		//view지정
		req.getRequestDispatcher("/WEB-INF/views/admin/user/list.jsp").forward(req, resp);


	}

	}

	

