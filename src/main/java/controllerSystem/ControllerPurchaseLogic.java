package ControllerSystem;

package controllerSystem;

import model.connector.ModelProductAccess;
import utilities.structure.ModelProductRequest;
import utilities.structure.Request;
import model.*;

public class ControllerPuchaseLogic {
	public static void puchase(ModelProductRequest request) {
		//Compare with model product list
		if (Model.getModel().getProductListing().get(request.getProductID()).getQuantity() > request.getProductAmount()) {
			//Model.getModel().getProductListing().get(request.getProductID()).setQuantity(
			//(Model.getModel().getProductListing().get(request.getProductID()).getQuantity())-(request.getProductAmount()));
			ModelProductAccess.accessModel(request);
			System.out.println("Order request completed");
		}
		
	}
}
