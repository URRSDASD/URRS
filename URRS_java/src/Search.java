import java.sql.Statement;
import java.util.ArrayList;
import database.DbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	private String keyword;
	private int category;

	/* searchType의 default value는 4(전체검색) */
	private int searchType = 4;
	private DbConnection dc;
	private BookList bookList = BookList.getInstance();
	private BookState bState;

	/* setCondition -> 사실상 생성자 */
	Search(String keyword, int category, int searchType) {
		this.keyword = keyword;
		this.category = category;
		this.searchType = searchType;

		/* 검색을 시행할 때마다 book instance를 비워준다. */
		bookList.emptyBookStack();
	}

	public BookList newSearch() {
		try {
			String sql;
			dc = new DbConnection();
			Connection conn = dc.Connect();
			Statement stmt = conn.createStatement();

			// searchType 0 -> 제목으로 검색
			// searchType 1 -> 저자로 검색
			// searchType 2 -> 출판사로 검색
			// searchType 4 -> 전체 검색 (default)

			if (searchType == 0) {
				sql = "SELECT * FROM books " +
						"WHERE 'category' =" + category + "AND 'name' =" + keyword;
			} else if (searchType == 1) {
				sql = "SELECT * FROM books " +
						"WHERE 'category' =" + category + "AND 'author' =" + keyword;
			} else {
				sql = "SELECT * FROM books " +
						"WHERE 'category' =" + category + "AND 'publisher' =" + keyword;
			}

			/* 외부 시스템으로부터 요청하는 요청문 */
			ResultSet rs = stmt.executeQuery(sql);


			/* 디비에서 integer로 받아온 값을 BookState값으로 미리 배당 */
			while(rs.next()) {
				BookState bs = null;
				if(rs.getBoolean("bookState")){
					bs = BookState.Rentable;
				} else {
					bs = BookState.Rented;
				}

				bookList.addBook(rs.getInt("bookId"),
						rs.getString("bookName"),
						rs.getString("publisher"),
						rs.getString("author"),
						bs);
			}

		} catch (SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}

		return bookList;
	}

	public Book selectBook(int bookId) {
		Book book = null;

		try {
			String sql;
			dc = new DbConnection();
			Connection conn = dc.Connect();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM books " +
					"WHERE 'bookId' =" + bookId;

			/* 외부 시스템으로부터 요청하는 요청문 */
			ResultSet rs = stmt.executeQuery(sql);

			BookState bs = null;
			if(rs.getBoolean("bookState")){
				bs = BookState.Rentable;
			} else {
				bs = BookState.Rented;
			}

			book = new Book(rs.getInt("bookId"),
					rs.getString("bookName"),
					rs.getString("publisher"),
					rs.getString("author"),
					bs);

		} catch(SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}

		return book;
	}

	public void askBook(int bookId) {

	}
}