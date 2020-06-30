package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.DayoffDao;
import web.dbutil.JDBCTemplate;
import web.dto.Dayoff;
import web.util.ad_Day_Paging;

public class DayoffDaoImpl implements DayoffDao {

	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL수행 객체
	private ResultSet rs = null; // SQL조회 결과 객체

	public List<Dayoff> selectAll() {

		conn = JDBCTemplate.getConnection();

		// 수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	daynum";
		sql += "	, userid";
		sql += "	, daystart";
		sql += "	, dayend";
		sql += "	, dreason";
		sql += "	, dresult";
		sql += " FROM Dayoff";
		sql += " ORDER BY rnum DESC";

		// 최종 결과를 저장할 List
		List<Dayoff> list = new ArrayList<Dayoff>();

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {

				Dayoff dayoff = new Dayoff();

				dayoff.setDaynum(rs.getInt("daynum"));
				dayoff.setUserid(rs.getInt("userid"));
				dayoff.setDaystart(rs.getDate("daystart"));
				dayoff.setDayend(rs.getDate("dayend"));
				dayoff.setDreason(rs.getString("dreason"));
				dayoff.setDresult(rs.getString("dresult"));

				list.add(dayoff);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return list;
	}

	public List<Dayoff> selectAll(ad_Day_Paging paging) {

		conn = JDBCTemplate.getConnection();

		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            daynum, userid, daystart,";
		sql += "            dayend, dreason, dresult";
		sql += "        FROM Dayoff";
		sql += "        ORDER BY daynum DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) Dayoff";
		sql += " WHERE rnum BETWEEN ? AND ?";

		// 최종 결과를 저장할 List
		List<Dayoff> list = new ArrayList<Dayoff>();

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {

				Dayoff dayoff = new Dayoff();

				dayoff.setDaynum(rs.getInt("daynum"));
				dayoff.setUserid(rs.getInt("userid"));
				dayoff.setDaystart(rs.getDate("daystart"));
				dayoff.setDayend(rs.getDate("dayend"));
				dayoff.setDreason(rs.getString("dreason"));
				dayoff.setDresult(rs.getString("dresult"));

				list.add(dayoff);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return list;
	}

	@Override
	public int selectCntAll() {

		conn = JDBCTemplate.getConnection();

		// 수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM Dayoff";

		// 최종 결과 변수
		int cnt = 0;

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		System.out.println("조회 개수: " + cnt);

		// 최종 결과 반환
		return cnt;

	}

	@Override
	public void insert(Dayoff dayoff) {

		conn = JDBCTemplate.getConnection();

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO Dayoff(daynum, userid, daystart, dayend, dreason, dresult) ";
		sql += " VALUES (dayoff_seq.nextval, ?, ?, ?, ?, '대기')";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			
			System.out.println("dayoff : " + dayoff);
			System.out.println("getDaystart : " + dayoff.getDaystart());
			
			ps.setInt(1, dayoff.getUserid());
			ps.setDate(2, new java.sql.Date( dayoff.getDaystart().getTime() ) );
			ps.setDate(3, new java.sql.Date( dayoff.getDayend().getTime() ) );
			ps.setString(4, dayoff.getDreason());

			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void acceptDresult(String names) {

		// DB연결
		conn = JDBCTemplate.getConnection();

		// 휴가 신청서 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE Dayoff";
		sql += " SET dresult = '승인'";
		sql += " WHERE daynum  IN ( " + names + " )";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void declineDresult(String names) {
		
		// DB연결
		conn = JDBCTemplate.getConnection();
		
		// 휴가 신청서 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE Dayoff";
		sql += " SET dresult = '거절'";
		sql += " WHERE daynum IN ( " + names + " )";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void deleteDayoff(Dayoff dayoff) {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "DELETE Dayoff";
		sql += " WHERE daynum = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dayoff.getDaynum());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteDayoffList(String names) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "DELETE FROM Dayoff WHERE daynum IN ( " + names + " )";

		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int selectDaynum() {

		// DB연결 객체
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		String sql = "";
		sql += "SELECT dayoff_seq.nextval FROM dual";

		//신청서 번호
		int daynum = 0;

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			rs = ps.executeQuery(); // SQL 수행 및 결과집합 저장

			// 조회 결과 처리
			while (rs.next()) {
				daynum = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		// 최종 결과 반환
		return daynum;
	}



}
