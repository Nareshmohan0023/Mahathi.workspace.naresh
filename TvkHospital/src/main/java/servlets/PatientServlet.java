package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Patient;
import service.PatService;
import utils.HtmlHelpers;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PatientServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("hos").equals(true) && request.getSession().getAttribute("hos")!=null) {
			String action = request.getParameter("action");

			switch (action) {
			case "access":
				request.getRequestDispatcher("viewPat.jsp").forward(request, response);
				break;
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
			}
		}else {
			response.getWriter().print("<h1>Unauthorized access</h1>");
		}
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient patient = new Patient();
		patient.setPatId(Integer.valueOf(request.getParameter("patId")));
		patient.setPatIll(request.getParameter("patIll"));
		patient.setPatName(request.getParameter("patName"));
		int docId = Integer.valueOf(request.getParameter("docId"));
		try {
			PatService.addPatient(patient, docId);
			view(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet set;
		try {
			set = PatService.viewPatients();
			HtmlHelpers.prepareTable(request, response, set, "pat");
		} catch (SQLException | ServletException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
