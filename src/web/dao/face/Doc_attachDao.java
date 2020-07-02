package web.dao.face;

import web.dto.Doc_attach;
import web.dto.Document;

public interface Doc_attachDao {
	
	/**
	 * 문서작성 - 첨부파일 DB 저장
	 * 
	 * @param doc_attach - DB에 저장할 첨부파일 정보
	 */
	public void insertDoc_attach(Doc_attach doc_attach);
	
	/**
	 * 임시저장 - 첨부파일 DB 저장
	 * 
	 * @param doc_attach - DB에 저장할 첨부파일 정보
	 */
	public void updateDoc_attach(Doc_attach doc_attach);
	
	/**
	 * Doc 문서번호로 첨부파일 삭제
	 * 
	 * @param doc - 삭제할 문서번호정보
	 */
	public void deleteDoc_attach(Document doc);
	
	
	/**
	 * 문서번호로 첨부파일 정보 얻어오기
	 * 
	 * @param doc - 조회할 문서번호
	 * @return Doc_attach - 조회된 Doc_attach 정보
	 */
	public Doc_attach selectDoc_attachByDoc(Document doc);
}