package database;

import java.util.ArrayList;
import java.util.Scanner;

import adminSystem.LoginCredentials;

import java.io.File;
import java.io.FileNotFoundException;

public class LocalDatabase implements IDatabase{

	public ArrayList<LoginCredentials> accessDatabase() {
		ArrayList<LoginCredentials> credentialList = new ArrayList<LoginCredentials>(); 
		try {
			Scanner fileReader = new Scanner(new File("Credentials"));
			while (fileReader.hasNextLine()) {
				String creds = fileReader.nextLine();
				String[] tmp = creds.split("@,@");
				credentialList.add(LoginCredentials.newLoginCredentials(tmp[0], tmp[1]));
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return credentialList;
	}
	
}

