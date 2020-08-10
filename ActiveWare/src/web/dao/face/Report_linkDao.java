package web.dao.face;

import java.sql.Connection;

import web.dto.Report_link;

public interface Report_linkDao {
	
	/**
	 * 문서번호로 보고경로 조회
	 * 
	 * @param doc_num - 조회할 문서번호
	 * @return Report_link - 조회된 보고경로 정보
	 */
	public Report_link selectReport_linkByDocnum(int doc_num);
	
	
	/**
	 * 보고경로 추가
	 * 
	 * @param conn - DB 연결객체
	 * @param report_link - report_link 객체 정보
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int insertReport_link(Connection conn, Report_link report_link);
	
	
	/**
	 * 보고경로 수정
	 * 
	 * @param conn - DB 연결객체
	 * @param report_link - report_link 객체 정보
	 * @return int - insert 수행결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int updateReport_link(Connection conn, Report_link report_link);
	
	
	/**
	 * 문서정보창에 필요한 조회
	 * 
	 * @param report_link - 조회할 보고경로 정보
	 * @return Report_link - 조회된 보고경로 정보
	 */
	public Report_link selectReport_link(Report_link report_link);
}