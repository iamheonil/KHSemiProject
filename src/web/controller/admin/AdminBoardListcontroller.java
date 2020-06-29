package web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.AdminBoardService;
import web.service.impl.AdminBoardServiceImpl;
import web.util.ad_B_Paging;

@WebServlet("/admin/board/list")
public class AdminBoardListcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBoardService adminboardService = new AdminBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("관리자 게시판 목록");
		
		//paging 객체 생성
		ad_B_Paging paging = adminboardService.getPaging(req);
//		System.out.println("adminBoard" + paging);
		
		
		//게시글 조회
		List<Board> list = adminboardService.list(paging);
		
		for (Board board : list) {
			System.out.println(board);
		}
		
		//공지사항 게시글 조회
		List<Board> N_list = adminboardService.nlist(paging);
		

		//Paging 결과 MODEL값 전달
		req.setAttribute("paging", paging);

		//조회된 결과 view 전달
		req.setAttribute("list", list);
		req.setAttribute("nlist", N_list);
		
		System.out.println("List list" + list);
		System.out.println("List N_list" + N_list);
		
		//View 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/board/adboardList.jsp").forward(req, resp);
		
	}
	
	
}
