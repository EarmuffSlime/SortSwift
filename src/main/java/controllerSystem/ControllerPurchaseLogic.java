package controllerSystem;

import modelSystem.connector.ModelProductAccess;
import utilities.structure.ModelProductRequest;
import modelSystem.*;

public class ControllerPurchaseLogic {
	public static void purchase(ModelProductRequest request) {
		//Compare with model product list
		if (Model.getModel().getProductListing().get(request.getProductID()).getQuantity() > request.getProductAmount()) {
			//Model.getModel().getProductListing().get(request.getProductID()).setQuantity(
			//(Model.getModel().getProductListing().get(request.getProductID()).getQuantity())-(request.getProductAmount()));
			ModelProductAccess.accessModel(request);
			System.out.println("Order request completed");
		}
		
	}
}
