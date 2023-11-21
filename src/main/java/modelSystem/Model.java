package modelSystem;

import java.util.HashMap;
import utilities.structure.*;

public class Model {
	private static Model instance;
	private HashMap<Integer, ProductInformation> productListing;
	
	private Model() {
		this.productListing = new HashMap<Integer, ProductInformation>();
		//Eventually insert a method to scrape database and upload products to the hashmap
	}
	
	public static Model getModel() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}
	
	public HashMap<Integer, ProductInformation> getProductListing(){
		return this.productListing;
	}
}
