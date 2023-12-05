package modelSystem.functions;

import java.util.HashMap;

import modelSystem.Model;
import utilities.structure.ProductBasicInfo;
import utilities.structure.ProductInformation;
import utilities.structure.RestockRequest;
import modelSystem.observer.UpdatePublisher;

public class ModelUpdateProduct {
	
	public static void DecreaseStoredProducts(ProductBasicInfo request) {
		System.out.println("ModelUpdate1");
		HashMap<Integer, ProductInformation> productListing = Model.getModel().getProductListing();
		productListing.get(request.getProductID()).setQuantity(productListing.get(request.getProductID()).getQuantity()-request.getProductAmount());
		System.out.println("ModelUpdate2");
		UpdatePublisher.getPublisher().productNotify(request);
	}
	
	public static void IncreaseStoredProducts(RestockRequest request) {
		HashMap<Integer, ProductInformation> productListing = Model.getModel().getProductListing();
		productListing.get(request.getProductID()).setQuantity(productListing.get(request.getProductID()).getQuantity()+request.getProductAmount());
		UpdatePublisher.getPublisher().restockNotify(request);
	}
}
