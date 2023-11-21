package adminSystem;

public class AdminLogin implements ILogin{

	@Override
	public String preform(String username, String password) {
		if (verifyUsername(username)) {
			if (verifyPassword(password)) {
				
			}
		}
		return null;
	}
	

	private boolean verifyUsername(String username) {
		return false;
	}
	

	private boolean verifyPassword(String password) {
		return false;
	}
}
