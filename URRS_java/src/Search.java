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

	/* searchType�쓽 default value�뒗 4(�쟾泥닿��깋) */
	private int searchType = 4;
	private DbConnection dc;
	private BookList bookList = BookList.getInstance();
	private BookState bState;

	/* setCondition -> �궗�떎�긽 �깮�꽦�옄 */
	Search(String keyword, int category, int searchType) {
		this.keyword = keyword;
		this.category = category;
		this.searchType = searchType;

		/* 寃��깋�쓣 �떆�뻾�븷 �븣留덈떎 book instance瑜� 鍮꾩썙以��떎. */
		bookList.emptyBookStack();
	}

	// ResultSet type 蹂��닔瑜� �넻�빐 key 媛�(而щ읆�씠由�)�쑝濡�............
	// Book 諛곗뿴�쓣 由ы꽩�븳�떎. (ResultSet -> books tables �궡�쓽 議곌굔�뿉 遺��빀�븯�뒗 �뒠�뵆�뱾�쓣 李몄“)
	//	**********************************
	// SSD�뿉�꽌 newSearch�쓽 �뙆�씪誘명꽣 �닔�젙�빐�빞�맖
	public BookList newSearch() {
		try {
			String sql;
			dc = new DbConnection();
			Connection conn = dc.Connect();
			Statement stmt = conn.createStatement();

			// searchType 0 -> �젣紐⑹쑝濡� 寃��깋
			// searchType 1 -> ���옄濡� 寃��깋
			// searchType 2 -> 異쒗뙋�궗濡� 寃��깋
			// searchType 4 -> �쟾泥� 寃��깋 (default)

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

			/* �쇅遺� �떆�뒪�뀥�쑝濡쒕��꽣 �슂泥��븯�뒗 �슂泥�臾� */
			ResultSet rs = stmt.executeQuery(sql);


			/* �뵒鍮꾩뿉�꽌 integer濡� 諛쏆븘�삩 媛믪쓣 BookState媛믪쑝濡� 誘몃━ 諛곕떦 */
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

			/* �쇅遺� �떆�뒪�뀥�쑝濡쒕��꽣 �슂泥��븯�뒗 �슂泥�臾� */
			ResultSet rs = stmt.executeQuery(sql);

		} catch(SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		}
		
	}

	public void askBook(int bookId) {

	}
}