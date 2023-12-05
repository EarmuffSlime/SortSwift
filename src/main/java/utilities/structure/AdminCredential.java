package utilities.structure;

public class AdminCredential {
	private String username;
	private String password;
	
	private AdminCredential(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public static AdminCredential createAdmin(String username, String password) {
		return new AdminCredential(username, password);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
