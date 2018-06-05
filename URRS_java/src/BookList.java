import java.util.ArrayList;

public class BookList {
	private static BookList sharedInstance;
	private ArrayList<Book> books;
	
	public BookList() { 
		books = new ArrayList<Book>();
	}
	static synchronized BookList getInstance() {
		if(sharedInstance != null)
			return sharedInstance;
		sharedInstance = new BookList();
		return sharedInstance;
	}

	void addBook(int bookId, String rentedUserId,String bookName, String publisher,
						String author, String location, BookState state) {

		Book book = new Book(bookId, rentedUserId, bookName, publisher, author, location, state);
		books.add(book);
	}
	void emptyBookStack() {
		books.clear();
	}

}