package web.service.face;


import web.dto.Document;
import web.dto.Report_link;

public interface Report_linkService {
	
	/**
	 * 문서 정보에서 보고경로 조회
	 * @param doc - 조회할 Documentno를 포함하는 객체
	 * @return Report_link - 조회된 보고경로
	 */
	public Report_link getDocReport_Link(Document doc);
	
	
	
}