package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Credentials;
import entity.Participant;
import service.AuthService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String pName;
	private static String pwd;
	
    public Login() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getParameter("action");
    	
    	switch (action)
    	{
    	case "login":
    		login(request, response);
    		break;
    	case "logout":
    		Cookie[] cookies = request.getCookies();
    		for(Cookie c: cookies) {
    			if(c.getName().equals("admin") || c.getName().equals("participant")) {
    				c.setValue(null);
    				c.setMaxAge(0);
    				response.addCookie(c);
    				break;
    			}
    		}
    		logout(request, response);
    		break;
    	case "Back":
    		request.getRequestDispatcher("admin.jsp").forward(request, response);
    		break;
    	}
	}
    

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("admin", false);
		request.getSession().setAttribute("participant", false);
		Credentials.isValid = false;
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Participant p = new Participant();
		 pName = request.getParameter("username");
		 pwd = request.getParameter("password");
		Credentials.setuName(pName);
		p.setpName(pName);
		p.setPassword(pwd);
		try {
			boolean isParticipantLogin = AuthService.participantLogin(p);
			Credentials.isValid = true;
			if((pName.equals("admin") && pwd.equals("admin"))) {
				String admin = "admin";
	    		Cookie c = new Cookie("admin", admin);
	    		response.addCookie(c);
				request.getSession().setAttribute("admin", true);
				request.getRequestDispatcher("auth").forward(request, response);
			}
			else if(isParticipantLogin) {
	    		String participant = "participant";
	    		Cookie c2 = new Cookie("participant", participant);
	    		response.addCookie(c2);
				request.getSession().setAttribute("participant", true);
				request.getRequestDispatcher("auth").forward(request, response);
			}
			else {
				Credentials.isValid = false;
				request.getSession().setAttribute("admin", false);
				request.getSession().setAttribute("participant", false);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		Login.pwd = pwd;
	}
	
	public static String getpName() {
		return pName;
	}

	public static void setpName(String pName) {
		Login.pName = pName;
	}

}
