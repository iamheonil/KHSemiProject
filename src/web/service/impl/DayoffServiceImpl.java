package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Dayoff;
import web.service.face.DayoffService;
import web.util.Paging;
import web.dao.face.DayoffDao;
import web.dao.impl.DayoffDaoImpl;


public class DayoffServiceImpl implements DayoffService {
	
	private DayoffDao dayoffDao = new DayoffDaoImpl();

	@Override
	public List<Dayoff> getList() {
		// TODO Auto-generated method stub
		return dayoffDao.selectAll();
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dayoff> getList(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkId(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dayoff getDaynum(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	
	



	
}
