package web.dao.impl;

import java.sql.Connection;

import web.dao.face.Report_linkDao;
import web.dto.Report_link;

public class Report_linkDaoImpl implements Report_linkDao {

	@Override
	public Report_link selectReport_linkByDocnum(int doc_num) {
		
		return null;
	}

	@Override
	public int insertReport_link(Connection conn, Report_link report_link) {
		
		return 0;
	}

	@Override
	public int updateReport_link(Connection conn, Report_link report_link) {
		
		return 0;
	}

	@Override
	public Report_link selectReport_link(Report_link report_link) {
		
		return null;
	}

}