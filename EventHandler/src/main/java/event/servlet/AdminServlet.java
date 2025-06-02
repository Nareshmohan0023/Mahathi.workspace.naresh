package event.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.service.Service;
import event.service.ServiceImpl;
import event.util.ValidatorUtil;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	Service serv = new ServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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
		HttpSession session = request.getSession(false);
//		System.out.println(session.getAttribute("userName"));
		try {
			if (session.getAttribute("userName") == null) {
				System.out.println("inside if");
				request.setAttribute("message", "Invalid Access");
				request.getRequestDispatcher("err.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			request.setAttribute("message", "Invalid Access");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}

		request.setAttribute("userName", session.getAttribute("userName"));
		String action = (String) request.getParameter("action");
		if (request.getParameter("action") == null) {
			action = "home";
		}
		System.out.println("action=" + action);

		if (action.equals("home")) {
			System.out.println("inside home method");
			sendToHome(request, response);
		} else if (action.equals("addStudentDetails")) {
			addStudent(request, response);
		} else if (action.equals("back")) {
			moveToHome(request, response);
		} else if (action.equals("addStudent")) {
			addParticipant(request, response);
		} else if (action.equals("displayStudent")) {
			displayStudent(request, response);
		} else if (action.equals("editStudent")) {
			editStudent(request, response);
		} else if (action.equals("editStudentviaId")) {
			editStudentviaId(request, response);
		} else if (action.equals("makeChanges")) {
			makeChanges(request, response);
		} else {
			request.setAttribute("message", "action not found");
			request.getRequestDispatcher("err.jsp").forward(request, response);

		}
	}

	private void makeChanges(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		List<String> paramNames = new LinkedList<>(params.keySet());
		for (String n : paramNames) {
			System.out.println(n);
		}
		String name = request.getParameter(paramNames.get(0));
		String email = request.getParameter(paramNames.get(1));
		String phone = request.getParameter(paramNames.get(2));
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			serv.updateStudents(name, email, phone, id);
			request.setAttribute("message", "Editted successfully");
			editStudent(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void editStudentviaId(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Map<String, Object>> rows = null;
		try {
			rows = serv.editStudentById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows.isEmpty()){
			request.setAttribute("message", "unable to fetch table");
			try {
				request.getRequestDispatcher("Admin").forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<String> columns = new LinkedList<>(rows.get(0).keySet());
		request.setAttribute("rows", rows);
		request.setAttribute("columns", columns);
		request.setAttribute("id", id);
		try {
			request.getRequestDispatcher("getDetails.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> rows = null;
		try {
			rows = serv.displayStudent();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows.isEmpty()) {
			request.setAttribute("message", "unable to fetch table");
			request.getRequestDispatcher("Admin").forward(request, response);
		}
		List<String> columns = new LinkedList<>(rows.get(0).keySet());
		request.setAttribute("rows", rows);
		request.setAttribute("columns", columns);
		request.getRequestDispatcher("editTable.jsp").forward(request, response);

	}

	private void displayStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Map<String, Object>> rows = serv.displayStudent();
			if (rows.isEmpty()) {
				request.setAttribute("message", "unable to fetch table");
				request.getRequestDispatcher("Admin").forward(request, response);
			}
			List<String> columns = new LinkedList<>(rows.get(0).keySet());
			request.setAttribute("rows", rows);
			request.setAttribute("columns", columns);
			request.getRequestDispatcher("Table.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	}

	private void moveToHome(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	private void addParticipant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if (!ValidatorUtil.isGmail(email)) {
			request.setAttribute("message", "Invalid mail Id,try with valid mail");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
			return;
		}
		String phone = request.getParameter("phone");
		if (!ValidatorUtil.isPhoneNum(phone)) {
			request.setAttribute("message", "Invalid phone number,try with valid mail");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
			return;
		}
		try {
			serv.addParticipants(name, email, phone);
			request.setAttribute("message", "Participants added Successfully");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		}

	}

	private void sendToHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("userName", request.getAttribute("userName"));
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
//			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "action not found");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
