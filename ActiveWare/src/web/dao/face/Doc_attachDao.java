package web.dao.face;

import java.sql.Connection;

import web.dto.Doc_attach;

public interface Doc_attachDao {
	
	/**
	 * 첨부파일 추가
	 * 
	 * @param conn - DB 연결객체
	 * @param doc_attach - doc_attach 객체 정보
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int insertDoc_attach(Connection conn, Doc_attach doc_attach);
	
	
	/**
	 * 첨부파일 수정
	 * 
	 * @param conn - DB 연결객체
	 * @param doc_attach - doc_attach 객체 정보
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int updateDoc_attach(Connection conn, Doc_attach doc_attach);
	
	
	/**
	 * 첨부파일 삭제
	 * 
	 * @param conn - DB 연결객체
	 * @param doc_attach - doc_attach 객체 정보
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int deleteDoc_attach(Connection conn, Doc_attach doc_attach);
	
	
	/**
	 * 문서정보창에 필요한 조회
	 * 
	 * @param doc_attach - 조회할 첨부파일 정보
	 * @return Doc_attach - 조회된 첨부파일 정보
	 */
	public Doc_attach selectDocAttach(Doc_attach doc_attach);
}