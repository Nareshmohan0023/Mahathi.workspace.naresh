package event.servlet;
import java.io.IOException;
//import java.security.Provider.Service;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.service.Service;
import event.service.ServiceImpl;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	Service serv=new ServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("inside doget");
		String action=request.getParameter("action");
		System.out.println(action);
		if(action!=null&&!action.trim().isEmpty()) {
//			System.out.println("inside if");
			if(action.equals("validate")) {
				validate(request,response);
			}else if(action.equals("newUser")) {
				newUser(request,response);
			}else if(action.equals("loadUser")) {
				newUser(request,response);
			}else if(action.equals("loginPage")) {
				redirectLoginPage(request,response);
			}else if(action.equals("addAdmin")) {
				addAdmin(request,response);
			}else if(action.equals("logout")) {
				logout(request,response);
			}else {
				request.setAttribute("message", "Something Went Wrong");
				request.getRequestDispatcher("err.jsp").forward(request, response);
			}
		}else {
			System.out.println("bye");

		}
		
		
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		
		Cookie[] cookies=request.getCookies();
		for(Cookie c:cookies) {
			c.setMaxAge(0);
			c.setValue("");
			response.addCookie(c);
		}
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			if(serv.isUserNameUnique(userName)) {
				if(serv.addAdmin(name,userName,password)) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "unable to add admin");
					request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
				}
				
			}else {
				request.setAttribute("message", "username already exist,failed to add admin");
				request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}

	private void redirectLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","File Not Found(registerAdmin.jsp)");
			request.getRequestDispatcher("err.jsp").forward(request, response);;
		};
	}

	private void newUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  System.out.println("Inside newUser()");
		try {
//			System.out.println("inside try");
			request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("hello");
			e.printStackTrace();
			
		}
	}

	private void validate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			if(!serv.isUserNameUnique(userName)) {
				System.out.println("userPresent");
				if(serv.validateAdmin(userName,password)) {
					
					
					//session
					HttpSession session=request.getSession();
					session.setAttribute("userName", userName);
					
					//cookie
					Cookie userCookie=new Cookie("userName",userName);
					userCookie.setMaxAge(60*60);
					response.addCookie(userCookie);
					
					System.out.println("success");
//					request.setAttribute("message", "user found,welcome admin");
//					request.setAttribute("action", "home");
//					request.getRequestDispatcher("Admin").forward(request, response);
					response.sendRedirect("Admin");
					
					
				}else {
					System.out.println("validation failed");
					request.setAttribute("message", "incorrect password");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}else {
				request.setAttribute("message", "userName not found");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	public static void main(String[] args) {
//		try {
//			DBConnection.getConnection();
//			System.out.println("success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
