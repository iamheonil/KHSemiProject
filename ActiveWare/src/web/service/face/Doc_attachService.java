package web.service.face;

import web.dto.Doc_attach;

public interface Doc_attachService {
	
	/**
	 * 첨부파일 추가
	 * 
	 * @param doc_attach - doc_attach 객체 정보
	 */
	public void insertDoc_attach(Doc_attach doc_attach);
	
	
	/**
	 * 첨부파일 수정
	 * 
	 * @param doc_attach - doc_attach 객체 정보
	 */
	public void updateDoc_attach(Doc_attach doc_attach);
	
	
	/**
	 * 첨부파일 삭제
	 * 
	 * @param doc_attach - doc_attach 객체 정보
	 */
	public void deleteDoc_attach(Doc_attach doc_attach);
	
	
	/**
	 * 문서정보창에 필요한 조회
	 * 
	 * @param doc_attach - doc_attach 객체 정보
	 * @return Doc_attach - 조회된 첨부파일 정보
	 */
	public Doc_attach selectDoc_attach(Doc_attach doc_attach);
}