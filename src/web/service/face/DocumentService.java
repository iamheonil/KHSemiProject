package web.service.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Document;
import web.util.Paging;
import web.util.SearchPaging;

public interface DocumentService {
	
	/**
	 * 처리할 일 - 결재 대기함 문서 총 개수
	 * @return int - 문서 총 개수
	 */
	public int getDoListWaitApproveCnt();
	
	/**
	 * 처리할 일 - 진행 문서함 문서 총 개수
	 * @return int - 문서 총 개수
	 */
	public int getDoListProgressCnt();
	
	
	/**
	 * 문서 작성
	 * @param req - 요청 정보 객체
	 */
	public void writeDoc(HttpServletRequest req);

	// !!! 수정사항 !!!
	/**
	 * @param req - 요청 정보 객체
	 * @return SearchPaging - 페이징 계산이 완료된 객체
	 */
	public SearchPaging getTempSearchPaging(HttpServletRequest req);
	

	// !!!수정사항 !!!
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
	
	/**
	 * 결재대기함 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public Paging getWaitApprovePaging(HttpServletRequest req);
	
	
	/**
	 * 결재대기함 문서 조회
	 * @param req - 요청 정보 객체
	 * @param paging - 페이징 객체
	 * @return List<Document> - 결재대기함 문서 전체 조회 결과 리스트
	 */
	public List<Document> getListWaitApprove(HttpServletRequest req, Paging paging);
	
	
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
	
	/**
	 * 진행문서함 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public Paging getProgressPaging(HttpServletRequest req);
	
	/**
	 * 진행문서함 전체 조회
	 * @param req - 요청 정보 객체
	 * @param paging - 페이징 객체
	 * @return List<Document> - 진행문서함 전체 조회 결과 리스트
	 */
	public List<Document> getListProgress(HttpServletRequest req, Paging paging);
	
	//------- 완료 -------
	
	/**
	 * 기안한 문서 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public Paging getDraftPaging(HttpServletRequest req);
	
	/**
	 * 기안한 문서 전체 조회
	 * @param req - 요청 정보 객체
	 * @param paging - 페이징 객체
	 * @return List<Document> - 기안한 문서 전체 조회 결과 리스트
	 */
	public List<Document> getListDraft(HttpServletRequest req, Paging paging);
	
	
	/**
	 * 결재한 문서 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public Paging getApprovePaging(HttpServletRequest req);
	
	/**
	 * 결재한 문서 전체 조회
	 * @param paging - 페이징 객체
	 * @return List<Document> - 결재한 문서 전체 조회 결과 리스트
	 */
	public ArrayList<Map<String, Object>> getListApprove(Paging paging);

	// !!! 수정사항 !!!
	/**
	 * 문서등록대장 페이징 처리
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 객체
	 */
	public SearchPaging getDocumentPaging(HttpServletRequest req);
	
	
	// !!! 수정사항 !!!
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
	 * 처리할일에서 결재대기함 문서 조회(페이징x)
	 * 
	 * @return List<Document> - 조회된 List<Document> 정보
	 */
	public List<Document> getDoListWaitApprove();
	
	
	/**
	 * 처리할일에서 진행문서함 문서 조회(페이징x)
	 * 
	 * @return List<Document> - 조회된 List<Document> 정보
	 */
	public List<Document> getDoListProgress();

	// !!! 수정사항 !!!
	/**
	 * 임시저장함에서 체크박스로 선택한 문서 삭제
	 * 
	 * @param names - 삭제한 게시글 번호 목록들 문자열
	 */
	public void deleteDocumentList(String names);

}
