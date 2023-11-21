package adminSystem;

import java.util.Scanner;

public class LoginLoop {
	

	public LoginLoop() {
	}
	
	public int startLogin() {
		boolean validLogin = false;
		int adminID = -1;
		LoginProxy loginProxy = LoginProxy.createLoginProxy();
		Scanner input = new Scanner(System.in);
		while (!validLogin) {
			//Place Some sort of input here
			System.out.println("Enter Username");
			String username = input.nextLine();
			
			System.out.println("Enter Password");
			String password = input.nextLine();
			
			
			//call validation function
			
			adminID = loginProxy.run(username, password);
			
			//if validation function returns true
			if (adminID != -1) {
				System.out.println("Login Autheticated, Welcome " + username);
				//break loop
				validLogin = true;
			}
			//else try again
			else {
				System.out.println("Incorrect Login, Please Try Again");
			}
		}
		input.close();
		//Return adminID
		return adminID;
	}
}

