package com.stackroute.muzixmanager.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String authHeader = httpReq.getHeader("authorization");

		if ("OPTIONS".equals(httpReq.getMethod())) {
			httpRes.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request, response);
		} else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Mising or invalid authorization header");
			}
			System.out.println("authHeader::::::::::::::::::::::::::::::s"+authHeader);
			String token = authHeader.substring(7);
			Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
			httpReq.setAttribute("claims", claims);
			chain.doFilter(request, response);
		}
	}

}
