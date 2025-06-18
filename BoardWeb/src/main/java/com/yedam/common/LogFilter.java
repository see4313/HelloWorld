package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	
	public LogFilter() {
		System.out.println("필터객체 생성");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  // do필터를 반드시 만들어줘야됨
			throws IOException, ServletException {
		System.out.println("서블릿 실행 전.");
		
		String host = req.getRemoteAddr(); // 접속하는 ip주소
		String port = ""+ req.getRemotePort();  //""+ 는 스트링타입으로 변환시켜주기 위해서
//		System.out.println("접속Host:" + host + "Port:" + port);
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();  // context는 제일 상위
		String page = uri.substring(context.length());
		System.out.println("IP: " + host + ", page: "  + page);
		
		if(!host.equals("0:0:0:0:0:0:0:1")) {
			System.out.println("IP: " + host + ", page: "  + page);
			return;
		}
		
		chain.doFilter(req, resp);  // 서블릿 실행 (doFilter를 기준으로 서블릿실행 전 후가 나뉜다)
		
		
		System.out.println("서블릿 실행 후.");
		
	}
	

}
