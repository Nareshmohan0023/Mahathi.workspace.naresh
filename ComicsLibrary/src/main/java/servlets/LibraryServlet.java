package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.Credentials;
import service.LibraryServiceImpl;
import utitls.HtmlHelpers;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibraryServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getSession().getAttribute("status").equals(true) && request.getCookies().equals(Credentials.getUsername())) {
				if (request.getParameter("action").equals("viewBooks")) {
					getBooks(request, response);
				} else if (request.getParameter("action").equals("viewByID")) {
					try {
						getBooksByID(request, response);
					} catch (NumberFormatException | ClassNotFoundException | ServletException | SQLException | IOException e) {
						response.getWriter().print(HtmlHelpers.error("isbn : enter only numbers"));
						e.printStackTrace();
					}
				} else if (request.getParameter("action").equals("addBook")) {
					addBook(request, response);
				} else if (request.getParameter("action").equals("search")) {
					try {
						search(request, response);
					} catch (ClassNotFoundException | ServletException | SQLException e) {
						e.printStackTrace();
					}
				}else if(request.getParameter("action").equals("edit")){
					updateBook(request,response);
				}
				else {
					response.getWriter().print("<h1>Invalid URL</h1>");
				}
			} else {
				response.getWriter().print("<h1>Unauthorized access. Please login first.</h1>");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		try {
			String isbn = request.getParameter("isbn");
			String column = request.getParameter("column");
			String value = request.getParameter("value");
			LibraryServiceImpl.updateBook(column, value, Integer.valueOf(isbn));
			getBooks(request, response);
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	// GET ALL 
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			ResultSet set = LibraryServiceImpl.viewBook();
			ResultSetMetaData metaData = set.getMetaData();
			int columnCount = metaData.getColumnCount();

			List<String> columns = new ArrayList<>();
			List<Map<String, Object>> rows = new ArrayList<>();
			
			for(int i=1; i<=columnCount; i++) {
				columns.add(metaData.getColumnName(i));
			}
			while(set.next()) {
				Map<String,Object> row  = new HashMap<>();
				for(String column : columns) {
					row.put(column, set.getObject(column));
				}
				rows.add(row);
			}
			request.setAttribute("columns", columns);
			request.setAttribute("rows", rows);
			request.getRequestDispatcher("searchResult.jsp").forward(request, response);
			
				
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
	}

	// GET BY ID
	protected void getBooksByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, NumberFormatException, ClassNotFoundException, SQLException, IOException {
		PrintWriter out = response.getWriter();
		request.setAttribute("rs", LibraryServiceImpl.viewBookByISBN(Integer.valueOf(request.getParameter("isbn"))));
		request.getRequestDispatcher("book.jsp").forward(request, response);
		response.setContentType("text/html");

	}
	
	// ADD BOOK
	protected void addBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Book book = new Book();
		String bookname = request.getParameter("book");
		String author = request.getParameter("author");
		int isbn = Integer.valueOf(request.getParameter("isbn"));
		
		book.setBook(bookname);
		book.setAuthor(author);
		book.setIsbn(isbn);

		try {
			LibraryServiceImpl.addBook(book);
			getBooks(request, response);
		} catch (SQLException e) {
			out.print(HtmlHelpers.error("isbn"));
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// SEARCH BOOK
	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String keyword = request.getParameter("keyword");
		ResultSet set  = LibraryServiceImpl.searchBooks(keyword.trim());
		ResultSetMetaData metaData = set.getMetaData();
		int columnCount = metaData.getColumnCount();

		List<String> columns = new ArrayList<>();
		List<Map<String, Object>> rows = new ArrayList<>();
		
		for(int i=1; i<=columnCount; i++) {
			columns.add(metaData.getColumnName(i));
		}
		while(set.next()) {
			Map<String,Object> row  = new HashMap<>();
			for(String column : columns) {
				row.put(column, set.getObject(column));
			}
			rows.add(row);
		}
		request.setAttribute("columns", columns);
		request.setAttribute("rows", rows);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
		
	}
}
