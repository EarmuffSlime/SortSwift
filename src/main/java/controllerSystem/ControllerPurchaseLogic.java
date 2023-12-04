package controllerSystem;

import modelSystem.connector.ModelPurchase;
import utilities.structure.ModelProductRequest;
import modelSystem.*;

public class ControllerPurchaseLogic {
	public static void purchase(ModelProductRequest request) {
		//Compare with model product list
		if (Model.getModel().getProductListing().get(request.getProductID()).getQuantity() > request.getProductAmount()) {
			ModelPurchase modelPurchase = new ModelPurchase();
			modelPurchase.accessModel(request);
			System.out.println("Order request completed");
		}
		
	}
}
