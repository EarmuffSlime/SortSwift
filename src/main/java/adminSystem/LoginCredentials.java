package adminSystem;

public class LoginCredentials {
	private String username;
	private String password;
	
	
	private LoginCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public static LoginCredentials newLoginCredentials(String username, String password) {
		return new LoginCredentials(username, password);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
