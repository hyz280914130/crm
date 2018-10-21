package cn.hyz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hyz.domain.User;

public class AutoLoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user!=null) {
			res.sendRedirect(request.getServletContext().getContextPath()+"/index.htm");
		}else {
			res.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
		}
		
		chain.doFilter(req, res);
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("执行了");
	}

}
