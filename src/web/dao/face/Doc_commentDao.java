package web.dao.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public ArrayList<Map<String, Object>> selectDoc_commentByDocno(Document doc);
	
	
	/**
	 * 문서처리(의견/지시)
	 * 
	 * @param doc_comment - 문서처리(의견/지시)정보
	 */
	public void insertDoc_comment(Doc_comment doc_comment);
	
	
	public void updateDoc_comment(Doc_comment comm);
	
	/**
	 * 보고경로의 최대 숫자 알아오기
	 * 
	 * @param comm - 조회하려는 doc_num정보
	 * @return int - 결과 값
	 */
	public int getMaxCommNumByDocNum(Doc_comment comm);
	
	
}