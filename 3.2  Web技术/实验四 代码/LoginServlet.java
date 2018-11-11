package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
            ServletConfig config=this.getServletConfig();
            request.setCharacterEncoding("GBK"); //处理中文输入乱码
            
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			response.setContentType("text/html;charset=GBK");  //处理中文输出乱码
			String encoding=config.getInitParameter("encoding");
			response.setContentType("text/html;charSet="+encoding);
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>登录结果</title></head>");
			out.println("<body> 您输入的用户名是: " + username + "<br>");
			out.println("----------------------------------------<br>");
			out.println("您输入的密码是: " + password + "</body></html>");
                        //用来测试登录时的过滤器
			HttpSession session=request.getSession();
			session.setAttribute("user", username);
			out.close();
	}

}
