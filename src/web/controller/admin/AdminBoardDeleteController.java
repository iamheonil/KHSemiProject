package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.AdminBoardService;
import web.service.impl.AdminBoardServiceImpl;

@WebServlet("/admin/board/delete")
public class AdminBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminBoardService adminboardService = new AdminBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			adminboardService.deleteBoardList(names);
		}
		
//		resp.sendRedirect("/admin/board/list");
		resp.sendRedirect("/admin/view");
		
		
	}

}
