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
import web.util.SearchPaging;

@WebServlet("/document/list/all")
public class DocumentAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인정보 없으면 로그인페이지로
		if( req.getSession().getAttribute("userid") == "" ) {
			resp.sendRedirect("/");
			return;
		}
		
		String startDate = null; // 검색 날짜시작 값 변수
		String endDate = null;  // 검색 날짜종료 값 변수
		
		// req에서 startDate, endDate 값 변수에 각각 저장
		if( req.getParameter("startDate") != null && !"".equals(req.getParameter("startDate")) ) {
			startDate = req.getParameter("startDate");
		}
		if( req.getParameter("endDate") != null && !"".equals(req.getParameter("endDate")) ) {
			endDate = req.getParameter("endDate");
		}
		
		
		//요청 파라미터를 전달하여 Paging 객체 생성하기
		SearchPaging paging = documentService.getDocumentPaging(req);
		System.out.println("DocumentALlListController - " + paging);

		//게시글 전체 조회
		ArrayList<Map<String, Object>> allList = documentService.getListDocumentAll(paging, startDate, endDate);
		System.out.println(allList);
		
		//Paging처리 결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("AllList", allList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/document/doc_all_list.jsp").forward(req, resp);
	}
}