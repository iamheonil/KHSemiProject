package web.controller.dayoff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Dayoff;
import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;
import web.util.ad_Day_Paging;

/**
 * Servlet implementation class DayoffListController
 */
@WebServlet("/dayoff/list")
public class DayoffListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DayoffService dayoffService = new DayoffServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DayoffList [DoGet] 확인");

		// 페이징 객체 생성
		ad_Day_Paging paging = dayoffService.getPaging(req);

		// 게시글 조회
		List<Dayoff> list = dayoffService.getList(paging);
		
		//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);

		//조회결과 MODEL값 전달
		req.setAttribute("list", list);

		// VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/mypage/list.jsp").forward(req, resp);

	}

}

