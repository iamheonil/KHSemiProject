package web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import web.util.SearchPaging;

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
	public SearchPaging getTempSearchPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//검색어
		String search = (String)req.getParameter("search");
		
		//날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		
		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");
		
		System.out.println("로그인한 userid" + userid);
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectTempSearchCntAll(search, userid, startDate, endDate);
		
		// Paging 객체 생성 
		SearchPaging paging = new SearchPaging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);

		return paging;
	}


	@Override
	public ArrayList<Map<String, Object>> getListSearchTemp(SearchPaging paging, int userid, String startDate, String endDate) {
		
		return documentDao.selectTempSearch(paging, userid, startDate, endDate);
	}

	@Override
	public Document getDocumentno(HttpServletRequest req) {
		
		//doc_num를 저장할 객체 생성
		Document documentno = new Document();
		
		//boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("doc_num");
		if(param!=null && !"".equals(param)) {
			
			//documentno 전달파라미터 추출
			documentno.setDoc_num(Integer.parseInt(param));
		}
		
		//결과 객체 반환
		return documentno;
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
		
		return documentDao.selectDocumentByDocno(doc);
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
	public ArrayList<Map<String, Object>> getListApprove(Paging paging) {
		
		return documentDao.selectApproveAll(paging);
	}
	

	@Override
	public SearchPaging getDocumentPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//검색어
		String search = (String)req.getParameter("search");
		
		//날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
	
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectDocumentSearchCntAll(search, startDate, endDate);
		
		// Paging 객체 생성 
		SearchPaging paging = new SearchPaging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);

		return paging;
	}
	

	@Override
	public ArrayList<Map<String, Object>> getListDocumentAll(SearchPaging paging, String startDate, String endDate) {
		
		return documentDao.selectDocumentAll(paging, startDate, endDate);
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
		
		System.out.println("names : " +  names );
		documentDao.deleteDoc_commentList(names);
		documentDao.deleteDocReport_linkList(names);
		documentDao.deleteDoc_attachList(names);
		documentDao.deleteDocList(names);
	}


}
