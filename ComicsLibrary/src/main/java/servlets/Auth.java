package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Credentials;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Auth() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String username = "";
		
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("username")) {
				username = cookie.getValue();
				break;
			}
		}
		
		if (request.getSession().getAttribute("status").equals(true) && Credentials.getUsername().equals(username)) {
			request.getRequestDispatcher("home.html").forward(request, response);
		} else {
			response.getWriter().print("<h1>Unauthorized access. Please login first.</h1>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	}

}
