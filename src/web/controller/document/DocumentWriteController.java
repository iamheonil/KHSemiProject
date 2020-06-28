package web.controller.document;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Document;
import web.dto.User_basic;
import web.service.face.Doc_attachService;
import web.service.face.DocumentService;
import web.service.face.Report_linkService;
import web.service.impl.Doc_attachServiceImpl;
import web.service.impl.DocumentServiceImpl;
import web.service.impl.Report_linkServiceImpl;

@WebServlet("/document/write")
public class DocumentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();
	private Doc_attachService doc_attachService = new Doc_attachServiceImpl();
	private Report_linkService report_linkService = new Report_linkServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		User_basic user = new User_basic();
		//세션 객체 얻기
//		HttpSession session = req.getSession();
//		user.setUserid((int)session.getAttribute("userid"));

		//사원 정보 조회
		List<User_basic> user = documentService.userlist();
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/WEB-INF/views/document/docwrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Document document = new Document();
		
		//세션 객체 얻기
		HttpSession session = req.getSession();
		document.setUserid((int)session.getAttribute("userid"));
		
		documentService.writeDoc(req);
		
		Document doc = documentService.getDocumentno(req);
		report_linkService.getDocReport_Link(doc);
		
		
		resp.sendRedirect("/document/list/temp");
		
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Document document = new Document();
//		
//		//세션 객체 얻기
//		HttpSession session = req.getSession();
//		
//		document.setDoc_title(req.getParameter("doc_title"));
//		document.setDoc_substance(req.getParameter("doc_substance"));
//		document.setDoc_content(req.getParameter("doc_content"));
////		document.setDoc_substance((String)session.getAttribute("doc_substance"));
//		document.setDoc_emergency(req.getParameter("chk"));
//		
//		document.setUserid((int)session.getAttribute("userid"));
//		
//		documentService.writeDoc(document);
//		
//		resp.sendRedirect("/document/list/temp");
//	}

}
