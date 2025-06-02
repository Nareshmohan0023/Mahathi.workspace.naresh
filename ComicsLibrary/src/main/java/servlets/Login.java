package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Credentials;
import service.LoginServiceImpl;

@WebServlet("/home")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("action").equals("login"))
		{			
			login(request, response);
		}
		else if(request.getParameter("action").equals("logout")) {
			logout(request,response);
		}
		else if(request.getParameter("action").equals("redirect")) {
			request.getSession().setAttribute("status", true);
	    	request.getRequestDispatcher("home.html").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Credentials credentials = new Credentials();
		credentials.setUser_id(Integer.valueOf(request.getParameter("id")));
		credentials.setPassword(request.getParameter("password"));
		
		try {
			Boolean isLogin = LoginServiceImpl.validateCredentials(credentials);
			if (isLogin) {
				request.getSession().setAttribute("status", true);
				Cookie uName = new Cookie("username", Credentials.getUsername());
				response.addCookie(uName);
		    	request.getRequestDispatcher("Auth").forward(request, response);
			}
			else {
				request.getSession().setAttribute("status", false);
		    	request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		
		} catch (ClassNotFoundException | SQLException | IOException e) {
			response.getWriter().print("<h1>Invalid Credentials</h1>");
			e.printStackTrace();
		}
	}	
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getSession().setAttribute("status", false);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
