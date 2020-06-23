package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{
	
	// 인코딩 설정값 변수
	private String charset = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 클래스 초기화
//		System.out.println("EncodeFilter - init()");
		
		// web.xml에서 설정한 <init-param> 변수값 얻어오기
		charset = filterConfig.getInitParameter("enc");
	}
	
	// 인코딩 필터
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청 전, 후 필터링 처리
//		System.out.println("EncodeFilter - doFilter()");
		
//		System.out.println("doFilter() 호출 전");
		
		// 한글 인코딩 설정하기
		//	1. POST 요청 정보 인코딩 설정
		request.setCharacterEncoding(charset);
		
		//	2. 응답데이터 ContentType 설정
		response.setContentType("text/html;charset=" + charset);
		
		// 컨트롤러로 요청처리를 보내는 코드
		// 클라이언트와 서블릿은 연결시켜줌
		chain.doFilter(request, response);
		
//		System.out.println("doFilter() 호출 후");
	}
	
}