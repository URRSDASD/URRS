
public class User {
	private final String userId;
	private final String passWord;
	private UserState userState;
    public User(String userId, String passWord) {
        this.userId = userId;
        this.passWord = passWord;
        this.userState = UserState.ACCESS;
    }

	public String getUserId() {
		return userId;
	}

	public String getPassWord() {
		return passWord;
	}
    
    
}
