
public class User {
	private final String userId;
	private final String passWord;
	private UserState userState;
    public User(String userId, String passWord, UserState state) {
        this.userId = userId;
        this.passWord = passWord;
        this.setUserState(UserState.ACCESS);
    }

	public String getUserId() {
		return userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}  
}