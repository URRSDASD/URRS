import java.util.ArrayList;

public class Authenticate {
	private String id;
	private String password;
	private static ArrayList<User> users = new ArrayList<>();
	public static Authenticate login(String id, String pass) throws Exception {
        for (User user : users) {
            if (user.id.equals(id) && user.password.equals(pass)) {
                return user;
            }
        }
        throw new Exception("로그인 실패!");
    }
}
