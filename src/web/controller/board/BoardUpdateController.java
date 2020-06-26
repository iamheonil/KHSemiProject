package web.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	System.out.println("updaete [doget] 확인");	
//	if( req.getSession().getAttribute("login") == null) {
//		
//		resp.sendRedirect("/main");
//		
//		return;
//	}	
	
	//전달파라미터 - boardnum
	Board boardnum = boardService.getBoardno(req);
	System.out.println(boardService.getBoardno(req));
	//상세보기 결과 조회
	Board viewBoard = boardService.view(boardnum);
	
	//MODEL로 게시글 전달
	req.setAttribute("viewBoard", viewBoard);
	//VIEW지정
	req.getRequestDispatcher("/WEB-INF/views/board/boardUpdate.jsp").forward(req, resp);
	
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			boardService.updateBoard(req);
			
			resp.sendRedirect("/board/list");
		
	}
	
}
