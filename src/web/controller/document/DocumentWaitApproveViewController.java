package web.controller.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Doc_attach;
import web.dto.Document;
import web.dto.Report_link;
import web.service.face.Doc_attachService;
import web.service.face.Doc_commentService;
import web.service.face.DocumentService;
import web.service.face.Report_linkService;
import web.service.impl.Doc_attachServiceImpl;
import web.service.impl.Doc_commentServiceImpl;
import web.service.impl.DocumentServiceImpl;
import web.service.impl.Report_linkServiceImpl;

@WebServlet("/document/approve/view")
public class DocumentWaitApproveViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();
	private Doc_attachService doc_attachService = new Doc_attachServiceImpl();
	private Report_linkService report_linkService = new Report_linkServiceImpl();
	private Doc_commentService doc_commentService = new Doc_commentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 얻기 - documentno
		Document documentno = documentService.getDocumentno(req);
		System.out.println(documentno);
		
		//문서정보 조회 - Document
		Document viewDocument = documentService.getDocument(documentno);
		req.setAttribute("viewDocument", viewDocument);

		//의견/지시 결과 조회 - Doc_comment
		ArrayList<Map<String, Object>> viewComment  = doc_commentService.getDoc_comment(documentno);
		req.setAttribute("viewComment", viewComment);
		
		//첨부파일
		Doc_attach attach = doc_attachService.getDoc_attach(documentno);
		req.setAttribute("viewAttach", attach);
		
		//보고경로
		Report_link report = report_linkService.getDocReport_Link(documentno);
		req.setAttribute("viewReport", report);
		
		
		req.getRequestDispatcher("/WEB-INF/views/document/waitapprove_view.jsp").forward(req, resp);
		
	}

}
