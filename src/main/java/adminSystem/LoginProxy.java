package adminSystem;

import java.util.ArrayList;

import database.*;

public class LoginProxy {
	
	private IDatabase localDatabase;
	private ArrayList<LoginCredentials> credentials;
	
	private LoginProxy() {
		this.localDatabase = new LocalDatabase();
		this.credentials = localDatabase.accessDatabase();
	}
	
	public static LoginProxy createLoginProxy() {
		return new LoginProxy();
	}
	
	public int run(String username, String password) {
		//Temporary Variable for Deliverable 1
		int validLogin = -1;
		//LocalDatabase is only for Deliverable 1
		
		for (int i = 0; i < this.credentials.size(); i++) {
			if (username.equals(this.credentials.get(i).getUsername())) {
				if (password.equals(this.credentials.get(i).getPassword())) {
					validLogin = i;
					break;
				}
				else {
					break;
				}
			}
		}
		return validLogin;
	}
}
