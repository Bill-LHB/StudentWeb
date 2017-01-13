package com.lhb.studentmanager;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.lhb.studentmanager.model.User;

/**
 * Servlet Filter implementation class LoginAuthenticationFilter
 */

public class LoginAuthenticationFilter implements Filter {
	private static final String HttpServletResponse = null;
	private String[] urls = null;// 不需要过滤的url数组

	/**
	 * Default constructor.
	 */
	public LoginAuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

		String url = ((HttpServletRequest) request).getRequestURI();
		if (!isFilter(url)) {// 判断是否需要过滤，不需要过滤直接放行
			chain.doFilter(request, response);
		}

		if (((HttpServletRequest) request).getSession().getAttribute("thisUser") == null
				|| "".equals(((HttpServletRequest) request).getSession().getAttribute("thisUser"))) {
			
			
			response.getWriter().println("<script type='text/javascript'>window.parent.location='login_login.do'</script>");

			
			
			//request.getRequestDispatcher("./login.jsp").forward(request, response);
//			//response.sendRedirect(req.getContextPath()+"/login_login.do");
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String url = fConfig.getInitParameter("url");
		urls = url.split(";");
	}

	/**
	 * 判断是否需要过滤
	 * 
	 * @param url
	 * @return
	 */
	private boolean isFilter(String url) {
		boolean item = true;
		for (String u : urls) {
			if (url.contains(u)) {
				item = false;
				break;
			}
		}
		return item;
	}
}
