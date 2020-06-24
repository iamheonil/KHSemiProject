package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.PlanDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.dto.Plan;

public class PlanDaoImpl implements PlanDao {

	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL수행 객체
	private ResultSet rs = null; // SQL조회 결과 객체

	@Override
	public List<Plan> dbPlan() {

		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT * FROM PLAN";

		// 결과 저장할 List
		List<Plan> allPlan = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery(); // SQL 수행 및 결과집합 저장
			
			// 조회 결과 처리
			while (rs.next()) {
				Plan p = new Plan(); // 결과값 저장 객체

				// 결과값 한 행 처리
				p.setUserid(rs.getInt("userid"));
				p.setPlan_num(rs.getInt("plan_num"));
				p.setPlan_name(rs.getString("plan_name"));
				p.setPtime_start(rs.getDate("ptime_start"));
				p.setPtime_end(rs.getDate("ptime_end"));

				// 리스트에 결과값 저장
				allPlan.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return allPlan;
	}

}
