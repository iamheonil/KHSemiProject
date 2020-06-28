package web.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.face.Doc_attachDao;
import web.dao.face.Doc_commentDao;
import web.dao.face.DocumentDao;
import web.dao.face.Report_linkDao;
import web.dao.impl.Doc_attachDaoImpl;
import web.dao.impl.Doc_commentDaoImpl;
import web.dao.impl.DocumentDaoImpl;
import web.dao.impl.Report_linkDaoImpl;
import web.dto.Doc_attach;
import web.dto.Document;
import web.service.face.DocumentService;
import web.util.SearchPaging;
import web.util.ad_Day_Paging;

public class DocumentServiceImpl implements DocumentService {

	private DocumentDao documentDao = new DocumentDaoImpl();
	private Doc_attachDao doc_attachDao = new Doc_attachDaoImpl();
	private Doc_commentDao doc_commentDao = new Doc_commentDaoImpl();
	private Report_linkDao report_linkDao = new Report_linkDaoImpl();

	// 추가!
	@Override
	public int getDoListWaitApproveCnt(HttpServletRequest req) {

		// 빈 값으로 저장
		String search = null;
		String startDate = null;
		String endDate = null;

		int userid = (int) req.getSession().getAttribute("userid");

		return documentDao.selectWaitApproveSearchCntAll(search, userid, startDate, endDate);
	}

	// 추가!
	@Override
	public int getDoListProgressCnt(HttpServletRequest req) {

		// 빈 값으로 저장
		String search = null;
		String startDate = null;
		String endDate = null;

		int userid = (int) req.getSession().getAttribute("userid");

		return documentDao.selectProgressCntAll(search, userid, startDate, endDate);
	}

	@Override
	public void writeDoc(HttpServletRequest req) {
		// ----------- urlencoded 처리 -----------
//		Board board = new Board();
//
//		board.setTitle( req.getParameter("title") );
//		board.setContent( req.getParameter("content") );
//
//		//작성자id 처리
//		board.setId((String) req.getSession().getAttribute("userid"));
//
//		if(board.getTitle()==null || "".equals(board.getTitle())) {
//			board.setTitle("(제목없음)");
//		}
//
//		boardDao.insert(board);
		// ---------------------------------------

		// 게시글 정보 저장할 객체
		Document doc = null;

		// 첨부파일 정보 저장할 객체
		Doc_attach docAttach = null;

		// 파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		// multipart/form-data 인코딩으로 전송되지 않았을 경우
		if (!isMultipart) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; // fileupload() 메소드 실행 중지
		}

		// 게시글 정보 저장할 객체 생성
		doc = new Document();

		// 디스트기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); // 1MB

		// 임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		factory.setRepository(repository);

		// 파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); // 10MB

		// 전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 추출된 전달파라미터 처리 반복자
		Iterator<FileItem> iter = items.iterator();

