import java.util.ArrayList;

public class Authenticate {
	private static ArrayList<User> users = new ArrayList<>();
	
	public static User login(String id, String pass) throws Exception {
        for (User user : users) {
            if (user.getUserId().equals(id) && user.getPassWord().equals(pass)) {
                return user;
            }
        }
        throw new Exception("로그인 실패!");
    }
}
