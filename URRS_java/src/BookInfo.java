
public class BookInfo {
	private String bookName;
	private BookState state;
	private int bookId;
	Book book = new Book(bookId);
	
	public BookInfo(String bookName) {
		this.setBookName(bookName);
		this.setState(BookState.Rentable);
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BookState getState() {
		return state;
	}

	public void setState(BookState state) {
		this.state = state;
	}
}