		// 모든 요청 정보 처리하기
		while (iter.hasNext()) {
			FileItem item = iter.next();

			// 1) 빈 파일 처리
			if (item.getSize() <= 0)
				continue;

			// 2) 일반적인 요청 데이터 처리
			if (item.isFormField()) {

				String key = item.getFieldName(); // 키 추출
				if ("doc_title".equals(key)) { // 전달파라미터 name이 "doc_title"
					try {
						doc.setDoc_title(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				} else if ("doc_content".equals(key)) { // 전달파라미터 name이 "doc_content"
					try {
						doc.setDoc_content(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				} // key값 비교 if end

			} // if( item.isFormField() ) end - 폼필드 확인

			// 3) 파일 처리
			if (!item.isFormField()) {

				// 서버에 저장되는 파일명을
				// "년월일시분초밀리초.확장자" 로 변경하기

				// 파일명 - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());

				// 확장자
				String origin = item.getName(); // 원본파일명
				String ext = origin.substring(origin.lastIndexOf(".") + 1);

				// 저장될 이름
				String stored = rename + "." + ext;

				System.out.println("[TEST] stored file name : " + stored);

				// -------- DB에 업로드된 파일에 대한 정보 기록하기 --------
				docAttach = new Doc_attach();
				docAttach.setAttach_originname(origin);
				docAttach.setAttach_rename(rename);
				docAttach.setAttach_ext(ext);
				docAttach.setAttach_size((int) item.getSize());

				// DB에 기록하기
//				fileDao.insert(uploadFile);
//				doc_attachDao.insertDoc_attach(docAttach);
				// -------------------------------------------

				// --- 로컬 저장소의 파일 객체 생성 ---
				File up = new File(req.getServletContext().getRealPath("upload") // 업로드될 폴더 경로
						, stored // 저장 파일의 이름(변환됨)
				);
				// ------------------------------------

				try {
					item.write(up); // 실제 업로드(최종 결과 파일 생성)
					item.delete(); // 임시 파일 삭제

				} catch (Exception e) {
					e.printStackTrace();
				}

			} // 파일 처리 end

		} // while( iter.hasNext() ) end - FileItem 반복 처리

		// DB데이터 입력

		// 문서 작성자 id 입력
		doc.setUserid((int) req.getSession().getAttribute("userid"));

		// 문서 번호 생성 - Dao 이용
		int docno = documentDao.selectnextDocno();
		// 문서 정보가 있을 경우
		if (doc != null) {

			// 게시글 번호 입력
			doc.setDoc_num(docno);
			// 게시글 삽입
			documentDao.insertDoc(doc);
		}

		// 첨부파일 정보가 있을 경우
		if (docAttach != null) {
			// 게시글 번호 입력
			docAttach.setDoc_num(docno);
			System.out.println(docAttach);
			// 첨부파일 삽입
//			boardDao.insertFile(boardFile);
			doc_attachDao.insertDoc_attach(docAttach);
		}

	}

	@Override
	public SearchPaging getTempSearchPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");

		System.out.println("로그인한 userid" + userid);

		// Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectTempSearchCntAll(search, userid, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public ArrayList<Map<String, Object>> getListSearchTemp(SearchPaging paging, int userid, String startDate,
			String endDate) {

		return documentDao.selectTempSearch(paging, userid, startDate, endDate);
	}

	@Override
	public Document getDocumentno(HttpServletRequest req) {

		// doc_num를 저장할 객체 생성
		Document documentno = new Document();

		// boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("doc_num");
		if (param != null && !"".equals(param)) {

			// documentno 전달파라미터 추출
			documentno.setDoc_num(Integer.parseInt(param));
		}

		// 결과 객체 반환
		return documentno;
	}

	@Override
	public void deleteDocument(Document doc) {

		documentDao.deleteTemp(doc);

	}

	// 추가!
	@Override
	public SearchPaging getWaitApprovePaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");

		System.out.println("로그인한 userid" + userid);

		int totalCount = documentDao.selectWaitApproveSearchCntAll(search, userid, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	// 추가!
	@Override
	public ArrayList<Map<String, Object>> getListWaitApprove(SearchPaging paging, int userid, String startDate,
			String endDate) {

		return documentDao.selectWaitApproveSerach(paging, userid, startDate, endDate);
	}

	// 추가!
	@Override
	public ArrayList<Map<String, Object>> getListWaitApproveDo(int userid) {

		return documentDao.selectWaitApproveDo(userid);
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

	// 추라!
	@Override
	public SearchPaging getProgressPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");

		System.out.println("로그인한 userid" + userid);

		int totalCount = documentDao.selectProgressCntAll(search, userid, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public ArrayList<Map<String, Object>> getListProgress(SearchPaging paging, int userid, String startDate,
			String endDate) {

		return documentDao.selectProgressSerach(paging, userid, startDate, endDate);
	}

	@Override
	public SearchPaging getDraftPaging(HttpServletRequest req) {

		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");

		System.out.println("로그인한 userid" + userid);

		// Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectDraftCntAll(search, userid, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public ArrayList<Map<String, Object>> getListDraft(SearchPaging paging, int userid, String startDate,
			String endDate) {

		return documentDao.selectDraftAll(paging, userid, startDate, endDate);
	}

	@Override
	public SearchPaging getApprovePaging(HttpServletRequest req) {

		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// 로그인 중인 userid 값 저장
		int userid = (int) req.getSession().getAttribute("userid");

		System.out.println("로그인한 userid" + userid);

		// Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectApproveCntAll(search, userid, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public ArrayList<Map<String, Object>> getListApprove(SearchPaging paging, int userid, String startDate,
			String endDate) {

		return documentDao.selectApproveAll(paging, userid, startDate, endDate);
	}

	@Override
	public SearchPaging getDocumentPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = documentDao.selectDocumentSearchCntAll(search, startDate, endDate);

		// Paging 객체 생성
		SearchPaging paging = new SearchPaging(totalCount, curPage);

		// 검색어
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
	public ArrayList<Map<String, Object>> getDoListProgress(int userid) {

		return documentDao.selectProgressDo(userid);
	}

	@Override
	public void deleteDocumentList(String names) {

		System.out.println("names : " + names);
		documentDao.deleteDoc_commentList(names);
		documentDao.deleteDocReport_linkList(names);
		documentDao.deleteDoc_attachList(names);
		documentDao.deleteDocList(names);
	}


}
