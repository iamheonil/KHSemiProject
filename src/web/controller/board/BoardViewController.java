package web.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.dto.Board_comment;
import web.dto.Comment_comment;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Service 객체 생성
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 얻기 
		Board boardnum = boardService.getBoardno(req);
		
		
		//상세보기 결과 조회 
		Board viewBoard = boardService.view(boardnum);
		
		//죄회결과 MODEL값 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//이름 전달
		req.setAttribute("name", boardService.getName(viewBoard));
//		System.out.println(boardService.getName(viewBoard));
		
		//댓글 리스트 전달
//		Board_comment comment  = new Board_comment();
		List<Board_comment> commentList = boardService.getCommentList(viewBoard);
		req.setAttribute("commentList", commentList);
		
		
		
		
//		_comment 
		Board_comment commentnum = boardService.getCommentno(req);
//		req.setAttribute("commentnum", commentnum);
//		Board_comment viewComment = boardService.viewComment(commentnum);
//		
//		req.setAttribute("viewComment", viewComment);
		
//		System.out.println("니가 널뜨니?"+req.getParameter("cc_num"));
		
		//대댓글 리스트 전달
//		Comment_comment c_comment = new Comment_comment();
//		List<Comment_comment> c_commentList = boardService.getC_CommentList(commentnum);
//		req.setAttribute("c_commentList", c_commentList);
//		
		
		//VIEW forward
		req.getRequestDispatcher("/WEB-INF/views/board/boardView.jsp").forward(req, resp);
	}
	
	
}
