package web.dao.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.dto.Document;
import web.util.Paging;

public interface DocumentDao {
	
	/**
	 * 문서작성 - Doc 정보 DB저장
	 * 
	 * @param doc - DB에 저장할 전자문서 정보
	 */
	public void insertDoc(Document doc);
	
	/**
	 * 문서 작성 시 Docno nextval 얻어오기
	 * @return int - 현재 작성중인 문서의 번호
	 */
	public int selectnextDocno();
	
	/**
	 * 임시저장 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 임시저장함의 문서 개수
	 */
	public int selectTempCntAll();
	
	
	/**
	 * 임시저장(검색) 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 임시저장함의 문서 개수
	 */
	public int selectTempSearchCntAll();
	
	
	/**
	 * 검색값 있는 임시저장함 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * 
	 * @return List<Document> - 조회된 List<Document> 
	 */
	public List<Document> selectTempSearch(String search, Paging paging);
	
	
	/**
	 * 검색값 없는 임시저장함 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * 
	 * @return List<Document> - 조회된 List<Document> 
	 */
	public List<Document> selectTempAll(Paging paging);
	
	
	/**
	 * doc 문서번호로 문서삭제
	 * 
	 * @param doc - 삭제한 문서번호정보
	 */
	public void deleteTemp(Document doc);
	
	/**
	 * 문서 수정
	 * @param doc - 수정할 docno를 포함한 Document객체
	 */
	public void updateDocument(Document doc);
	
	/**
	 * 결재대기함 페이징에 필요한 개수 조회
	 * 처리할일에도 쓰임
	 * 
	 * @return int - 조회된 결재대기함의 문서 개수
	 */
	public int selectWaitApproveCntAll();
	
	
	/**
	 * 결재대기함(검색) 페이징에 필요한 개수 조회
	 * 
	 * 
	 * @return int - 조회된 결재대기함의 문서 개수
	 */
	public int selectWaitApproveSearchCntAll();
	
	
	/**
	 * 검색값이 있는 결재대기함 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document> 
	 */
	public List<Document> selectWaitApproveSerach(String search, Paging paging);
	
	
	/**
	 * 검색값이 없는 결재대기함 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document> 
	 */
	public List<Document> selectWaitApproveAll(Paging paging);
	
	
	/**
	 * 문서번호로 문서정보얻어오기
	 * 
	 * @param doc - 조회할 문서번호정보
	 * @return Document - 조회된 Document 정보
	 */
	public Document selectDocumentByDocno(Document doc);
	
	
	/**
	 * 진행문서함 페이징에 필요한 개수 조회
	 * 처리할일에도 쓰임
	 * 
	 * @return int - 조회된 진행문서함 문서 개수
	 */
	public int selectProgressCntAll();
	
	
	/**
	 * 진행문서함(검색) 페이징에 필요한 개수 조회
	 * 
	 * 
	 * @return int - 조회된 진행문서함 문서 개수
	 */
	public int selectProgressSearchCntAll();
	
	
	/**
	 * 검색값이 있는 진행문서함 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectProgressSerach(String search, Paging paging);
	
	
	/**
	 * 검색값이 없는 진행문서함 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document> 
	 */
	public List<Document> selectProgressAll(Paging paging);
	
	
	/**
	 * 기안한문서 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 기안한문서 문서 개수
	 */
	public int selectDraftCntAll();
	
	
	/**
	 * 기안한문서(검색) 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 기안한문서 문서 개수
	 */
	public int selectDraftSearchCntAll();
	
	
	/**
	 * 검색값이 있는 기안한문서 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectDraftSearch(String search, Paging paging);
	
	
	/**
	 * 검색값이 없는 기안한문서 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectDraftAll(Paging paging);
	
	
	/**
	 * 결재한문서 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 결재한문서 문서 개수
	 */
	public int selectApproveCntAll();
	
	
	/**
	 * 결재한문서(검색) 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 결재한문서 문서 개수
	 */
	public int selectApproveSearchCntAll();
	
	
	/**
	 * 검색값이 있는 결재한문서 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectApproveSearch(String search, Paging paging);
	
	
	/**
	 * 검색값이 없는 결재한문서 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public ArrayList<Map<String, Object>> selectApproveAll(Paging paging);
	
	
	/**
	 * 문서등록대장 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 문서등록대장 문서 개수
	 */
	public int selectDocumentCntAll();
	
	
	/**
	 * 문서등록대장(검색) 페이징에 필요한 개수 조회
	 * 
	 * @return int - 조회된 문서등록대장 문서 개수
	 */
	public int selectDocumentSearchCntAll();
	
	
	
	/**
	 * 검색값이 있는 문서등록대장 페이징 조회
	 * 
	 * @param search - 검색 값
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectDocumentAllSearch(String search, Paging paging);
	
	
	/**
	 * 검색값이 없는 문서등록대장 페이징 조회
	 * 
	 * @param paging - Paging 객체정보
	 * @return List<Document> - 조회된 List<Document>
	 */
	public List<Document> selectDocumentAll(Paging paging);
	
	
	/**
	 * 처리할일에서 결재대기함 문서 조회(페이징x)
	 * 
	 * @return List<Document> - 조호된 List<Document>
	 */
	public List<Document> selectDoListWaitApprove();
	
	
	/**
	 * 처리할일에서 진행문서함 문서 조회(페이징x)
	 * 
	 * @return List<Document> - 조호된 List<Document>
	 */
	public List<Document> selectDoListProgress();
	
	
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
	
	
}