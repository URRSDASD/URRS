import database.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Rent {
	private BookState bookState;
	private UserState userState;
	private DbConnection dc;
	private BookList bookList = BookList.getInstance();

	public Rent() {
		this.bookState = BookState.Rentable;
		this.userState = UserState.ACCESS;

		/* 검색을 시행할 때마다 book instance를 비워준다. */
		bookList.emptyBookStack();
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

		setbookState(BookState.Rented);
	}

	public Book inputIdentifier(int bookId) {
		return Search.selectBook(bookId);
	}

	/* inputIdentifier에서 반환받은 Book.getId 와 같은 식으로 파라미터에 전달 */
	public void askRent(String userId, int bookId) {
		try {
			String sql;
			dc = new DbConnection();
			Connection conn = dc.Connect();
			Statement stmt = conn.createStatement();

			sql = "UPDATE books SET userId =" + userId +
					"WHERE bookId=" + bookId;

			/* sql 명령어를 실행함으로써 update */
			stmt.executeQuery(sql);

			sql = "SELECT * FROM books WHERE bookId = " + bookId;

			ResultSet rs = stmt.executeQuery(sql);

			BookState bs = null;
			if(rs.getBoolean("bookState")){
				bs = BookState.Rentable;
			} else {
				bs = BookState.Rented;
			}


			/* rentallist 역할을 하는 bookList 스택 */
			bookList.addBook(
					rs.getInt("bookId"),
					rs.getString("rentedUserId"),
					rs.getString("bookName"),
					rs.getString("publisher"),
					rs.getString("author"),
					rs.getString("location"),
					bs);


		} catch(SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}
	}

	private void setbookState(BookState state) {
		this.bookState = state;
	}
}