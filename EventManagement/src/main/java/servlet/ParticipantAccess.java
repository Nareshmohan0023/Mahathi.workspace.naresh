package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Credentials;
import service.EventManagementImpl;
import utils.HtmlHelper;

@WebServlet("/participant")
public class ParticipantAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;    
  
    public ParticipantAccess() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("participant").equals(true) && request.getSession().getAttribute("participant")!=null) {
			String action = request.getParameter("action");
			System.out.println("part3");

			switch (action){
			case "view-participant-id":
				System.out.println("part4");

				viewParticipant(request, response);
				break;
			case "editParticipant":
				System.out.println("edit");
				editParticipant(request,response);
				break;
			}
		}
		else {
			response.getWriter().print("<h1>Unauthorized access</h1>");
		}
	}

	protected void viewParticipant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;

			String pName = Credentials.getuName();
			try {
				set = EventManagementImpl.viewParticipantByID(pName);
				HtmlHelper.prepareTable(request, response, set, "pId");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	protected void editParticipant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("pid"));
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		try {
			EventManagementImpl.editParticipant(column, id, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
