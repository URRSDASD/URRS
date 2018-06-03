public class Book {
	private int bookId;
	private String bookName;
	private String publisher;
	private String author;
	private BookState state;
	private int availableQty; // Ã¥ Àç°í
	private int test;	

    public Book(int bookId) {
        this.bookId = bookId;
        this.setBookName(bookName);
		this.setState(BookState.Rentable);
		this.setAuthor(author);
		this.setPublisher(publisher);
		this.setAvailableQty(availableQty);
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
	
	public int getAvailableQty() { return availableQty;}
	
	public void setAvailableQty(int availableQty) {this.availableQty= availableQty;}
}