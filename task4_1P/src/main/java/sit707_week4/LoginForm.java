package sit707_week4;

public class LoginForm {

    private static String lastCode = null;

    public static LoginStatus login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return new LoginStatus(false, "Empty Username");
        }

        if (password == null || password.isEmpty()) {
            return new LoginStatus(false, "Empty Password");
        }

        if (username.equals("admin") && password.equals("admin123")) {
            lastCode = "123456"; 
            return new LoginStatus(true, lastCode);
        }

        return new LoginStatus(false, "Credential mismatch");
    }

    public static boolean validateCode(String code) {
        return code != null && code.equals(lastCode); 
        }
}