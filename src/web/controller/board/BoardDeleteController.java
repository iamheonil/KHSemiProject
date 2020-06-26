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
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Service 객체 생성
		private BoardService boardService = new BoardServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.getRequestDispatcher("/WEB-INF/views/admin/board/delete.jsp").forward(req, resp);
		}
		
}
