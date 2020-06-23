package web.dao.face;

import web.dto.Doc_comment;
import web.dto.Document;

public interface Doc_commentDao {
	
	/**
	 * doc 문서번호로 의견/지시 삭제
	 * 
	 * @param doc - 삭제할 문서번호정보
	 */
	public void deleteDoc_comment(Document doc);
	
	
	/**
	 * 문서번호로 의견/지시 얻기
	 * 
	 * @param doc - 조회할 문서번호
	 * @return Doc_comment - 조회된 Doc_comment 정보
	 */
	public Doc_comment selectDoc_commentByDocno(Document doc);
	
	
	/**
	 * 문서처리(의견/지시)
	 * 
	 * @param doc_comment - 문서처리(의견/지시)정보
	 */
	public void insertDoc_comment(Doc_comment doc_comment);
	
	
	
}