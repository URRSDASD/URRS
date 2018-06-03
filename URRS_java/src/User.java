
public class User {
	private final int userId;
	private UserState state;
	
    public User(int userId) {
        this.userId = userId;
        this.state=state.ACCESS;
    }
}
