package passwordmanager;

public class Authenticator {
    public String[] users = {"Matt", "SecondUser","Admin"};
    public String[] passwords = {"password123", "pass2","Admin"};
    public boolean accountAdmin;

    public boolean checkPass(User user) {
        for (int i = 0; i < users.length; i++) {
            if (user.username.equals(users[i]) && user.password.equals(passwords[i])) {
                if (user.username.equals("Admin"))
                    accountAdmin = true;
                return true;
            }
        }
        return false;
    }
}