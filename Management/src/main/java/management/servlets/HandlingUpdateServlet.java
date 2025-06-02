package management.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.entity.Address;
import management.entity.Student;
import management.service.Service;
import management.service.ServiceImpl;

/**
 * Servlet implementation class HandlingUpdateServlet
 */
@WebServlet("/HandlingUpdateServlet")
public class HandlingUpdateServlet extends HttpServlet {
	Service serv = new ServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandlingUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap.isEmpty()) {
			request.setAttribute("message", "Unable to fetch Details");
			request.getRequestDispatcher("UpdateAddressServlet").forward(request, response);
		}
		for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.println("Parameter: " + paramName);
			for (String value : paramValues) {
				System.out.println("Value: " + value);
			}
		}

		// students
//
		String name = request.getParameter("STUD_NAME");
		String DOBstr = request.getParameter("STUD_DOB");
		Date DOB = Date.valueOf(DOBstr);
		boolean is_current = Boolean.parseBoolean(request.getParameter("CURRENTLY_STUDYING"));
		int addId=Integer.parseInt(request.getParameter("ADD_ID"));

		// address
//
		String street = request.getParameter("ADD_STREET");
		String city = request.getParameter("ADD_CITY");
		String state = request.getParameter("ADD_STATE");

		// id where based on going to update

		int id = Integer.parseInt(request.getParameter("sid"));
		String col = request.getParameter("column");
		String value = request.getParameter("value");

		//

		boolean flag = serv.updateStudentAndAddress(new Student(name, DOB), new Address(street, city, state),
				is_current, id);
		if (flag) {
			request.setAttribute("message", "unable to update due to invalid data input");
			request.getRequestDispatcher("UpdateAddressServlet.jsp").forward(request, response);
			return;
		}
		request.setAttribute("message", "updated successfully");
		request.getRequestDispatcher("UpdateAddressServlet.jsp").forward(request, response);

	}

}
