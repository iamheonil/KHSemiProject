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
 * Servlet implementation class BoardCommentInsertController
 */
@WebServlet("/comment/insert")
public class BoardCommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 doPost(req,resp);
		}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Board_comment comment = boardService.getComment(req);
		
		boardService.insertComment(comment);
		boardService.updateCoCnt(comment.getB_num());
		resp.sendRedirect("/board/view?b_num="+comment.getB_num());
		}
	
}
