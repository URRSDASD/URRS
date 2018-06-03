
public class Rent {
	Book book;
	
	public Rent(User user, Book book) {
		this.book = book;
	}
	
	public int getBookId() { 
    	return book.bookId;
    }

}
