package database;

import java.util.ArrayList;

public class AdminConnection implements IDatabaseConnection{

	public AdminConnection() {
		
	}
	
	@Override
	public ArrayList connect() {
		return DB.getDb().getAdminsInfo();
	}

}
