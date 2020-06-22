package web.controller.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}