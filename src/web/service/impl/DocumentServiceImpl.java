package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.Doc_attachDao;
import web.dao.face.Doc_commentDao;
import web.dao.face.DocumentDao;
import web.dao.face.Report_linkDao;
import web.dao.impl.Doc_attachDaoImpl;
import web.dao.impl.Doc_commentDaoImpl;
import web.dao.impl.DocumentDaoImpl;
import web.dao.impl.Report_linkDaoImpl;
import web.dto.Document;
import web.service.face.DocumentService;
import web.util.Paging;

public class DocumentServiceImpl implements DocumentService{
	
	private DocumentDao documentDao = new DocumentDaoImpl();
	private Doc_attachDao doc_attachDao = new Doc_attachDaoImpl();
	private Doc_commentDao doc_commentDao = new Doc_commentDaoImpl();
	private Report_linkDao report_linkDao = new Report_linkDaoImpl();
	
	@Override
	public int getDoListWaitApproveCnt() {

		return 0;
	}

	@Override
	public int getDoListProgressCnt() {
		
		return 0;
	}
	
	@Override
	public void writeDoc(HttpServletRequest req) {
		
	}

	@Override
	public Paging getTempPaging(HttpServletRequest req) {
		
		return null;
	}

	@Override
	public List<Document> getListTemp(HttpServletRequest req, Paging paging) {
		
		return null;
	}

	@Override
	public Document getDocumentno(HttpServletRequest req) {
		
		return null;
	}

	@Override
	public void deleteDocument(Document doc) {
		
	}

	@Override
	public Paging getWaitApprovePaging(HttpServletRequest req) {
		
		return null;
	}

	@Override
	public List<Document> getListWaitApprove(HttpServletRequest req, Paging paging) {
		return null;
	}

	@Override
	public Document getDocument(Document doc) {
		return null;
	}

	@Override
	public void writeDoc_comment(Document doc) {
		
	}

	@Override
	public void updateDocument(HttpServletRequest req) {
		
	}

	@Override
	public Paging getProgressPaging(HttpServletRequest req) {
		return null;
	}

	@Override
	public List<Document> getListProgress(HttpServletRequest req, Paging paging) {

		return null;
	}

	@Override
	public Paging getDraftPaging(HttpServletRequest req) {

		return null;
	}

	@Override
	public List<Document> getListDraft(HttpServletRequest req, Paging paging) {

		return null;
	}

	@Override
	public Paging getApprovePaging(HttpServletRequest req) {

		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = documentDao.selectApproveCntAll();
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
		
		//계산된 Paging 객체 반환
		return paging;
	}

	@Override
	public List<Document> getListApprove(Paging paging) {
		return null;

		// return documentDao.selectApproveAll(paging);
	}

	@Override
	public Paging getDocumentPaging(HttpServletRequest req) {

		return null;
	}

	@Override
	public List<Document> getListDocumentAll(HttpServletRequest req, Paging paging) {

		return null;
	}

	@Override
	public List<Document> getDoListWaitApprove() {

		return documentDao.selectDoListWaitApprove();
	}

	@Override
	public List<Document> getDoListProgress() {

		return null;
	}

	@Override
	public void deleteDocumentList(String names) {
		// TODO Auto-generated method stub
		
	}






}
