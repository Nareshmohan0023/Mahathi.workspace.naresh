package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Event;
import entity.Participant;
import service.EventManagementImpl;
import utils.HtmlHelper;

@WebServlet("/admin")
public class AdminAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdminAccess() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String adminCookieName = null;
		for(Cookie c:request.getCookies())
		{
			if(c.getName().equals("admin")) {
				adminCookieName = c.getValue();
				break;
			}
		}
		
		if(request.getSession().getAttribute("admin").equals(true) && request.getSession().getAttribute("admin")!=null && adminCookieName.equals("admin")) {
    		String action = request.getParameter("action");
        	
        	switch (action)
        	{
        	case "view-events":
        		viewEvents(request, response);
        		break;
        	case "add-event":
        		addEvent(request, response);
        		break;
        	case "editEvent":
        		editEvent(request, response);
        		break;
        	case "delete-event":
        		deleteEvent(request, response);
        		break;
        	case "view-participants":
        		viewParticipant(request, response);
        		break;	
        	case "add-participant":
        		addParticipant(request, response);
        		break;
        	case "delete-participant":
        		deleteParticipant(request, response);
        		break;
        	case "add-register":
        		addRegister(request, response);
        		break;
        	case "register":
        		registerDetails(request, response);
        		break;
        	case "view-register":
        		viewRegister(request, response);
        		break;
        	}
    	}
    	else {
    		response.getWriter().print("<h1>Unauthorized access</h1><a href =\"login?action=logout\">Go back</a>");
    	}
		
	}
	
/////////////////////////////////////////VIEW EVENTS///////////////////////////////////////////////////////////
	protected void viewEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = EventManagementImpl.viewAllEvents();
			HtmlHelper.prepareTable(request, response, set,"Events");
			request.setAttribute("event", null);
		} catch (SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("event", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
		
	}
//////////////////////////////////////////ADD EVENT////////////////////////////////////////////////////
	protected void addEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event event = new Event();
		String id = request.getParameter("eId");
		String name = request.getParameter("eName");
		String desc = request.getParameter("eDesc");
		String venue = request.getParameter("eVenue");
		
		event.setEventId(Integer.valueOf(id));
		event.setEventName(name);
		event.setEventDesc(desc);
		event.setEventVenue(venue);
		
		try {
			EventManagementImpl.addEvent(event);
			request.setAttribute("event", null);
			viewEvents(request, response);
		} catch (SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("event", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}
	
///////////////////////////////////////////DELETE EVENT///////////////////////////////////////////////
	protected void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eId = request.getParameter("Id");
		try {
			EventManagementImpl.deleteEvent(Integer.valueOf(eId));
			request.setAttribute("event", null);
			viewEvents(request, response);
		} catch (NumberFormatException | SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("event", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}

////////////////////////////////////////EDIT EVENT////////////////////////////////////////////////
	protected void editEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("eid"));
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		try {
			EventManagementImpl.editEvent(column,id,value);
			request.setAttribute("event", null);
			viewEvents(request, response);
		} catch (NumberFormatException | SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("event", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}

////////////////////////////////////////VIEW PARTICIPANT//////////////////////////////////////////////
	protected void viewParticipant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = EventManagementImpl.viewParticipantList();
			HtmlHelper.prepareTable(request, response, set, "Participants");
			request.setAttribute("participant", null);
		} catch (SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("participant", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}

////////////////////////////////////////////ADD PARTICIPANT///////////////////////////////////////////
	protected void addParticipant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Participant p = new Participant();
		String pId = request.getParameter("pId");
		String pName = request.getParameter("pName");
		String pEmail = request.getParameter("pEmail");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		p.setpId(Integer.valueOf(pId));
		p.setpName(pName);
		p.setEmail(pEmail);
		p.setPhone(Integer.valueOf(phone));
		p.setPassword(pwd);
		
		try {
			EventManagementImpl.addParticipant(p);
			request.setAttribute("participant", null);
			viewParticipant(request, response);
		} catch (SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("participant", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}

/////////////////////////////////////////DELETE PARTICIPANT///////////////////////////////////////////
	protected void deleteParticipant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("Id");
		try {
			EventManagementImpl.deleteParticipant(Integer.valueOf(pId));
			request.setAttribute("participant", null);
			viewParticipant(request, response);
		} catch (NumberFormatException | SQLException e) {
			if (e instanceof com.microsoft.sqlserver.jdbc.SQLServerException) {
		        String msg = e.getMessage();
				request.setAttribute("participant", msg);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				e.printStackTrace();
		    } 
		}
	}

///////////////////////////////////////////////ADD REGISTER///////////////////////////////////////////////
	protected void addRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ResultSet set;
		try {
			set = EventManagementImpl.getDetails();
			HtmlHelper.prepareTable(request, response, set, "Register");
		} catch (SQLException e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
///////////////////////////////////CREATE REGISTER//////////////////////////////////////////////////
	protected void registerDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int pId = Integer.valueOf(request.getParameter("pId"));
		int eId = Integer.valueOf(request.getParameter("eId"));

		try {
			EventManagementImpl.register(eId,pId);
		} catch (SQLException e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
		viewRegister(request, response);
	}
	
///////////////////////////////////////////VIEW REGISTER//////////////////////////////////////////////
	protected void viewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = EventManagementImpl.viewRegisters();
			HtmlHelper.prepareTable(request,response,set,"Register");
		} catch (SQLException e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
	}
}
