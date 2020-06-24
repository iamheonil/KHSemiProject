package web.service.impl;

import web.dao.face.Report_linkDao;
import web.dao.impl.Report_linkDaoImpl;
import web.dto.Document;
import web.dto.Report_link;
import web.service.face.Report_linkService;

public class Report_linkServiceImpl implements Report_linkService {
	
	private Report_linkDao report_linkDao = new Report_linkDaoImpl();

	@Override
	public Report_link getDocReport_Link(Document doc) {
		
		return report_linkDao.selectDocReport_linkByDocno(doc);
	}

}