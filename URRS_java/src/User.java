
public class User {
	private final int userId;
	private final int passWord;
	private UserState userState;
	
    public User(int userId, int passWord) {
        this.userId = userId;
        this.passWord = passWord;
        this.userState = userState.ACCESS;
    }

	public int getUserId() {
		return userId;
	}

	public int getPassWord() {
		return passWord;
	}
    
    
}
