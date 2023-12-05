package utilities.structure;

public class AdminCredential {
	private int id;
	private String username;
	private String password;
	
	private AdminCredential(int id, String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public static AdminCredential createAdmin(int id, String username, String password) {
		return new AdminCredential(id, username, password);
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
