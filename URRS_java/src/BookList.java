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

	public void inputId(int bookId) {

	}

	public void addBook(int bookId, String bookName, String publisher, String author, BookState state) {
		boolean found = false;

		Book book = new Book(bookId, bookName, publisher, author, state);
		books.add(book);
	}
	public void emptyBookStack() {
		books.clear();
	}

}