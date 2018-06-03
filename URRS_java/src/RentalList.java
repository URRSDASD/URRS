import java.util.ArrayList;
import java.util.List;

public class RentalList {
	private int quantity;
	private Book book;
	public RentalList(int bookId,int date) {
		BookList bookList = BookList.getInstance();
		this.quantity = qty;
		if(this.book.getAvailableQty() < qty) {
			throw new RuntimeException ("")
		}
	}
	public int getQuantity() { return quantity;}
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public Book getBook() { return book;}
}
