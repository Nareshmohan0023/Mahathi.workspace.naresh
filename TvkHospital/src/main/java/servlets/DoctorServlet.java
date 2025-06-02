package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Doctor;
import service.DocService;
import utils.HtmlHelpers;

@WebServlet("/doctor")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DoctorServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("hos").equals(true) && request.getSession().getAttribute("hos")!=null) {
			String action = request.getParameter("action");

			switch (action) {
			case "add":
				add(request, response);
				break;
			case "edit":
				edit(request, response);
				break;
			case "view":
				view(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "viewAppointments":
				viewAppointment(request, response);
				break;
			}
		}else {
			response.getWriter().print("<h1>Unauthorized access</h1>");
		}
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Doctor doctor = new Doctor();
		doctor.setDocId(Integer.valueOf(request.getParameter("docId")));
		doctor.setDocName( request.getParameter("docName"));
		doctor.setDocSpl(request.getParameter("docSpl"));
		
		try {
			DocService.addDoctor(doctor);
			view(request, response);
			request.setAttribute("docError", null);
		} catch (ClassNotFoundException | SQLException e) {
			if( e instanceof com.microsoft.sqlserver.jdbc.SQLServerException)
			{
				request.setAttribute("docError", e.getMessage());
				request.getRequestDispatcher("viewHos.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int docId = Integer.valueOf(request.getParameter("docid"));
		String newValue = request.getParameter("value");
		String column = request.getParameter("column");
		
		try {
			DocService.editDoctor(column,newValue,docId);
			view(request, response);
			request.setAttribute("docError", null);
		} catch (ClassNotFoundException | SQLException e) {
			if( e instanceof com.microsoft.sqlserver.jdbc.SQLServerException)
			{
				request.setAttribute("docError", e.getMessage());
				request.getRequestDispatcher("viewHos.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int docId = Integer.valueOf(request.getParameter("docId"));
			DocService.deleteDoctor(docId);
			view(request, response);
			request.setAttribute("docError", null);
		} catch (ClassNotFoundException | NumberFormatException |SQLException e) {
			request.setAttribute("docError", e.getMessage());
			request.getRequestDispatcher("hos.jsp").forward(request, response);
			if( e instanceof com.microsoft.sqlserver.jdbc.SQLServerException)
			{
				request.setAttribute("docError", e.getMessage());
				request.getRequestDispatcher("viewHos.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = DocService.viewDoctors();
			HtmlHelpers.prepareTable(request, response, set, "doc");
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	protected void viewAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = DocService.viewAllAppointments();
			HtmlHelpers.prepareTable(request, response, set, "app");
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
