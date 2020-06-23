package web.controller.board_comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board_comment;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class BoardCommentDeleteController
 */
@WebServlet("/comment/delete")
public class BoardCommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Board_comment comment = new Board_comment();
	
		String c_num = (String) req.getParameter("c_num");
		
		comment.setC_num( Integer.parseInt(c_num));
		
		boolean succes = boardService.deleteComment(comment);
		
		resp.getWriter().append("{\"succes\":"+succes+"}");
		
	}
	
}
