package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminAddressDao;
import web.dao.impl.AdminAddressDaoImpl;
import web.dto.User_basic_detail;
import web.dto.User_detail;
import web.service.face.AddressService;
import web.util.ad_Paging;

public class AddressServiceImpl implements AddressService {

	//DAO 객체 생성
	private AdminAddressDao adminaddressDao = new AdminAddressDaoImpl();

	@Override
	public List<User_detail> getList() {
		
		return adminaddressDao.selectAll();
	}

	@Override
	public ad_Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = adminaddressDao.selectCntAll();
	
		//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		ad_Paging paging = new ad_Paging(totalCount, curPage);
		
		//Paging 객체 반환
		return paging;
	}

	@Override
	public List<User_basic_detail> getList(ad_Paging paging) {
		return adminaddressDao.selectAll(paging);
	}
	

}
