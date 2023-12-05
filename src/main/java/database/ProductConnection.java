package database;

import java.util.ArrayList;

public class ProductConnection implements IDatabaseConnection{
	
	public ProductConnection() {
		
	}
	
	@Override
	public ArrayList connect() {
		return DB.getDb().getProduct();
	}

}
