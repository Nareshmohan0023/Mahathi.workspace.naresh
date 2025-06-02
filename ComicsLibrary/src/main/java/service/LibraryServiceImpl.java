package service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entity.Book;
import utitls.PrepareQuery;
import utitls.Queries;

public class LibraryServiceImpl {
	
	// CREATE BOOK
	public static int addBook(Book book) throws SQLException, ClassNotFoundException, IOException {
	    return PrepareQuery.update(Queries.ADD_BOOK,book.getBook(),book.getAuthor(),book.getIsbn());
	}

	// VIEW BOOK
	public static ResultSet viewBook() throws SQLException, ClassNotFoundException, IOException {
	    ResultSet rs = PrepareQuery.view(Queries.VIEW_BOOKS); 
	    return rs;
	}		

	// VIEW BOOK BY ISBN
	public static ResultSet viewBookByISBN(int isbn) throws SQLException, ClassNotFoundException, IOException {
	    ResultSet rs = PrepareQuery.view(Queries.VIEW_BOOK_BY_ISBN, isbn);
	    return rs;
	}

	// UPDATE BOOK
	public static void updateBook(String column, String newName, int isbn) throws ClassNotFoundException, SQLException, IOException
	{
		PrepareQuery.update("UPDATE BOOK SET "+column+" = ? WHERE ISBN = ?;", newName, isbn);
	}
	
	// SEARCH BOOKS (a-z)
	public static ResultSet searchBooks(String input) throws ClassNotFoundException, SQLException, IOException {
		String wildcard = "%";
		ResultSet rs = PrepareQuery.view(Queries.SEARCH_BOOKS, input+wildcard);
		return rs;
	}
}
