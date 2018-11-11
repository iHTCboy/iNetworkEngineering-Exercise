package edu.hdu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

	private FilterConfig config;
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //获取该Filter的配置参数
       String encoding = config.getInitParameter("encoding");
       //设置request编码用的字符集
       request.setCharacterEncoding(encoding);
       HttpServletRequest requ = (HttpServletRequest)request;
       HttpSession session = requ.getSession(true);
       //获取客户请求的页面
	   String requestPath = requ.getServletPath();
     //如果session范围的user为null，即表明没有登录
     //且用户请求的不是登录页面
    //且用户请求的既不是登录页面，也不是处理登录的Servlet页面
       if( session.getAttribute("user") == null&& !requestPath.endsWith("/login.html")&& !requestPath.endsWith("/LoginServlet"))
       {
          ((HttpServletResponse) response).sendRedirect("/ServletDemo/login.html");
           return;
       }
       else
       {
    	   chain.doFilter(request, response);
       }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}

}
