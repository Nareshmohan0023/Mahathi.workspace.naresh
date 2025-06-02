package management.servlets;

import java.io.IOException;
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
 * Servlet implementation class AuditAddressServlet
 */
@WebServlet("/AuditAddressServlet")
public class AuditAddressServlet extends HttpServlet {
	Service serv=new ServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String,Object>> rows=serv.displayAddressAudit();
		if(rows.isEmpty()) {
			request.setAttribute("message", "Unable to fetch record, something went wrong");
			request.getRequestDispatcher("table.jsp").forward(request, response);

		}
		request.setAttribute("rows", rows);
		List<String> columns=new LinkedList<>(rows.get(0).keySet());
		request.setAttribute("columns",columns);
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
