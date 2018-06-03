import java.util.ArrayList;

public class Search {
	private ArrayList<Book> books;
	public Book findBook(String bookName) throws RuntimeException {
		for(Book book : books){
			if(book.getBookName().equals(bookName)){
				return book;
	        }
		}
		throw new RuntimeException(bookName +" is not found");
	}
}