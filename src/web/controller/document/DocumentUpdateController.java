package web.controller.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Doc_attach;
import web.dto.Document;
import web.dto.Report_link;
import web.dto.User_basic;
import web.service.face.Doc_attachService;
import web.service.face.Doc_commentService;
import web.service.face.DocumentService;
import web.service.face.Report_linkService;
import web.service.impl.Doc_attachServiceImpl;
import web.service.impl.Doc_commentServiceImpl;
import web.service.impl.DocumentServiceImpl;
import web.service.impl.Report_linkServiceImpl;

@WebServlet("/document/update")
public class DocumentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();
	private Doc_attachService doc_attachService = new Doc_attachServiceImpl();
	private Report_linkService report_linkService = new Report_linkServiceImpl();
	private Doc_commentService doc_commentService = new Doc_commentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//로그인 되어있지 않으면 리다이렉트 
	    if( req.getSession().getAttribute("login") == null ) {
	       resp.sendRedirect("/");
	       return;
	    }
		//전달파라미터 얻기 - documentno
		Document documentno = documentService.getDocumentno(req);
		System.out.println(documentno);
		
		//문서정보 조회 - Document
		Document viewDocument = documentService.getDocument(documentno);
		req.setAttribute("viewDocument", viewDocument);
		System.out.println("게시글 정보" + viewDocument);

		//의견/지시 결과 조회 - Doc_comment
		ArrayList<Map<String, Object>> viewComment  = doc_commentService.getDoc_comment(documentno);
		req.setAttribute("viewComment", viewComment);
		
		//첨부파일
		Doc_attach attach = doc_attachService.getDoc_attach(documentno);
		req.setAttribute("viewAttach", attach);
		
		//보고경로
		Report_link report = report_linkService.getDocReport_Link(documentno);
		req.setAttribute("viewReport", report);
		
		//사원 정보 조회
		List<User_basic> user = documentService.userlist();
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/WEB-INF/views/document/docupdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		documentService.updateDoc(req);
		
		
		
		resp.sendRedirect("/document/list/temp");
	}
}