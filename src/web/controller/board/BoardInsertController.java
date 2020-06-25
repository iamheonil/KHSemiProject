package web.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	Service 객체 생성
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	System.out.println("Write [doGET] 확인");
	if( req.getSession().getAttribute("login") == null) {
		
		return;
	}
	
	req.getRequestDispatcher("/WEB-INF/views/board/boardInsert.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("글쓰기 [POST]확인");
		boardService.boardInsert(req);
		resp.sendRedirect("/board/list");
	}
}
