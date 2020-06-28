package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.DayoffDao;
import web.dao.impl.DayoffDaoImpl;
import web.dto.Board;
import web.dto.Dayoff;
import web.service.face.DayoffService;
import web.util.ad_Day_Paging;

public class DayoffServiceImpl implements DayoffService {

	private DayoffDao dayoffDao = new DayoffDaoImpl();

	@Override
	public List<Dayoff> getList() {
		return dayoffDao.selectAll();
	}

	@Override
	public List<Dayoff> getList(ad_Day_Paging paging) {
		return dayoffDao.selectAll(paging);
	}

	@Override
	public ad_Day_Paging getPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		int totalCount = dayoffDao.selectCntAll();
		
		ad_Day_Paging paging = new ad_Day_Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public boolean checkId(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dayoff getDaynum(HttpServletRequest req) {
		
		Dayoff daynum = new Dayoff();
		
		//Daynum 전달파라미터 검증 - null, ""
		String param = req.getParameter("daynum");
		if(param!=null && !"".equals(param)) {
			
			//daynum 전달파라미터 추출
			daynum.setDaynum( Integer.parseInt(param) );
		}
		
		//결과 객체 반환
		return daynum;
	}

	@Override
	public void update(HttpServletRequest req) {

		Dayoff dayoff = null;
		
		dayoff = new Dayoff();
		
		if(dayoff!= null) {
			dayoffDao.updateDresult(dayoff);
		}

	}

	@Override
	public void dayoffWrite(HttpServletRequest req) {
		
		Dayoff dayoff = null;
		dayoff = new Dayoff();
		
		dayoff.setUserid( (int) req.getSession().getAttribute("userid"));
		
		int daynum = dayoffDao.selectDaynum();
		
		if(dayoff != null) {
			
			//게시글 번호 입력
			dayoff.setDaynum(daynum);
			
			//게시글 삽입
			dayoffDao.insert(dayoff);
		}
		
		
		dayoffDao.insert(dayoff); //휴가 신청서 삽입
	
	}


	@Override
	public Dayoff view(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDayoff(String names) {

		dayoffDao.deleteDayoffList(names);

	}

	@Override
	public void delete(Dayoff dayoff) {
		
		dayoffDao.deleteDayoff(dayoff);
	}


}
