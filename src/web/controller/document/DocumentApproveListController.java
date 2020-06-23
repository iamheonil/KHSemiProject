package web.controller.document;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Document;
import web.service.face.DocumentService;
import web.service.impl.DocumentServiceImpl;
import web.util.Paging;

@WebServlet("/document/list/approve")
public class DocumentApproveListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = documentService.getApprovePaging(req);
		System.out.println("ApproveListController - " + paging);

		//게시글 전체 조회
		List<Document> ApproveList = documentService.getListApprove(paging);
		System.out.println(ApproveList);
		
		//Paging처리 결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("ApproveList", ApproveList);
		
		req.getRequestDispatcher("/WEB-INF/document/approve.jsp").forward(req, resp);
		
	}
}