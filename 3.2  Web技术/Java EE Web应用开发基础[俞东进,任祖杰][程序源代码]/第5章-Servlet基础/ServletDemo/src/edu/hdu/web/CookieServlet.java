package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1=new Cookie("login_name","zhangsan");
        Cookie cookie2=new Cookie("login_passworld","123");
        Cookie cookie3=new Cookie("login_sex","male");
        cookie1.setMaxAge(60*60);
        cookie2.setMaxAge(60*60);
        cookie3.setMaxAge(60*60);

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        Cookie[] Cookies=request.getCookies();
        PrintWriter servletOut = response.getWriter();
        if (Cookies==null)
        {
        servletOut.println("none any Cookie");
        }
        else {
        	for(int i=0;i<Cookies.length;i++)
             {
                 servletOut.println(Cookies[i].getName()+"="+Cookies[i].getValue()+"</br>");
             }
      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
