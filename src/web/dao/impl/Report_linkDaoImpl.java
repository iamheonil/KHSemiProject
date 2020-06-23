package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.dao.face.Report_linkDao;
import web.dto.Document;
import web.dto.Report_link;

public class Report_linkDaoImpl implements Report_linkDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertReport_link(Report_link report_link) {
		
	}

	@Override
	public void deleteReport_link(Document doc) {
		
	}

	@Override
	public void updateReport_link(Document doc) {
		
	}
	
	@Override
	public Report_link selectDocReport_linkByDocno(Document doc) {
		
		return null;
	}

	@Override
	public void insertReplaceReport_link(Report_link report_link) {
		
	}

	@Override
	public void deleteReplaceReport_link(Document doc) {
		
	}

	
}