package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminBoardDao;
import web.dao.impl.AdminBoardDaoImpl;
import web.dto.Board;
import web.service.face.AdminBoardService;
import web.util.B_Paging;
import web.util.ad_B_Paging;

public class AdminBoardServiceImpl implements AdminBoardService {

	private AdminBoardDao adminboardDao = new AdminBoardDaoImpl();
	
	@Override
	public ad_B_Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			
		}
		
		//Board 테이블의 총 게시글 수 조회
		//검색어
		String search = (String)req.getParameter("search");
		
		int totalCount = adminboardDao.selectCntAll();
		
		//Paging 객체 생성
		ad_B_Paging paging = new ad_B_Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);
		
		return paging;
	}

	@Override
	public List<Board> list(ad_B_Paging paging) {
		return adminboardDao.selectAll(paging);
	}

	@Override
	public List<Board> nlist(ad_B_Paging paging) {
		// TODO Auto-generated method stub
		return adminboardDao.selectNotice(paging);
	}


	@Override
	public void deleteBoardList(String names) {

		adminboardDao.deleteList(names);
		
	}

}
