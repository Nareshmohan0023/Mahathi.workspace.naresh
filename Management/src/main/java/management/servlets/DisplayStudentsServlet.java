package management.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.service.Service;
import management.service.ServiceImpl;

/**
 * Servlet implementation class DisplayStudentsServlet
 */
@WebServlet("/DisplayStudentsServlet")
public class DisplayStudentsServlet extends HttpServlet {
	Service serv=new ServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayStudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Map<String,Object>> rows=new LinkedList<>();
		rows=serv.displayStudents();
		List<String> columns = null;
		if(!rows.isEmpty()) {
			columns=new ArrayList<>(rows.get(0).keySet());
		}else {
			System.out.println("Table not fetched");
		}
		
		request.setAttribute("rows", rows);
		request.setAttribute("columns", columns);
		request.getRequestDispatcher("Table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
