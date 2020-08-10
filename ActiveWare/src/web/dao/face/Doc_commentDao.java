package web.dao.face;

import java.sql.Connection;

import web.dto.Doc_comment;

public interface Doc_commentDao {
	
	/**
	 * 문서번호로 의견/지시 조회
	 * 
	 * @param doc_num - 조회할 문서번호
	 * @return Doc_comment - 조회한 의견/지시 정보
	 */
	public Doc_comment selectDoc_commentByDocnum(int doc_num);
	
	
	/**
	 * 의견/지시 추가
	 * 
	 * @param conn - DB 연결객체
	 * @param doc_comment - 추가할 doc_comment 객체정보 
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int insertDoc_comment(Connection conn, Doc_comment doc_comment);
	
	
	/**
	 * 문서정보창에 필요한 조회
	 * 
	 * @param doc_comment - 조회할 의견/지시 정보
	 * @return Doc_comment - 조회된 의견/지시 정보
	 */
	public Doc_comment selectDoc_comment(Doc_comment doc_comment);
}