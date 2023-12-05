package modelSystem.functions;

import java.util.ArrayList;
import java.util.HashMap;

import database.ProductConnection;
import modelSystem.Model;
import utilities.structure.ProductInformation;

public class ModelStart {
	public ModelStart() {
		
	}
	
	public void modelLoad() {
		
		ProductConnection connect = new ProductConnection();
		ArrayList<ProductInformation> productList = connect.connect();
		HashMap<Integer, ProductInformation> productHash = new HashMap<Integer, ProductInformation>();
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (int i = 0; i < productList.size(); i++) {
			productHash.put(productList.get(i).getProductID(), productList.get(i));
			idList.add(productList.get(i).getProductID());
		}
		Model.getModel().setidList(idList);
		Model.getModel().setProductListing(productHash);
	}

}
