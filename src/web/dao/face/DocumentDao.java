package web.dao.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.dto.Doc_comment;
import web.dto.Document;
import web.dto.User_basic;
import web.util.Paging;
import web.util.SearchPaging;

public interface DocumentDao {
	
	/**
	 * 문서작성 - Doc 정보 DB저장
	 * 
	 * @param doc - DB에 저장할 전자문서 정보
	 */
	public void insertDoc(Document doc);
	
	
	/**
	 * 문서기안에서 임시저장 눌렀을 때 문서 추가
	 * 
	 * @param doc - DB에 저장할 전자문서 정보
	 */
	public void insertTempDoc(Document doc);
	
	
	/**
	 * 문서 임시저장
	 * 
	 * @param doc - DB에 저장한ㄹ 전자문서 정보
	 */
	public void updateDoc(Document doc);
	
	
	/**
	 * 문서 작성 시 사원 조회
	 * @param user
	 * @return
	 */
	public List<User_basic> selectUser();
	
	/**
	 * 문서 작성 시 Docno nextval 얻어오기
	 * 
	 * @return int - 현재 작성중인 문서의 번호
	 */
	public int selectnextDocno();
	

	/**
	 * 임시저장함 페이징에 필요한 개수 조회
	 * 
	 * @param search - 검색 값
	 * @param userid - 로그인 한 userid 정보
	 * @param startDate - 검색날짜 시작 값
	 * @param endDate - 검색날짜 종료 값
	 * @return int - 조회된 개수
	 */
	public int selectTempSearchCntAll(String search, int userid, String startDate, String endDate);

	
	
	/**
	 * 임시저장함 목록 조회
	 * 
	 * @param paging - paging 객체
	 * @param userid - 로그인 한 userid 정보
	 * @param startDate - 검색날짜 시작 값 
	 * @param endDate - 검색날짜 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회결과
	 */
	public ArrayList<Map<String, Object>> selectTempSearch(SearchPaging paging, int userid, String startDate, String endDate);
	
	/**
	 * doc 문서번호로 문서삭제
	 * 
	 * @param doc - 삭제한 문서번호정보
	 */
	public void deleteTemp(Document doc);
	
	
	/** 
	 * 결재대기함(검색) 페이징에 필요한 개수 조회
	 * 
	 * 
	 * @return int - 조회된 결재대기함의 문서 개수
	 */
	public int selectWaitApproveSearchCntAll(String search, int userid, String startDate, String endDate);
	

	/** 추가!
	 * 결재대기함 값 조회
	 * 
	 * @param paging - paging 객체정보
	 * @param userid - 로그인 한 userid정보값
	 * @param startDate - 검색결과 시작 값
	 * @param endDate - 검색결과 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 결재대기함 값
	 */
	public ArrayList<Map<String, Object>> selectWaitApproveSerach(SearchPaging paging, int userid, String startDate, String endDate);
	
	/** 추가!
	 * 결재대기함 값 조회
	 * 
	 * @param userid - 로그인 한 userid정보값
	 * @return ArrayList<Map<String, Object>> - 조회된 결재대기함 값
	 */
	public ArrayList<Map<String, Object>> selectWaitApproveDo(int userid);
	
	
	/**
	 * 문서번호로 문서정보얻어오기
	 * 
	 * @param doc - 조회할 문서번호정보
	 * @return Document - 조회된 Document 정보
	 */
	public Document selectDocumentByDocno(Document doc);
	
	
	/** 추가!
	 * 진행문서함 페이징에 필요한 개수 조회
	 * 
	 * @param search - 검색 값
	 * @param userid - 로그인 한 userid
	 * @param startDate - 검색결과 시작 값
	 * @param endDate - 검색결과 종료 값
	 * @return int - 조회된 개수
	 */
	public int selectProgressCntAll(String search, int userid, String startDate, String endDate);
	
	
	/** 추가!
	 * 진행문서함 전체 조회
	 * 
	 * @param paging - SearchPaging 객체 정보
	 * @param userid - 로그인 한 userid 값
	 * @param startDate - 검색결과 시작 값
	 * @param endDate - 검색결과 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 진행문서함 값
	 */
	public ArrayList<Map<String, Object>> selectProgressSerach(SearchPaging paging, int userid, String startDate, String endDate);
	

	
	/** 추가!
	 * 처리할 일 - 진행문서함 값
	 * 
	 * @param userid - 로그인 한 userid
	 * @return ArrayList<Map<String, Object>> - 조회된 진행문서함 값
	 */
	public ArrayList<Map<String, Object>> selectProgressDo(int userid);
	
	
	/**
	 * 기안한문서 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 기안한문서 문서 개수
	 */
	public int selectDraftCntAll(String search, int userid, String startDate, String endDate);
	
	
	/**
	 * 검색값이 없는 기안한문서 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public ArrayList<Map<String, Object>> selectDraftAll(SearchPaging paging, int userid, String startDate, String endDate);
	
	
	/**
	 * 결재한문서 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 결재한문서 문서 개수
	 */
	public int selectApproveCntAll(String search, int userid, String startDate, String endDate);
	
	
	/**
	 * 검색값이 없는 결재한문서 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public ArrayList<Map<String, Object>> selectApproveAll(SearchPaging paging, int userid, String startDate, String endDate);
	
	
	/**
	 * 문서등록대장 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param startDate - 검색날짜 시작 값
	 * @param endDate - 검색날짜 종료 값
	 * @return int - 조회된 개수
	 */
	public int selectDocumentSearchCntAll(String search, String startDate, String endDate);
	
	
	/**
	 * 문서등록대장 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @param startDate - 검색날짜 시작 값
	 * @param endDate - 검색날짜 종료 값
	 * @return ArrayList<Map<String, Object>> - 조회된 문서등록대장 값
	 */
	public ArrayList<Map<String, Object>> selectDocumentAll(SearchPaging paging, String startDate, String endDate);
	
	/**
	 * 체크박스로 삭제하기
	 * @param names
	 */
	public void deleteDocReport_linkList(String names);
	
	/**
	 * 체크박스로 삭제하기
	 * @param names
	 */
	public void deleteDoc_attachList(String names);
	
	/**
	 * 체크박스로 삭제하기
	 * @param names
	 */
	public void deleteDocList(String names);
	
	/**
	 * 체크박스로 삭제하기
	 * @param names
	 */
	public void deleteDoc_commentList(String names);

	public ArrayList<Map<String, Object>> selectReportComment(Document doc);
	
	/**
	 * 마지막 보고자가 의견 달을 떄 문서상태 결재완료로 변경
	 * 
	 * @param comm - 문서번호
	 */
	public void updateDocState(Doc_comment comm);

	/**
	 * 보고타입이 중단일 떄 문서상태 중단으로 변경
	 * 
	 * @param comm - 문서번호
	 */
	public void updateDocStateStop(Doc_comment comm);
	
	
}