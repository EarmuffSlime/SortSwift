package modelSystem.functions;

import java.util.HashMap;

import modelSystem.Model;
import utilities.structure.ProductInformation;
import modelSystem.observer.UpdatePublisher;

public class ModelUpdateProduct {
	
	public static void updateProducts(int productID, int amount) {
		HashMap<Integer, ProductInformation> productListing = Model.getModel().getProductListing();
		productListing.get(productID).setQuantity(productListing.get(productID).getQuantity()-amount);
		UpdatePublisher.getPublisher().notify(productListing.get(productID).getName(), amount);
	}
}
