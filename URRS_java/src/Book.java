public class Book {
	private int bookId;
	private String rentedUserId = null;
	private String bookName;
	private String publisher;
	private String author;
	private String location;
	private BookState state;


	Book(int bookId, String rentedUserId, String bookName,
		 String publisher, String author, String location, BookState state) {

		this.bookId = bookId;
		this.rentedUserId = rentedUserId;
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
		this.location = location;
		this.state = state;

	}

	
    public int getBookId() {return bookId;}

    public void setBookId(int bookId) {this.bookId = bookId;}
   
	public String getBookName() {return bookName;}

	public void setBookName(String bookName) {this.bookName = bookName;}
	
	public String getPublisher() {return publisher;}

	public void setPublisher(String publisher) {this.publisher = publisher;}

	public String getAuthor() {return author;}

	public void setAuthor(String author) {this.author = author;}

	public BookState getState() {return state;}

	public void setState(BookState state) { this.state = state;}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRentedUserId() {
		return rentedUserId;
	}

	public void setRentedUserId(String rentedUserId) {
		this.rentedUserId = rentedUserId;
	}
}