package web.dao.face;

import web.dto.Document;
import web.dto.Report_link;

public interface Report_linkDao {
	
	/**
	 * 문서작성 - 보고경로 DB저장
	 * 문서 재검토시에도 쓰임
	 * 
	 * @param report_link - DB에 저장할 보고경로정보
	 */
	public void insertReport_link(Report_link report_link);
	
	
	/**
	 * doc문서번호로 보고경로삭제
	 * 문서 재검토시에도 쓰임
	 * 
	 * @param doc - 삭제할 문서번호정보
	 */
	public void deleteReport_link(Document doc);
	
	/**
	 * 문서 수정 시 보고경로 수정
	 * @param doc - 수정할 문서번호정보
	 */
	public void updateReport_link(Report_link report_link);
	
	/**
	 * 문서번호로 보고경로정보 얻기
	 * 
	 * @param doc - 조회할 문서번호
	 * @return Report_link - 조회된 Report_link 정보
	 */
	public Report_link selectDocReport_linkByDocno(Document doc);
	
	
	/**
	 * 재 검토시 보고경로 추가
	 * 
	 * @param report_link - 보고경로 전체 
	 */
	public void insertReplaceReport_link(Report_link report_link);
	
	
	/**
	 * 재 검토시 보고경로 삭제
	 * 
	 * @param doc - 삭제할 문서번호
	 */
	public void deleteReplaceReport_link(Document doc);
	

}