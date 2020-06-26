package web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User_basic_detail;
import web.service.face.AddressService;
import web.service.impl.AddressServiceImpl;
import web.util.ad_Paging;

@WebServlet("/admin/address/list")
public class AdminAddressListcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AddressService addressService = new AddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//TEST
//		System.out.println("주소록 목록 호출");

		ad_Paging paging = addressService.getPaging(req);
		System.out.println("테스트 address list " + paging);
		
		//게시글 전체 조회
//		List<User_detail> userList = addressService.getList();
		
		//게시글 페이징 처리 조회
		List<User_basic_detail> detailList = addressService.getList(paging);

		//검색어 MODEL값 전달
//		req.setAttribute("search", search);
		
		//페이징 계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회 결과 MODEL값 전달
		req.setAttribute("detailList", detailList);
		
		//View
		req.getRequestDispatcher("/WEB-INF/views/admin/address/addressList.jsp").forward(req, resp);
	}

}
