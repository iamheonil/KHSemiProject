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



@WebServlet("/dayoff/update")
public class DayoffUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DayoffService dayoffService = new DayoffServiceImpl();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		//로그인 되어있지 않으면 리다이렉트 
//		if( req.getSession().getAttribute("login") == null ) {
//					
//		resp.sendRedirect("/");
//					
//		return;
//		}
				
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/dayoff/list.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//작성글 삽입
		dayoffService.insert(req);
		
		//목록으로 리다이렉션
		resp.sendRedirect("/dayoff/list");
		
	}
}