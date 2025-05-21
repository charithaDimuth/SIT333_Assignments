package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @param dob
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
	    if (username == null || password == null || dob == null) {
	        return false;
	    }

	    boolean isUsernameValid = "admin".equals(username);
	    boolean isPasswordValid = "1234".equals(password);
	    boolean isDobValid = "2000-01-01".equals(dob);

	    return isUsernameValid && isPasswordValid && isDobValid;
	}
	
}