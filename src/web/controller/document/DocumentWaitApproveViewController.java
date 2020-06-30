package web.controller.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Doc_attach;
import web.dto.Doc_comment;
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
		
		ArrayList<Map<String, Object>> reportcomm = documentService.viewReportComment(documentno);
		req.setAttribute("viewReportComment", reportcomm);
		
//		System.out.println(reportcomm);
		
		req.getRequestDispatcher("/WEB-INF/views/document/waitapprove_view.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Document document = new Document();
		
		//세션 객체 얻기
		
		Doc_comment dcomm = new Doc_comment();
		String approveComm = req.getParameter("approve_comment");
		dcomm.setComm_content(approveComm);
		
		String commType = req.getParameter("approve_type");
		dcomm.setComm_type(commType);
		
		document = documentService.getDocumentno(req);
		dcomm.setDoc_num(document.getDoc_num());
		dcomm.setReceiver_id(document.getUserid());
		
		HttpSession session = req.getSession();
		dcomm.setReceiver_id((int)session.getAttribute("userid"));
		
		System.out.println(dcomm);
		
		doc_commentService.insertDoc_comment(dcomm);
		
//		documentService.writeDoc(req);
		
		
//		Document doc = documenTSERVICE.GETDOCUMENTNO(REQ);
//		REPORT_LINKSERVICE.GETDocReport_Link(doc);
		
		resp.sendRedirect("/document/dolist");
		
	}
	
	

}
