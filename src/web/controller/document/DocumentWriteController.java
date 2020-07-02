package web.controller.document;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Doc_comment;
import web.dto.Document;
import web.dto.Report_link;
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
		//로그인 되어있지 않으면 리다이렉트 
	    if( req.getSession().getAttribute("login") == null ) {
	       resp.sendRedirect("/");
	       return;
	    }
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
		
//		Doc_comment dcomm = new Doc_comment();
//		String approveComm = req.getParameter("approve_comment");
//		dcomm.setComm_content(approveComm);
		
		Document doc = documentService.getDocumentno(req);
		report_linkService.getDocReport_Link(doc);
		
		
//		resp.sendRedirect("/document/list/temp");
		resp.sendRedirect("/document/dolist");
		
	}

}
