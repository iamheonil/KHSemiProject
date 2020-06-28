package web.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminDocumentDao;
import web.dao.impl.AdminDocumentDaoImpl;
import web.service.face.AdminDocumentService;
import web.util.ad_D_paging;


public class AdminDocumentServiceImpl implements AdminDocumentService {

	private AdminDocumentDao adminDocumentDao = new AdminDocumentDaoImpl();

	@Override
	public ad_D_paging getDocumentPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		// 날짜
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");

		// Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = adminDocumentDao.selectDocumentSearchCntAll(search, startDate, endDate);

		// Paging 객체 생성
		ad_D_paging paging = new ad_D_paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	
	@Override
	public void deleteDocumentList(String names) {
		adminDocumentDao.deleteDocList(names);
		
	}


	@Override
	public ArrayList<Map<String, Object>> getListDocumentAll(ad_D_paging paging, String startDate, String endDate) {
		return adminDocumentDao.selectDocumentAll(paging, startDate, endDate);
	}
	


}
