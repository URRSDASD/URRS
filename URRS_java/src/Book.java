public class Book {
	private int bookId;
	private String bookName;
	private BookState state;
    public Book(int bookId) {
        this.bookId = bookId;
        this.setBookName(bookName);
		this.setState(BookState.Rentable);
    }
    
    public int getBookId() { 
    	return bookId;
    }

    public void setBookId(int bookId) {
    	this.bookId = bookId;
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
