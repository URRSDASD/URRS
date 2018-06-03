import java.util.ArrayList;

public class Rent {
	private ArrayList<RentalList> rList;
	private BookState state;
	
	public Rent() {
		this.rList = new ArrayList<RentalList>();
		this.state = BookState.Rentable;
	}
	
	public void rentBook(int bookId,int date) {
		preCondition();
		RentalList rList = new RentalList(bookId,date);
		this.rList.add(rList);
		postCondition();
	}
	
	public int getReturnDate(int date) {
		return date + 7;
	}
	
	private void preCondition() {
		if(state != BookState.Rented) {
			throw new RuntimeException("Already rented!");
		}	
	}
	private void postCondition() {
		for(RentalList rentalList : rList) {
			int remain = rentalList.getBook().getAvailableQty() - rentalList.getQuantity();
			rentalList.getBook().setAvailableQty(remain);
		}
		setState(BookState.Rented);
	}

	private void setState(BookState state) {
		this.state = state;
	}
}
