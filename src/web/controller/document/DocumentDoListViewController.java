package web.controller.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.DocumentService;
import web.service.impl.DocumentServiceImpl;

@WebServlet("/document/dolist")
public class DocumentDoListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DocumentService documentService = new DocumentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 되어있지 않으면 리다이렉트 
	      if( req.getSession().getAttribute("login") == null ) {
	         resp.sendRedirect("/");
	         return;
	      }
		
		int userid = 0;
		
		if(req.getSession().getAttribute("userid") != null && !"".equals(req.getSession().getAttribute("userid"))) {
			userid = (int) req.getSession().getAttribute("userid");
		}
		
		// 결재대기함 개수
		int waitApproveCnt = documentService.getDoListWaitApproveCnt(req);
		req.setAttribute("waitApproveCnt", waitApproveCnt);
		
		// 결재대기함 목록
		ArrayList<Map<String, Object>> waitApproveDoList = documentService.getListWaitApproveDo(userid);
		req.setAttribute("waitApproveDoList", waitApproveDoList);
		
		// 진행문서함 개수
		int progressCnt = documentService.getDoListProgressCnt(req);
		req.setAttribute("progressCnt", progressCnt);
		
		// 진행문서함 목록
		ArrayList<Map<String, Object>> progressDoList = documentService.getDoListProgress(userid);
		req.setAttribute("progressDoList", progressDoList);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/document/dolist.jsp").forward(req, resp);
	}
}
