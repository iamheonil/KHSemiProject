package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ResourcesFilter implements Filter{
	
	// 인코딩 필터
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Resources Filter");
		System.out.println(((HttpServletRequest)request).getRequestURI());
		request.getRequestDispatcher(((HttpServletRequest)request).getRequestURI()).forward(request, response);
	}
	
}