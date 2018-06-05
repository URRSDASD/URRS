import java.util.ArrayList;

public class Rent {
	private ArrayList<RentalList> rList;
	private BookState bookState;
	private UserState userState;
	
	public Rent() {
		this.rList = new ArrayList<RentalList>();
		this.bookState = BookState.Rentable;
		this.userState = UserState.ACCESS;
	}
	
	public void rentBook(int bookId,int date) {
		preCondition();
		RentalList rList = new RentalList(bookId,date);
		this.rList.add(rList);
		postCondition();
	}
	
	private void preCondition() {
		if(userState != UserState.ACCESS) {
			throw new RuntimeException("Denyed rent!");
		}
		if(bookState != BookState.Rentable) {
			throw new RuntimeException("Already rented!");
		}	
	}
	private void postCondition() {
		for(RentalList rentalList : rList) {
			int remain = rentalList.getBook().getAvailableQty() - rentalList.getQuantity();
			rentalList.getBook().setAvailableQty(remain);
		}
		setbookState(BookState.Rented);
	}
	
	private void inputID() {
		
	}
	private void setbookState(BookState state) {
		this.bookState = state;
	}
}