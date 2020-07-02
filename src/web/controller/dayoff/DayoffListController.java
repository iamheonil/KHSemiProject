package web.controller.dayoff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Dayoff;
import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;
/**
 * Servlet implementation class DayoffListController
 */
@WebServlet("/dayoff/list")
public class DayoffListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DayoffService dayoffService = new DayoffServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DayoffList [DoGet] 확인");

		//로그인 체크
//		if( req.getSession().getAttribute("login") == null) {
//			
//			return;
//		}
		
		//세션 객체 생성
		HttpSession session = req.getSession();
		
		
		//세션에서 유저아이디 받아오기
		int userid = (int) session.getAttribute("userid");
		System.out.println("session : " + userid);
	
		// 게시글 조회
		List<Dayoff> list = dayoffService.getDayoffById(userid);

		//조회결과 MODEL값 전달
		req.setAttribute("list", list);

		// VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/mypage/list.jsp").forward(req, resp);
	}

}

