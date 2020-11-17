package com.project.employees.core.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, PATCH");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Expose-Headers", "X-File-Name, Content-Disposition");
    response.setHeader("Access-Control-Allow-Headers",
        "X-Requested-With, Access-Control-Allow-Headers, Authorization, keySession, Content-Type, X-File-Name");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

}