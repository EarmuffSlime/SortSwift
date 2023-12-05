package modelSystem;

import java.util.ArrayList;
import java.util.HashMap;
import utilities.structure.*;

public class Model {
	private static Model instance;
	private HashMap<Integer, ProductInformation> productListing;
	private ArrayList<Integer> idList;
	
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
	
	public HashMap<Integer, ProductInformation> getProductListing() {
		return this.productListing;
	}
	
	public void setProductListing(HashMap<Integer, ProductInformation> newListing) {
		this.productListing = newListing;
	}
	
	public ArrayList<Integer> getidList() {
		return this.idList;
	}
	
	public void setidList(ArrayList<Integer> newidList) {
		this.idList = newidList;
	}
}
