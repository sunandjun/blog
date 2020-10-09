package com.cos.blog.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharEncFilter implements Filter {

	@Override
	public void destroy() {
		//doFilter을 실행한 후 실행 되는곳	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Character = UTF-8 등록");
		chain.doFilter(request, response);//필터 등록		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//doFilter 실행전에 실행되는곳		
	}
}
