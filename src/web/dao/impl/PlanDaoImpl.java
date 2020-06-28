package web.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.PlanDao;
import web.dbutil.JDBCTemplate;
import web.dto.Plan;

public class PlanDaoImpl implements PlanDao {

	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL수행 객체
	private ResultSet rs = null; // SQL조회 결과 객체

	@Override
	public List<Plan> dbPlan(HttpServletRequest req) {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT PLAN_NUM, USERID, PLAN_NAME, to_char(PTIME_START, 'YYYY-MM-DD') AS PTIME_START, to_char(PTIME_END, 'YYYY-MM-DD') AS PTIME_END FROM PLAN"
				+ " WHERE userid = ?";

		// 결과 저장할 List
		List<Plan> allPlan = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) req.getSession().getAttribute("userid"));

			rs = ps.executeQuery(); // SQL 수행 및 결과집합 저장

			// 조회 결과 처리
			while (rs.next()) {
				Plan p = new Plan(); // 결과값 저장 객체

				// 결과값 한 행 처리
				p.setUserid(rs.getInt("userid"));
				p.setPlan_num(rs.getInt("plan_num"));
				p.setPlan_name(rs.getString("plan_name"));
				p.setPtime_start(rs.getString("PTIME_START"));
				p.setPtime_end(rs.getString("PTIME_END"));

				// 리스트에 결과값 저장
				allPlan.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return allPlan;
	}

	@Override
	public void dbInsert(HttpServletRequest req, Plan plan) {
		conn = JDBCTemplate.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO PLAN(PLAN_NUM, USERID, PLAN_NAME, PTIME_START, PTIME_END) ";
		sql += " VALUES (PLAN_SEQ.nextval, ?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) req.getSession().getAttribute("userid"));
			ps.setString(2, plan.getPlan_name());
			ps.setString(3, plan.getPtime_start());
			ps.setString(4, plan.getPtime_end());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB객체 닫기
			JDBCTemplate.close(ps);
		}

	}

	@Override
	public void dbModify(HttpServletRequest req, Plan plan) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "UPDATE PLAN SET PLAN_NAME = ?, PTIME_START = ?, PTIME_END = ? WHERE PLAN_NUM = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, plan.getPlan_name());
			ps.setString(2, plan.getPtime_start());
			ps.setString(3, plan.getPtime_end());
			ps.setInt(4, plan.getPlan_num());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB객체 닫기
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public void dbDelete(Plan plan) {
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		String sql = "";
		sql += "DELETE FROM PLAN WHERE PLAN_NUM = ?";

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체

			ps.setInt(1, plan.getPlan_num()); // 일정 번호 가져오기

			ps.executeUpdate(); // SQL 수행

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB객체 닫기
			JDBCTemplate.close(ps);
		}

	}


}
