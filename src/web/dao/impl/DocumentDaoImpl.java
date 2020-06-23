package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.DocumentDao;
import web.dbutil.JDBCTemplate;
import web.dto.Document;
import web.util.Paging;

public class DocumentDaoImpl implements DocumentDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public void insertDoc(Document doc) {
		
	}
	@Override
	public int selectnextDocno() {
		
		return 0;
	}

	@Override
	public int selectTempCntAll() {
		
		return 0;
	}
	@Override
	public int selectTempSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectTempSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectTempAll(Paging paging) {
		
		return null;
	}
	@Override
	public void deleteTemp(Document doc) {
		
	}
	@Override
	public void updateDocument(Document doc) {
		
	}
	@Override
	public int selectWaitApproveCntAll() {
		
		return 0;
	}
	@Override
	public int selectWaitApproveSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectWaitApproveSerach(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectWaitApproveAll(Paging paging) {
		
		return null;
	}
	@Override
	public Document selectDocumentByDocno(Document doc) {
		
		return null;
	}
	@Override
	public int selectProgressCntAll() {
		
		return 0;
	}
	@Override
	public int selectProgressSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectProgressSerach(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectProgressAll(Paging paging) {
		
		return null;
	}
	@Override
	public int selectDraftCntAll() {
		
		return 0;
	}
	@Override
	public int selectDraftSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectDraftSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDraftAll(Paging paging) {
		
		return null;
	}
	@Override
	public int selectApproveCntAll() {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "	SELECT count(*) FROM document D";
		sql += "		join report_link R";
		sql += "		on document.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "		on U.userid = document.userid";
		sql += "		join doc_comment C";
		sql += "		on C.doc_num = document.doc_num";
		sql += "		where r.receiver_id = 2";
		sql += "		and doc_state = '결재완료'";
//		sql += "		on D.doc_num = R.doc_num";
//		sql += "		where R.receiver_id = 2";
//		sql += "		and doc_state='결재완료'";
		
		//결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(totalCount);
		//최종 결과 반환
		return totalCount;
	}
	
	@Override
	public int selectApproveSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectApproveSearch(String search, Paging paging) {
		
		return null;
	}
	
	@Override
	public ArrayList<Map<String, Object>> selectApproveAll(Paging paging) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		//SQL 작성 - 직접 작성한 문서는 아니고 수신자 경로에 자신이 있으면 조회함
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, D.doc_num, d.doc_date, d.doc_title, D.userrank, D.userid, D.state FROM (";
		sql += "		SELECT * FROM document";
		sql += "		join report_link R";
		sql += "		on document.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "		on U.userid = document.userid";
		sql += "		join doc_comment C";
		sql += "		on C.doc_num = document.doc_num";
		sql += "		where R.receiver_id = 2";
		sql += "		and doc_state = '결재완료'";
		sql += "	) D";
		sql += " ) document";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getInt("D.doc_num"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("userid", rs.getString("D.userid"));
				d.put("doc_state", rs.getString("doc_state"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return list;
	}
	@Override
	public int selectDocumentCntAll() {
		
		return 0;
	}
	@Override
	public int selectDocumentSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectDocumentAllSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDocumentAll(Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDoListWaitApprove() {
		
		return null;
	}
	@Override
	public List<Document> selectDoListProgress() {
		
		return null;
	}
	@Override
	public void deleteDocReport_linkList(String names) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteDoc_attachList(String names) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteDocList(String names) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteDoc_commentList(String names) {
		// TODO Auto-generated method stub
		
	}


	
	
}