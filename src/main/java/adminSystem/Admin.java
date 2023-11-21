package adminSystem;

public class Admin {
	private String username;
	private String password;
	private String id;
	
	private Admin() {
		this.username = "";
		this.password = "";
		this.id = "";
	}
	
	private Admin(String id) {
		this.id = id;
		//Access database using ID and retrieve username and password;
		this.username = "";
		this.password = "";
	}
	
	public static Admin getAdminInstance() {
		return new Admin();
	}
	
	public static Admin getAdminInstance(String id) {
		return new Admin(id);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getid() {
		return this.id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setid(String id) {
		this.id = id;
	}
}
