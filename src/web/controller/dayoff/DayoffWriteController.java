package web.controller.dayoff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.DayoffService;
import web.service.impl.DayoffServiceImpl;



@WebServlet("/dayoff/write")
public class DayoffWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DayoffService dayoffService = new DayoffServiceImpl();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Write [doGET] 확인");
		
//		if( req.getSession().getAttribute("login") == null) {
//			
//			return;
//		}
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/write.jsp").forward(req, resp);
		
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			System.out.println("휴가 신청서 작성 [POST]확인");
			
			dayoffService.dayoffWrite(req);
			
			resp.sendRedirect("/document/dolist");
		}
	
 }