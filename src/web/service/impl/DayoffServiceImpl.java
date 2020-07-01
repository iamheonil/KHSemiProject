package web.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.DayoffDao;
import web.dao.impl.DayoffDaoImpl;
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
	public List<Dayoff> getDayoffById(HttpServletRequest req) {
		
		return dayoffDao.selectById(req);
	}
	
	@Override
	public void accept(String names) {
			
		dayoffDao.acceptDresult(names);
	

	}

	@Override
	public void decline(String names) {
	
		dayoffDao.declineDresult(names);
		
	}
	
	@Override
	public void dayoffWrite(HttpServletRequest req) {
		
		//휴가 신청서 정보 저장할 객체
		Dayoff dayoff = new Dayoff();
		
		//신청서 작성자 id 입력
		dayoff.setUserid((int) req.getSession().getAttribute("userid"));
		
		//휴가 신청서 번호 생성
		int daynum = dayoffDao.selectDaynum();

		//게시글 번호 입력
		dayoff.setDaynum(daynum);
		
		String param = null;
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			param = req.getParameter("daystart");
			dayoff.setDaystart( f.parse(param) );

			param = req.getParameter("daystart");
			dayoff.setDayend( f.parse(param) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dayoff.setDreason(req.getParameter("dreason"));
		
		//게시글 삽입
		dayoffDao.insert(dayoff);
	
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
