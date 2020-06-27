package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.face.Report_linkDao;
import web.dbutil.JDBCTemplate;
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
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "select * FROM report_link R";
//		sql += "	inner join Document D on D.doc_num = R.doc_num";
		sql += "	where doc_num = ?";
		
		Report_link d = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, doc.getDoc_num());
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				d = new Report_link(); //결과값 저장 객체
				
				//결과값 한 행 처리
				d.setReport_type(rs.getString("report_type"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return d;
	}

	@Override
	public void insertReplaceReport_link(Report_link report_link) {
		
	}

	@Override
	public void deleteReplaceReport_link(Document doc) {
		
	}

	
}