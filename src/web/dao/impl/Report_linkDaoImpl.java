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
	public void deleteReport_link(Document doc) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM report_link WHERE doc_num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, doc.getDoc_num());
			
			ps.executeUpdate();
			
//			System.out.println("report_linnk 삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public void updateReport_link(Report_link report_link) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "INSERT INTO report_link(link_num, doc_num, sender_id, receiver_id, report_type, report_version)";
		sql += " VALUES(report_link_seq.nextval, ?, ?, ?, ?, 1)";
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, report_link.getDoc_num());
			ps.setInt(2, report_link.getSender_id());
			ps.setInt(3, report_link.getReceiver_id());
			ps.setString(4, report_link.getReport_type());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
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
	
}