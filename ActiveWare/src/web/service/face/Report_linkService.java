package web.service.face;

import java.sql.Connection;

import web.dto.Report_link;

public interface Report_linkService {
	
	/**
	 * 문서번호로 보고경로 조회
	 * 
	 * @param doc_num - 조회할 문서번호
	 * @return Report_link - 조회된 문서정보
	 */
	public Report_link selectReport_linkByDocnum(int doc_num);
	
	
	/**
	 * 보고경로 추가
	 * 
	 * @param report_link - report_link 객체정보
	 */
	public void insertReport_link(Report_link report_link);
	
	
	/**
	 * 보고경로 수정
	 * 
	 * @param report_link - report_link 객체정보
	 */
	public void updateReport_link(Report_link report_link);
	
	
	/**
	 * 문서정보창에 필요한 조회
	 * 
	 * @param report_link - 조회할 보고경로 정보
	 * @return Report_link - 조회된 보고경로 정보
	 */
	public Report_link selectReport_link(Report_link report_link);
}