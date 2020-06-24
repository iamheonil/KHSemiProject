package web.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;
import web.util.B_Paging;

@WebServlet("/board/notice")
public class BoardNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Service 객체
	private BoardService boardService = new BoardServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("게시판 목록 호출 완료 [GET]");
		
		// 요청 파라미터를 전달을 통해 Paging 객체 생성
		B_Paging paging = boardService.getPaging(req);
		System.out.println("BoardListController " + paging);
		//Paging 결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		// 공지사항 게시글 조회
		List<Board> N_list = boardService.nList();
		
		//조회된 결과 view 전달
		
		req.setAttribute("N_list", N_list);
		System.out.println(N_list);
		//View 지정
		req.getRequestDispatcher("/WEB-INF/views/board/boardNotice.jsp").forward(req, resp);
		
	}
	
}
