import java.util.ArrayList;

public class UserList {
	private static UserList sharedInstance;
	private ArrayList<Book> users;
	
	public UserList() { 
		users = new ArrayList<Book>();
	}
	public static synchronized UserList getInstance() {
		if(sharedInstance != null)
			return sharedInstance;
		sharedInstance = new UserList();
		return sharedInstance;
	}

}

