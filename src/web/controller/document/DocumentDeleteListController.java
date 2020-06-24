package web.controller.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.DocumentService;
import web.service.impl.DocumentServiceImpl;

@WebServlet("/document/list/delete")
public class DocumentDeleteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentService documentService = new DocumentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			documentService.deleteDocumentList(names);
		}
		
		resp.sendRedirect("/document/list/temp");

	}

}
