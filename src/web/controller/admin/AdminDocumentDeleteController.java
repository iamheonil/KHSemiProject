package web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Document;
import web.service.face.DocumentService;
import web.service.impl.DocumentServiceImpl;

/**
 * Servlet implementation class AdminDocumentDeleteController
 */
@WebServlet("/admin/document/delete")
public class AdminDocumentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Document document = documentService.getDocumentno(req);
		
		documentService.deleteDocument(document);
		
		//리다이렉트
		resp.sendRedirect("/admin/document");
		
		
	}

	
	
}
