import java.util.ArrayList;

public class BookList {
	private static BookList sharedInstance;
	private ArrayList<Book> books;
	
	public BookList() { 
		books = new ArrayList<Book>();
	}
	public static synchronized BookList getInstance() {
		if(sharedInstance != null)
			return sharedInstance;
		sharedInstance = new BookList();
		return sharedInstance;
	}
}