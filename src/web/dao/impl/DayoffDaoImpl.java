package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import web.dao.face.DayoffDao;
import web.dto.Dayoff;
import web.util.Paging;

public class DayoffDaoImpl implements DayoffDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	@Override
	public List<Dayoff> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Dayoff> selectAll(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Dayoff> selectbyUserId(Dayoff userid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int selectCntAll() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void insert(Dayoff dayoff) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Dayoff dresult) {
		// TODO Auto-generated method stub
		
	}
	
}
