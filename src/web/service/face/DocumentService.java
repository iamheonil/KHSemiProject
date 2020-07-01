package web.service.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Document;
import web.dto.User_basic;
import web.util.SearchPaging;
import web.util.ad_Day_Paging;

public interface DocumentService {
	
	/** 추가!
	 * 처리할 일 - 결재 대기함 문서 총 개수
	 * 
	 * @param req - req 요청객체
	 * @return int - 문서 총 개수
	 */
	public int getDoListWaitApproveCnt(HttpServletRequest req);
	
	/** 추가!
	 * 처리할 일 - 진행 문서함 문서 총 개수
	 * @return int - 문서 총 개수
	 */
	public int getDoListProgressCnt(HttpServletRequest req);
	
	
	/**
	 * 문서 작성
	 * @param req - 요청 정보 객체
	 */
	public void writeDoc(HttpServletRequest req);

	/**
	 * 문서 작성 시 사원 조회
	 * @param user
	 * @return
	 */
	public List<User_basic> userlist();
	
	
	/**
	 * 문서기안에서 임시저장 눌렀을 때 문서 추가
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void insertTempDoc(HttpServletRequest req);
	
	
	/**
	 * 문서 작성(임시저장)
	 * @param req - 요청 정보 객체
	 */
	public void updateDoc(HttpServletRequest req);
	

	/**
	 * @param req - 요청 정보 객체
	 * @return SearchPaging - 페이징 계산이 완료된 객체
	 */
	public SearchPaging getTempSearchPaging(HttpServletRequest req);
	


	/**
	 * 임시저장함 문서 검색 조회
	 * @param req - 요청 정보 객체
	 * @param paging - 페이징 객체
	 * @return List<Document> - 임시저장함 문서 전체 조회 결과 리스트
	 */
	public ArrayList<Map<String, Object>> getListSearchTemp(SearchPaging paging, int userid, String startDate, String endDate);

	/**
	 * 요청파라미터 얻기
	 * @param req - 요청 정보 객체
	 * @return Document - 전달파라미터 Documentno을 포함한 객체
	 */
	public Document getDocumentno(HttpServletRequest req);
	
	/**
	 * 문서 삭제
	 * @param doc - 삭제할 Documentno를 포함한 객체
	 */
	public void deleteDocument(Document doc);
	
	/** 추가!
	 * 결재대기함 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public SearchPaging getWaitApprovePaging(HttpServletRequest req);
	
	
	/** 추가!
	 * 결재대기함 문서 조회
	 * 
	 * @param paging - 페이징 객체
	 * @param userid - 로그인 한 userid
	 * @param startDate - 시작 값
	 * @param endDate - 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 결재대기함 값
	 */
	public ArrayList<Map<String, Object>> getListWaitApprove(SearchPaging paging, int userid, String startDate, String endDate);
	
	
	/** 추가!
	 * 처리할 일에서 보여질 결재대기함 문서 조회
	 * 
	 * @param userid - 로그인 한 userid
	 * @return ArrayList<Map<String, Object>> - 조회된 결재대기함 값
	 */
	public ArrayList<Map<String, Object>> getListWaitApproveDo(int userid);
	
	
	
	
	/**
	 * 문서 정보 조회 (세부 조회)
	 * @param doc - 조회할 Documentno를 포함하는 객체
	 * @return Document - 조회된 문서
	 */
	public Document getDocument(Document doc);
	

	
	/**
	 * 문서 처리 - 의견/지시 작성, 문서처리구분 선택
	 * @param doc - 처리할 문서 Documentno를 포함하는 객체
	 */
	public void writeDoc_comment(Document doc);
	
	/**
	 * 문서 수정
	 * @param req - 매개변수 맞는지 확인하기!!!
	 */
	public void updateDocument(HttpServletRequest req);
	
	/** 추가!
	 * 진행문서함 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return SearchPaging - 페이징 객체
	 */
	public SearchPaging getProgressPaging(HttpServletRequest req);
	
	
	/**
	 * 진행문서함 전체 조회
	 * 
	 * @param paging - SearchPaging 객체 정보
	 * @param userid - 로그인 한 userid 값
	 * @param startDate - 검색결과 시작 값
	 * @param endDate - 검색결과 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 진행문서함 값
	 */
	public ArrayList<Map<String, Object>> getListProgress(SearchPaging paging, int userid, String startDate, String endDate);
	
	//------- 완료 -------
	
	/**
	 * 기안한 문서 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public SearchPaging getDraftPaging(HttpServletRequest req);
	
	/**
	 * 기안한 문서 전체 조회
	 * @param req - 요청 정보 객체
	 * @param paging - 페이징 객체
	 * @return List<Document> - 기안한 문서 전체 조회 결과 리스트
	 */
	public ArrayList<Map<String, Object>> getListDraft(SearchPaging paging, int userid, String startDate, String endDate);
	
	
	/**
	 * 결재한 문서 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public SearchPaging getApprovePaging(HttpServletRequest req);
	
	/**
	 * 결재한 문서 전체 조회
	 * @param paging - 페이징 객체
	 * @return List<Document> - 결재한 문서 전체 조회 결과 리스트
	 */
	public ArrayList<Map<String, Object>> getListApprove(SearchPaging paging, int userid, String startDate, String endDate);


	/**
	 * 문서등록대장 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public SearchPaging getDocumentPaging(HttpServletRequest req);
	
	/**
	 * 문서등록대장 전체 조회
	 * 
	 * @param paging - 페이징 객체
	 * @param startDate - 시작 값
	 * @param endDate - 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 문서등록대장 목록 값
	 */
	public ArrayList<Map<String, Object>> getListDocumentAll(SearchPaging paging, String startDate, String endDate);

	/**
	 * 처리할일에서 진행문서함 문서 조회(페이징x)
	 * 
	 * @param userid
	 * @return ArrayList<Map<String, Object>> - 조회된 진행문서함 조회
	 */
	public ArrayList<Map<String, Object>> getDoListProgress(int userid);


	/**
	 * 임시저장함에서 체크박스로 선택한 문서 삭제
	 * 
	 * @param names - 삭제한 게시글 번호 목록들 문자열
	 */
	public void deleteDocumentList(String names);

	
	public ArrayList<Map<String, Object>> viewReportComment(Document doc);

}
