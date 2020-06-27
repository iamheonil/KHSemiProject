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
import web.util.SearchPaging;

public class DocumentDaoImpl implements DocumentDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void insertDoc(Document doc) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		String sql = "";
		sql += "INSERT INTO document(";
		sql += " doc_num, doc_title, doc_substance, doc_content, ";
		sql += " doc_state, userid, doc_date, doc_emergency)";
		sql += " values(?,?,?,?,'결재중',?,sysdate,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, doc.getDoc_num());
			ps.setString(2, doc.getDoc_title());
			ps.setString(3, doc.getDoc_substance());
			ps.setString(4, doc.getDoc_content());
			ps.setInt(5, doc.getUserid());
			ps.setString(6, doc.getDoc_emergency());
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int selectnextDocno() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT document_seq.nextval FROM dual";
		
		//결과 저장할 변수
		int docno = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				docno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return docno;
	}

	
	@Override
	public int selectTempSearchCntAll(String search, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		
		// 임시저장함(검색) 조회 개수 조회
		String sql = "";
		sql += "SELECT count(*) FROM document";
		sql += " WHERE userid = ?";
		sql += " 	AND doc_state = '임시저장'";
		if(search != null && !"".equals(search)) { // 검색어 값에 따른 쿼리
		sql += "	AND doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) { // 날짜 값에 따른 쿼리
		sql += "	AND doc_date BETWEEN ? AND ?";
		}
		
		int cnt = 0; // 결과조회개수
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			ps.setString(index++, startDate);
			ps.setString(index++, endDate);
			
			}
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("임시저장함 검색 조회 결과 개수" + cnt);
		return cnt;
	}
	
	@Override
	public ArrayList<Map<String, Object>> selectTempSearch(SearchPaging paging, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, D.doc_num, D.doc_date, D.doc_title, D.dept, D.userrank, D.username FROM (";
		sql += "		SELECT * FROM document";
		sql += "	    JOIN user_basic U on U.userid = document.userid";
		sql += "		WHERE document.userid = ?";
		sql += "			AND document.doc_state = '임시저장'";
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "			AND document.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND document.doc_date BETWEEN ? AND ?";
		}
		sql += "        ORDER BY document.doc_num DESC";
		sql += "        )D";
		sql += "	    )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getInt("doc_num"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
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
	
	// 추가!
	@Override
	public int selectWaitApproveSearchCntAll(String search, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		
		// 결재대기함(검색) 조회 개수 조회
		String sql = "";
		sql += "SELECT count(*) FROM document D";
		sql += " JOIN report_link R";
		sql += " 	ON D.doc_num = R.doc_num";
		sql += " 	WHERE R.receiver_id = ?";
		sql += " 	AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		if(search != null && !"".equals(search)) { // 검색어 값에 따른 쿼리
		sql += "	AND doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) { // 날짜 값에 따른 쿼리
		sql += "	AND doc_date BETWEEN ? AND ?";
		}
		
		int cnt = 0; // 결과조회개수
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			ps.setString(index++, startDate);
			ps.setString(index++, endDate);
			}
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("결재대기함 검색 조회 결과 개수" + cnt);
		return cnt;
	}
	
	// 추가!
	@Override
	public ArrayList<Map<String, Object>> selectWaitApproveSerach(SearchPaging paging, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, DOC.report_type, DOC.doc_date, DOC.doc_title, DOC.dept, DOC.userrank, DOC.username, DOC.doc_emergency FROM (";
		sql += "		SELECT * FROM document D";
		sql += "	    JOIN report_link R ON D.doc_num = R.doc_num";
		sql += "	    JOIN user_basic U ON D.userid = U.userid";
		sql += "		WHERE R.receiver_id = ?";
		sql += "		AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "			AND D.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND D.doc_date BETWEEN ? AND ?";
		}
		
		sql += "        ORDER BY D.doc_num DESC";
		sql += "	)DOC";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				
//				d.put("doc_num", rs.getString("doc_num"));
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	

	@Override
	public ArrayList<Map<String, Object>> selectWaitApproveDo(int userid) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 처리할 일 - 결재대기함 조회
		String sql = "";
		sql += "SELECT rownum rnum, DOC.report_type, DOC.doc_date, DOC.doc_title, DOC.dept, DOC.userrank, DOC.username, Doc.doc_emergency FROM (";
		sql += "	SELECT * FROM document D";
		sql += "	JOIN report_link R ON D.doc_num = R.doc_num";
		sql += "	JOIN user_basic U ON D.userid = U.userid";
		sql += "	WHERE R.receiver_id = ?";
		sql += "	AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		sql += "    ORDER BY D.doc_num DESC";
		sql += " )DOC";

		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
//				d.put("doc_num", rs.getString("doc_num"));
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	
	
	@Override
	public List<Document> selectWaitApproveAll(Paging paging) {
		
		return null;
	}
	@Override
	public Document selectDocumentByDocno(Document doc) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성 - 직접 작성한 문서는 아니고 수신자 경로에 자신이 있으면 조회함
		String sql = "";
		sql += "select * FROM document";
		sql += "	where doc_num = ?";
		
		Document d = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, doc.getDoc_num());
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				d = new Document(); //결과값 저장 객체
				
				//결과값 한 행 처리
				d.setDoc_title(rs.getString("doc_title"));
				d.setDoc_substance(rs.getString("doc_substance"));
				d.setDoc_content(rs.getString("doc_content"));
				d.setDoc_emergency(rs.getString("doc_emergency"));
				
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
	public int selectProgressCntAll(String search, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();		
		
		// 진행문서함(검색) 조회 개수 조회
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += "	SELECT DISTINCT D.* FROM document D";
		sql += " 	JOIN report_link R ON D.doc_num = R.doc_num";
		sql += " 	WHERE 1=1";
		sql += " 	AND ( R.receiver_id = ? OR R.sender_id = ?)";
		sql += " 	AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		if(search != null && !"".equals(search)) { // 검색어 값에 따른 쿼리
		sql += "	AND D.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) { // 날짜 값에 따른 쿼리
		sql += "	AND D.doc_date BETWEEN ? AND ?";
		}
		sql += " )";
		
		
		int cnt = 0; // 결과조회개수
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			ps.setInt(index++, userid);
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			ps.setString(index++, startDate);
			ps.setString(index++, endDate);
			}
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("진행문서함 검색 조회 결과 개수" + cnt);
		return cnt;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> selectProgressSerach(SearchPaging paging, int userid, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 결재대기함 목록조회
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, DOC.doc_num, DOC.report_type, DOC.doc_date, DOC.doc_title, DOC.dept, DOC.userrank, DOC.username, Doc.doc_emergency FROM (";
		sql += "		SELECT D.*, U.*, R.report_type FROM document D";
		sql += "	    JOIN report_link R ON D.doc_num = R.doc_num";
		sql += "	    JOIN user_basic U ON D.userid = U.userid";
		sql += "		WHERE 1=1";
		sql += "		AND R.receiver_id = ?";
		sql += "		AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "		AND D.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "		AND D.doc_date BETWEEN ? AND ?";
		}
		
		sql += "        ORDER BY D.doc_num DESC";
		sql += "	)DOC";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getString("doc_num"));
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> selectProgressDo(int userid) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 처리할일 - 결재진행함 목록 조회
		String sql = "";

		sql += "SELECT rownum rnum, DOC.doc_num, DOC.report_type, DOC.doc_date, DOC.doc_title, DOC.dept, DOC.userrank, DOC.username, Doc.doc_emergency FROM (";
		sql += "	SELECT D.*, U.*, R.report_type FROM document D";
		sql += "	JOIN report_link R ON D.doc_num = R.doc_num";
		sql += "	JOIN user_basic U ON D.userid = U.userid";
		sql += "	WHERE 1=1";
		sql += "	AND R.receiver_id = ?";
		sql += "	AND D.doc_state = '임시저장'"; // 테스트 끝나면 결재중으로 수정해야함!
		sql += "    ORDER BY D.doc_num DESC";
		sql += " )DOC";

		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, userid);
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getString("doc_num"));
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	
	
	
	
	@Override
	public int selectDraftCntAll(String search, int userid, String startDate, String endDate) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += "		SELECT ";
		sql += "			D.doc_num, D.doc_title, D.doc_substance, D.doc_content";
		sql += "			, D.doc_state, D.userid, D.doc_date, D.doc_emergency";
		sql += "			, R.link_num, R.sender_id, R.receiver_id, R.report_type, R.report_version";
		sql += "			, U.username, U.userrank, U.dept";
		sql += "		FROM document D";
		sql += "		join report_link R";
		sql += "			on D.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "			on U.userid = D.userid";
		sql += "		WHERE D.userid = ?";
		sql += "			and D.doc_state = '결재완료'";
		sql += "			and R.report_type = '기안'";
		if(search != null && !"".equals(search)) {
			sql += "		and D.doc_title LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate !=null && !"".equals(endDate)) {
			sql += "		and D.doc_date BETWEEN ? AND ?";
		}
		sql += " ) CNT";


		
		//결과 저장할 변수
		int totalCount = 0;
		int index = 1;
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(index++, userid);
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			ps.setString(index++, startDate);
			ps.setString(index++, endDate);
			
			}
			
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
		//최종 결과 반환
		return totalCount;
	}
	@Override
	public int selectDraftSearchCntAll() {
		
		return 0;
	}
	
	@Override
	public ArrayList<Map<String, Object>> selectDraftAll(SearchPaging paging, int userid, String startDate, String endDate) {
		
		//완료문서 - 기안한 문서 조회
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		//SQL 작성 - 직접 작성한 문서는 아니고 수신자 경로에 자신이 있으면 조회함
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, RES.*";
		sql += "	FROM (";
		sql += "		SELECT ";
		sql += "			D.doc_num, D.doc_title, D.doc_substance, D.doc_content";
		sql += "			, D.doc_state, D.userid, D.doc_date, D.doc_emergency";
		sql += "			, R.link_num, R.sender_id, R.receiver_id, R.report_type, R.report_version";
		sql += "			, U.username, U.userrank, U.dept";
		sql += "		FROM document D";
		sql += "		join report_link R";
		sql += "			on D.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "			on U.userid = D.userid";
		sql += "		WHERE D.userid = ?";
		sql += "			and D.doc_state = '결재완료'";
		sql += "			and R.report_type = '기안'";
		
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "			AND D.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND D.doc_date BETWEEN ? AND ?";
		}
		sql += "		ORDER BY doc_num DESC";
		sql += "	) RES";
		sql += " ) RESULT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		int index=1;
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(index++, userid);
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
//				d.put("userid", rs.getString("userid"));
				d.put("username", rs.getString("username"));
				d.put("doc_state", rs.getString("doc_state"));
				d.put("doc_num", rs.getInt("doc_num"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
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
	public int selectApproveCntAll(String search, int userid, String startDate, String endDate) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += "		SELECT ";
		sql += "			D.doc_num, D.doc_title, D.doc_substance, D.doc_content";
		sql += "			, D.doc_state, D.userid, D.doc_date, D.doc_emergency";
		sql += "			, R.link_num, R.sender_id, R.receiver_id, R.report_type, R.report_version";
		sql += "			, U.username, U.userrank, U.dept";
		sql += "		FROM document D";
		sql += "		join report_link R";
		sql += "			on D.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "			on U.userid = D.userid";
		sql += "		WHERE R.receiver_id = ?";
		sql += "			and D.doc_state = '결재완료'";
		if(search != null && !"".equals(search)) {
			sql += "		and D.doc_title LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate !=null && !"".equals(endDate)) {
			sql += "		and D.doc_date BETWEEN ? AND ?";
		}
		sql += " ) CNT";


		
		//결과 저장할 변수
		int totalCount = 0;
		int index = 1;
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(index++, userid);
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			ps.setString(index++, startDate);
			ps.setString(index++, endDate);
			
			}
			
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
		//최종 결과 반환
		return totalCount;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> selectApproveAll(SearchPaging paging, int userid, String startDate, String endDate) {
		
		//완료문서 - 결재한 문서 조회
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, RES.*";
		sql += "	FROM (";
		sql += "		SELECT ";
		sql += "			D.doc_num, D.doc_title, D.doc_substance, D.doc_content";
		sql += "			, D.doc_state, D.userid, D.doc_date, D.doc_emergency";
		sql += "			, R.link_num, R.sender_id, R.receiver_id, R.report_type, R.report_version";
		sql += "			, U.username, U.userrank, U.dept";
		sql += "		FROM document D";
		sql += "		join report_link R";
		sql += "			on D.doc_num = R.doc_num";
		sql += "		join user_basic U";
		sql += "			on U.userid = D.userid";
//		sql += "		where R.receiver_id = 2";
		sql += "		where R.receiver_id = ?";
		sql += "			and D.doc_state = '결재완료'";
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "			AND D.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND D.doc_date BETWEEN ? AND ?";
		}
		sql += "		ORDER BY doc_num DESC";
		sql += "	) RES";
		sql += " ) RESULT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		int index=1;
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(index++, userid);
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("report_type", rs.getString("report_type"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
//				d.put("userid", rs.getString("userid"));
				d.put("username", rs.getString("username"));
				d.put("doc_state", rs.getString("doc_state"));
				d.put("doc_num", rs.getInt("doc_num"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
//				d.put("userid", rs.getString("D.userid"));
				
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
	public int selectDocumentSearchCntAll(String search, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		
		// 임시저장함(검색) 조회 개수 조회
		String sql = "";
		sql += "SELECT count(*) FROM document";
		sql += " WHERE NOT doc_state = '임시저장'";
		if(search != null && !"".equals(search)) { // 검색어 값에 따른 쿼리
		sql += " AND doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += " AND document.doc_date BETWEEN ? AND ?";
		}
		
		int cnt = 0; // 결과조회개수
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("문서등록대장 검색 조회 결과 개수" + cnt);
		return cnt;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> selectDocumentAll(SearchPaging paging, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 문서등록대장
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, D.doc_num, D.doc_date, D.doc_title, D.dept, D.userrank, D.username, D.doc_state, D.doc_emergency FROM (";
		sql += "	SELECT * FROM document";
		sql += "	JOIN user_basic U on U.userid = document.userid";
		sql += "	WHERE NOT doc_state = '임시저장'";
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "	AND document.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND document.doc_date BETWEEN ? AND ?";
		}
		sql += "	ORDER BY document.doc_num DESC";
		sql += " 	)D";
		sql += " )";
		sql += "WHERE rnum BETWEEN ? AND ?";
		
		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getInt("doc_num"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_state", rs.getString("doc_state"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	
	@Override
	public List<Document> selectDoListWaitApprove() {
		
		return null;
	}
	
	
	@Override
	public List<Document> getProgressDo() {
		
		return null;
	}
	
	
	@Override
	public void deleteDocReport_linkList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM report_link WHERE doc_num IN ( "+names+" )";
		

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}
	
	@Override
	public void deleteDoc_attachList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM doc_attach WHERE doc_num IN ( "+names+" )";
		

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public void deleteDocList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM document WHERE doc_num IN ( "+names+" )";
		

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public void deleteDoc_commentList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM doc_comment WHERE doc_num IN ( "+names+" )";
		

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}


	
	
}