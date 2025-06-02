package management.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import management.service.Service;
import management.service.ServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	Service serv=new ServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getMethod();
		if(method.equalsIgnoreCase("GET")) {
			doGet(request,response);
		}else if(method.equals("POST")) {
			doPost(request,response);
		}else {
			super.service(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(serv.isUserNamePresent(userName)) {
			if(serv.validateLoginCredentials(userName, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("userName", userName);
				Cookie userCookie=new Cookie("userName", userName);
				userCookie.setMaxAge(60*60);
				userCookie.setPath("/");
				response.addCookie(userCookie);
//					RequestDispatcher rd=request.getRequestDispatcher("HomeServlet");
//					rd.forward(request, response);
				response.sendRedirect("HomeServlet");
			}else {
				request.setAttribute("message", "Invalid Credentials");
				doGet(request,response);
			}
		}else {
			request.setAttribute("message", "Invalid username or user not found");
			doGet(request,response);
		}
		
	}

}
