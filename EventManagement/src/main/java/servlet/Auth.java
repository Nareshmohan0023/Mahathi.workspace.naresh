package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Auth() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getSession().getAttribute("admin").equals(true) && request.getSession().getAttribute("admin")!=null) {
    		request.getRequestDispatcher("admin.jsp").forward(request, response);
    	}
    	else if(request.getSession().getAttribute("participant").equals(true) && request.getSession().getAttribute("participant")!=null) {
    		request.getRequestDispatcher("participant.jsp").forward(request, response);
    	}
    	else {
    		response.getWriter().print("<h1>Unauthorized access</h1>");
    	}
    }
}
