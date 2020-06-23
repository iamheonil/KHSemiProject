package web.controller.admin;

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
import web.util.Paging;



@WebServlet("/admin/dayoff/list")
public class DayoffListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DayoffService dayoffService = new DayoffServiceImpl();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		//요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = dayoffService.getPaging(req);
		
		//게시글 페이징 처리 조회
		List<Dayoff> dayoffList = dayoffService.getList(paging);
		
		//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("dayoffList", dayoffList);
		
		//VIEW 지정 및 응답 - forward 
		req.getRequestDispatcher("/WEB-INF/views/admin/dayoff/list.jsp").forward(req, resp);
		
	}


}
