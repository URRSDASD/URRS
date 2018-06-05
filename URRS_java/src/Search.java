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
	public void Search(String keyword, int category, int searchType) {
		this.keyword = keyword;
		this.category = category;
		this.searchType = searchType;

		/* 검색을 시행할 때마다 book instance를 비워준다. */
		bookList.emptyBookStack();
	}

	// ResultSet type 변수를 통해 key 값(컬럼이름)으로............
	// Book 배열을 리턴한다. (ResultSet -> books tables 내의 조건에 부합하는 튜플들을 참조)
	//	**********************************
	// SSD에서 newSearch의 파라미터 수정해야됨
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
		try {
			String sql;
			dc = new DbConnection();
			Connection conn = dc.Connect();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM books " +
					"WHERE 'bookId' =" + bookId;

			/* 외부 시스템으로부터 요청하는 요청문 */
			ResultSet rs = stmt.executeQuery(sql);

		} catch(SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}
	}

	public void askBook(int bookId) {

	}
}