package utitls;

public class Queries {
	public final static String ADD_BOOK = "	INSERT INTO BOOK(BOOK,AUTHOR,ISBN) VALUES (?,?,?);";
	public final static String VIEW_BOOKS = " SELECT BOOK, AUTHOR, ISBN FROM BOOK WHERE IS_DELETED = 0 ORDER BY BOOK";
	public final static String VIEW_BOOK_BY_ISBN = " SELECT BOOK, AUTHOR, ISBN FROM BOOK WHERE ISBN = ? AND IS_DELETED = 0";
	public final static String UPDATE_BOOK = "UPDATE BOOK SET ? = ? WHERE ISBN = ?;";
	public final static String SEARCH_BOOKS = "SELECT BOOK,ISBN FROM BOOK WHERE LOWER(BOOK) LIKE ?";
	private final static String GET_CREDENTIALS = " SELECT PASSWORD,USERNAME,USER_ID FROM CREDENTIALS; ";
	public static String getGetCredentials() {
		return GET_CREDENTIALS;
	}
	
}
