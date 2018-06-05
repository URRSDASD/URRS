import java.util.ArrayList;

public class UserList {
	private static UserList sharedInstance;
	private ArrayList<User> users;
	
	public UserList() { 
		users = new ArrayList<User>();
	}
	public static synchronized UserList getInstance() {
		if(sharedInstance != null)
			return sharedInstance;
		sharedInstance = new UserList();
		return sharedInstance;
	}
	void addUser(String userId, String password, UserState state) {

		User user = new User(userId, password, state);
		users.add(user);
	}
}

