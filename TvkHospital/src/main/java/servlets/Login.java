package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Credentials;
import utils.LoginValidator;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "login":
			try {
				login(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "logout":
			logout(request, response);
			break;
		case "back":
			
			break;
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		Credentials credentials = new Credentials();
		credentials.setUsername(username);
		credentials.setPassword(password);
		Credentials.isValid = false;
		try {
			boolean isLogin = LoginValidator.isHospital(credentials);
			if(isLogin) {
				Credentials.isValid = true;
				request.getSession().setAttribute("hos", true);
				request.getRequestDispatcher("viewHos.jsp").forward(request, response);
			}
			else {
				Credentials.isValid = false;
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Credentials.isValid = true;
		request.getSession().setAttribute("hos", false);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
